# Übersicht

### Projektbeschreibung

Kleine Spring-Boot-Anwendung zur Verwaltung von Personen und deren Lielingsfarbe. Die Daten werden in einer CSV-Datei gespeichert, die folgendermaßen formatiert ist: `Vorname, Nachname, Postleitzahl Stadt, Farbe`.
Den Farben sind IDs zugeordnet:

* 1: "blau"
* 2: "grün"
* 3: "violett"
* 4: "rot"
* 5: "gelb"
* 6: "türkis"
* 7: "weiß"

### Schnittstellenübersicht

* **GET /persons/{id}**: Liefert die Informationen zu einer Person basierend auf der ID.

* **POST /persons**: Fügt eine neue Person hinzu. Dies kann folgendermaßen über einen curl-Befehl geschehen:

  ```bash
  curl -X POST http://localhost:2000/create -H "Content-Type: application/json" -d '{"firstName":"Max", "lastName":"Mustermax", "zipcode":"12345", "city":"Stadt", "colour":"2"}'

* **PUT /persons/{id}**: Aktualisiert die Informationen einer bestehenden Person.
* **DELETE /persons/{id}**: Löscht eine Person basierend auf der ID.
### Verwendete Technologien
* Spring Boot: Framework zur Erstellung der Anwendung.
* Maven: Build-Management-Tool.
* CSV-Handling: Für das Laden und Speichern von Daten.