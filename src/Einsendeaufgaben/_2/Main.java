package Einsendeaufgaben._2;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Erstellen Sie eine Klasse Main mit einer main-Methode und erstellen Sie in dieser Methode eine Queue für den Datentyp Integer.
 * Fügen Sie dann zehn zufällige Zahlen zwischen 1 und 100 in die Queue ein und speichern Sie den Inhaltder Queue in einer Textdatei.
 * Holen Sie zum Schluss alle Werte aus der Queue und geben Sie die Werte auf der Konsole aus.
 */

public class Main {
    QueueList<Integer> queue = new QueueList<>();

    void main() {
        enqueueNumbers(10, 1, 100);

        String packagePath = "src" + File.separator + "Einsendeaufgaben" + File.separator + "_2" + File.separator;
        String fileName = "queue_content.txt";

        queue.write(packagePath + fileName);

        IO.println("file was saved at: " + packagePath + fileName);

        IO.println("values in queue:");
        while (!queue.isEmpty()) {
            IO.println(queue.dequeue());
        }
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private void enqueueNumbers(int count, int min, int max) {
        for (int i = 0; i < count; i++) {
            queue.enqueue(getRandomNumber(min, max));
        }
    }
}