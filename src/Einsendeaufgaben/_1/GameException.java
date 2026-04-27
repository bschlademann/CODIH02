package Einsendeaufgaben._1;

/**
 * Die Klasse GameException wird von der API-Klasse Exception abgeleitet
 * und besitzt einen Konstruktor vom Typ String, der den Grund für die Ausnahme angibt.
 * Rufen Sie mit dem Parameter den Konstruktor der Oberklasse auf.
 */
public class GameException extends Exception {
    public GameException(String message) {
        super(message);
    }
}
