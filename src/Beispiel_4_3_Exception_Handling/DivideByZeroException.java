package Beispiel_4_3_Exception_Handling;

/**
 * Eine benutzerdefinierte Exception-Klasse.
 * Sie erbt von 'Exception'. Dadurch ist sie eine "checked exception",
 * was bedeutet, dass der Compiler prüft, ob sie behandelt wird.
 */
class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        // 'super' ruft den Konstruktor der Oberklasse (Exception) auf
        // und speichert dort die Fehlermeldung.
        super("divide by zero");
    }
}
