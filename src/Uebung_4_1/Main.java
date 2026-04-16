package Uebung_4_1;

import java.util.Scanner;

/**
 * Erstellen Sie ein Programm, das ganzzahlige Werte von der Konsole einliest
 * bis „ende“ eingegeben wird,
 * die Summe der Zahlen berechnet
 * und diese am Schluss auf der Konsole ausgibt.
 * Gehen Sie dabei so vor,
 * dass Sie die Werte als String mit der Methode nextLine der Scanner-Klasse einlesen
 * und dann mit der Methode parseInt der Klasse Integer in eine Zahl umwandeln.
 * Die Methode parseInt wirft eine Exception vom Typ NumberFormatException aus,
 * wenn der String nicht in eine Zahl umgewandelt werden kann.
 * Fangen Sie diese Exceptions und geben Sie eine Fehlermeldung auf der Konsole aus.
 * Danach soll die Eingabe der Zahlen fortgesetzt werden.
 */

public class Main {
    void main() {
        String input = "";
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (runCondition(input)) {
            IO.print("enter and integer or 'quit': ");
            input = scanner.nextLine();
            try {
                if (!runCondition(input)) {
                    IO.println("final sum: " + sum);
                    break;
                }
                int parsedInput = Integer.parseInt(input);
                int oldSum = sum;
                sum += parsedInput;
                IO.println(oldSum + " + " + input + " = " + sum);
            } catch (NumberFormatException e) {
                IO.println('\'' + input + '\'' + " is not a valid integer");
            }
        }
    }

    boolean runCondition(String input) {
        return !input.equalsIgnoreCase("quit");
    }
}
