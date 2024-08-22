package com.persondataapi.utils;

import com.persondataapi.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvDataHandler {

    private static final String FILE_PATH = "src/main/resources/sample-input.csv";

    public List<Person> loadData() {
        List<String[]> data = readCsvWithoutOpenCsv();
        return convertToPersons(data);
    }

    private List<String[]> readCsvWithoutOpenCsv() {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma and trim spaces
                String[] values = line.split(",", -1);
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private List<Person> convertToPersons(List<String[]> data) {
        List<Person> persons = new ArrayList<>();

        for (String[] nextLine : data) {
            if (nextLine.length >= 4) { // Ensure we have at least 4 elements
                Person person = new Person();
                person.setFirstName(nextLine[0]);
                person.setLastName(nextLine[1]);
                person.setZipcode(nextLine[2].replaceFirst(".*?(\\d{5})", "$1").substring(0, 5));
                person.setCity(nextLine[2].replaceFirst(".*?(\\d{5})", "").trim());
                person.setColour(ColourConverter.getColourNameById(Integer.parseInt(nextLine[3].trim())));
                persons.add(person);
            } else {
                System.out.println("Skipped due to insufficient data: " + String.join(", ", nextLine));
            }
        }

        return persons;
    }

    public void savePersonToCsv(Person person) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Construct the CSV line
            String sb = person.getFirstName() + "," +
                    person.getLastName() + "," +
                    person.getZipcode() + " " + person.getCity() + "," +
                    person.getColour();

            // Write the line to the file
            printWriter.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
