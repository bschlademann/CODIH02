package Beispiel_5_9_Writing_and_Reading_Files;

import java.io.*; // Importiert die notwendigen I/O-Klassen für den Dateizugriff

public class Main {
    // throws IOException: Notwendig, da Dateioperationen (z.B. Festplatte voll, Datei fehlt) Fehler werfen können
    public static void main(String[] args) throws IOException {

        // Erstellt einen FileWriter für "hello.txt" und umschließt ihn mit einem 8KB-Puffer.
        // Der BufferedWriter sammelt Daten im RAM, statt für jedes Zeichen die Festplatte zu kontaktieren.
        BufferedWriter writer = new BufferedWriter(new FileWriter("hello.txt"));

        // Schleife schreibt 10 Zeilen in den Puffer.
        // Die Daten liegen hier meist noch im RAM und nicht physisch auf der Platte.
        for (int i = 1; i <= 10; i++)
            writer.write("Zeile " + i + "\n");

        // Schließt den Stream. WICHTIG: Erzwingt das Schreiben des Puffer-Inhalts ("Flush")
        // auf die Festplatte und gibt Systemressourcen frei.
        writer.close();

        // Erstellt einen BufferedReader, um die Datei effizient zu lesen.
        // Lädt beim Start direkt ein 8KB-Häppchen der Datei in den RAM-Puffer.
        BufferedReader reader = new BufferedReader(new FileReader("hello.txt"));

        String s;
        // readLine() sucht im Puffer nach einem Zeilenumbruch.
        // Wenn der Puffer leer ist, wird das nächste 8KB-Paket von der Platte nachgeladen.
        // Die Schleife läuft, bis readLine() 'null' liefert (Ende der Datei).
        while ((s = reader.readLine()) != null)
            System.out.println(s); // Gibt die eingelesene Zeile in der Konsole aus

        // Idealerweise sollte hier auch 'reader.close();' stehen, um den Lesestrom zu schließen.
    }
}