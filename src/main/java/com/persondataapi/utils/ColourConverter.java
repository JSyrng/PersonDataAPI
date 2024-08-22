package com.persondataapi.utils;

import java.util.Map;

public class ColourConverter {

    private static final Map<Integer, String> COLOUR = Map.of(
            1, "blau",
            2, "grün",
            3, "violett",
            4, "rot",
            5, "gelb",
            6, "türkis",
            7, "weiß"
    );

    public static String getColourNameById(int id) {
        return COLOUR.getOrDefault(id, "unbekannt");
    }

    public static Integer getIdByColourName(String name) {
        for (Map.Entry<Integer, String> entry : COLOUR.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(name)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
