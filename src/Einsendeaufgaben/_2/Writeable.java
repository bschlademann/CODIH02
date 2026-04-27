package Einsendeaufgaben._2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writeable ist ein generisches Interface für einen Datentyp T, das von dem Interface Iterable<T> abgeleitet ist.
 * Das Interface besitzt nur eine Methode write mit einem String als Parameter, der den Namen einer Datei angibt.
 * Erstellen Sie eine Default-Implementierung für diese Methode,
 * sodass sie mithilfe der drei Methoden aus dem Interface Iterable durch die Elemente der Liste iteriert
 * und die Werte zeilenweise in einer Textdatei mit dem Namen im Übergabeparameter speichert.
 * Wandeln Sie dazu jedes Element in der Liste mithilfe der toString-Methode in einen String um und speichern Sie den String in der Datei.
 */
public interface Writeable<T> extends Iterable<T> {
    default void write(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            this.reset();
            while (this.hasNext()) {
                writer.write(this.getNext().toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Exception while writing File: " + e.getMessage());
        }
    }
}