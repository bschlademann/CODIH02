package Uebung_5_5;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Erstellen Sie ein Programm zum Verwalten eines Telefonbuchs.
 * Ein Eintrag im Telefonbuch besteht aus einem Namen zusammen mit der Telefonnummer.
 * Zum Speichern des Telefonbuchs soll eine HashMap eingesetzt werden,
 * der Wert ist die Telefonnummer und der Datenwert ist der Schlüssel.
 * Das Programm stellt vier Operationen zur Verfügung:
 * • das Einfügen eines neuen Eintrags in das Telefonbuch
 * • das Suchen nach einem Namen im Telefonbuch
 * • die Ausgabe aller Einträge im Telefonbuch
 * • das Beenden des Programms
 * Gehen Sie wie folgt vor: Legen Sie in der main-Methode eine HashMap für zwei Strings an.
 * Führen Sie dann eine Schleife aus, in der Sie die vier Möglichkeiten auf der Konsole anzeigen
 * und eine Auswahl einlesen.
 * Bearbeiten Sie dann die Auswahl wie folgt:
 * • Lesen Sie von der Konsole den Namen und die Telefonnummer für den neuen Eintrag ein
 * und speichern Sie die Eingabe als neues Paar in der HashMap.
 * • Lesen Sie einen Namen von der Konsole ein
 * und suchen Sie nach einem Eintrag mit diesem Namen.
 * Ist ein Eintrag vorhanden, dann geben Sie die Telefonnummer auf der Konsole aus,
 * andernfalls soll eine Meldung erfolgen, dass kein Eintrag zu dem Namen gefunden wurde.
 * • Geben Sie alle Einträge im Telefonbuch zeilenweise auf der Konsole aus,
 * der Name und die Telefonnummer werden dabei durch ein Doppelpunkt getrennt.
 */
public class Main {
    private static final HashMap<String, String> phoneBook = new HashMap<>();
        private static final Scanner scanner = new Scanner(System.in);

    void main() {
        phoneBook.put("a", "1");
        phoneBook.put("b", "2");
        String input = "";
        boolean runCondition = true;
        while (runCondition) {
            System.out.print("""
                    
                    (add): add new entry to phonebook
                    (update): update existing entry in phonebook
                    (remove): remove existing entry from phonebook
                    (search): search for a number by name
                    (show): show all entries
                    (quit): quit program
                    please select:""");
            input = scanner.nextLine();
            switch (input) {
                case "add": {
                    addEntry();
                }
                break;
                case "search":
                    searchName();
                    break;
                case "show":
                    showAllEntries();
                    break;
                case "update":
                    updateEntry();
                    break;
                case "remove":
                    removeEntry();
                    break;
                case "quit":
                    runCondition = false;
                    break;
                default:
                    IO.println("invalid entry");
            }
        }
        scanner.close();
        IO.println("scanner closed");
    }

    private void addEntry() {
        IO.print("enter name: ");
        String name = scanner.nextLine();
        if (phoneBook.containsKey(name)) {
            IO.println("entry already exists, use (update)");
        } else {
            IO.print("enter number: ");
            String number = scanner.nextLine();
            phoneBook.put(name, number);
        }
    }

    private void updateEntry() {
        IO.print("enter name: ");
        String name = scanner.nextLine();
        if (!phoneBook.containsKey(name)) {
            IO.println("entry does not exist, use (add)");
        } else {
            IO.print("update number: ");
            String number = scanner.nextLine();
            phoneBook.put(name, number);
        }
    }

    private void removeEntry() {
        IO.print("enter name to delete: ");
        String name = scanner.nextLine();
        if (!phoneBook.containsKey(name)) {
            IO.println("entry does not exist");
        } else {
            phoneBook.remove(name);
            IO.println("entry deleted");
        }
    }


    public void searchName() {
        IO.print("search for name: ");
        String name = scanner.nextLine();
        String message = "name not found";
        if (phoneBook.containsKey(name)) {
            message = "name found, number: " + phoneBook.get(name);
        }
        IO.println(message);
    }

    public void showAllEntries() {
        IO.println(phoneBook);
    }
}
