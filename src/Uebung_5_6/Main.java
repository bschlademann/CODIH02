package Uebung_5_6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Erweitern Sie das Programm aus Übung 5.5 wie folgt,
 * sodass der Inhalt der HashMap zeilenweise in einer Textdatei mit dem Namen „Telefonbuch“ gespeichert
 * und von dort wieder eingelesen wird.
 * Der Name und die Telefonnummer eines Eintrags werden durch ein Komma getrennt.
 * Gehen Sie wie folgt vor:
 * • Prüfen Sie vor der Schleife, ob eine Datei mit dem Namen „Telefonbuch“ existiert.
 * Falls dies der Fall ist, dann lesen Sie den Inhalt aus der Datei ein
 * und fügen ihn in die HashMap ein.
 * • Speichern Sie nach Beenden der Schleife alle Einträge in der HashMap zeilenweise in einer Datei
 * mit dem Namen „Telefonbuch“. Der Name und die Telefonnummer eines Eintrags werden durch ein Komma getrennt.
 * Hinweis: Sie müssen die IOExceptions der Streamklassen bearbeiten oder weitergeben.
 */
public class Main {
    private static final HashMap<String, String> phoneBook = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String path = "src/Uebung_5_6/";
    private static final String fileName = "phonebook.txt";
    private static final String fileSource = path + fileName;

    void main() {
//
//        CASE 1: file does not exist
        if (!fileExists()) {
            System.out.printf("file %s not found\n", fileSource);
//            create empty file
            createFile();
        } else {
//            Case 2: file exists
//            load data from file line by line into phoneBook
            loadPhoneBook();
        }

        String input;
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
            input = scanner.nextLine().trim();
            switch (input) {
                case "add": {
                    addEntry();
                    updateFile();
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
                    updateFile();
                    break;
                case "remove":
                    removeEntry();
                    updateFile();
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

    private boolean fileExists() {
        Path path = Paths.get(fileSource);
        return Files.exists(path);
    }

    private void createFile() {
        try {
            Path filePath = Paths.get(fileSource);
            if (filePath.getParent() != null) {
                Files.createDirectories(filePath.getParent());
            }
            Files.createFile(filePath);
            System.out.printf("file %s created\n", fileSource);
        } catch (IOException e) {
            IO.println("Exception when creating file: " + e.getMessage());
        }
    }

    private void loadPhoneBook() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileSource))) {
            String line;
            while ((line = reader.readLine()) != null) {
//                reader.readLine() returns "" on empty lines and null on nonexistent ones
//                this check prevents throwing a line.length != 2 Exception on empty but existent lines
                if (line.isBlank()) continue;
                String[] content = line.split(",");
                if (content.length == 2) {
                    String name = content[0];
                    String number = content[1];
                    phoneBook.put(name, number);
                } else {
                    throw new Exception("invalid entry in file: line.length != 2");
                }
            }
        } catch (Exception e) {
            IO.println(e);
        }
    }

    private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileSource))) {
            for (String name : phoneBook.keySet()) {
                String number = phoneBook.get(name);
                writer.write(name + "," + number);
//              Zeilenumbruch hinzufügen
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
