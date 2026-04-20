package Uebung_5_2;

import java.util.Scanner;

/**
 * Erstellen Sie ein Programm, das Namen von der Konsole einliest
 * und die Namen sortiert in einen String-Buffer einfügt;
 * zwei Namen werden dabei durch ein Komma getrennt.
 * Lesen Sie so lange die Namen von der Konsole ein, bis der Text „Ende“ eingegeben wurde.
 * <p>
 * Durchlaufen Sie für jeden neuen Namen, den Sie einlesen, den String-Buffer von links nach rechts,
 * bis Sie einen gespeicherten Namen finden, der alphabetisch hinter dem neuen Namen steht,
 * und fügen Sie den Namen mit einem Komma an dieser Position ein.
 * Löschen Sie zum Schluss das Komma hinter dem letzten Namen
 * und geben Sie den String im String-Buffer auf der Konsole aus.
 */

public class Main {
    void main() {
        Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer();
        IO.println("enter name (or 'quit'): ");
        String message = "buffer is empty";

        while (true) {
            String newName = scanner.nextLine().trim();
            if (newName.equalsIgnoreCase("quit")) break;
            if (buffer.isEmpty()) {
                buffer.append(newName).append(',');
            } else {


                int startPosition = 0;
                boolean inserted = false;

                for (int i = 0; i < buffer.length(); i++) {

                    if (buffer.charAt(i) == ',') {

                        String substring = buffer.substring(startPosition, i);
                        if (newName.compareToIgnoreCase(substring) < 0) {
                            buffer.insert(startPosition, newName + ',');
                            inserted = true;
                            break;
                        }
                        startPosition = i + 1;
                    }
                }
//          name was alphabetically not in front of any name in buffer
                if (!inserted) {
                    buffer.append(newName).append(',');
                }
            }
        }

        scanner.close();

        if (!buffer.isEmpty()) {
//          remove trailing ',' in buffer
            buffer.deleteCharAt(buffer.length() - 1);
            message = buffer.toString();
        }
//        print either buffer of "buffer is empty"
        IO.println(message);
    }
}