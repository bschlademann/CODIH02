package Uebung_5_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Erstellen Sie ein Programm, das ein Feld mit 50 Integerwerten anlegt
 * und das Feld mit Zufallszahlen zwischen 0 und 999 füllt.
 * Die Zufallszahlen lassen sich mit der Methode Math.random erzeugen.
 * Erzeugen Sie dann zwei Teilfelder mit allen Werten im Feld, die kleiner bzw. größer als 500 sind,
 * und geben Sie zum Schluss die beiden Teilfelder auf der Konsole aus.
 * Gehen Sie dabei so vor, dass Sie zunächst das Feld sortieren
 * und dann mithilfe der Methode binarySearch die Position des Wertes 500 suchen.
 * Bestimmen Sie aus dem Rückgabewert den Index des letzten Elements im unteren Teilfeld
 * und den Index des ersten Elements im oberen Teilfeld.
 */
public class Main {

    void main() {
        try {
            Scanner scanner = new Scanner(System.in);
            IO.print("length Array: ");
            int arrayLength = scanner.nextInt();
            IO.println("max random number: ");
            int max = scanner.nextInt();
            int[] sortedIntArray = IntStream
                    .generate(() -> getRandomNumber(max))
                    .limit(arrayLength)
                    .sorted()
                    .toArray();
            IO.println("number to split at: ");
            int key = scanner.nextInt();
            scanner.close();
            if (key > max) {
                throw new Exception("number to split at is bigger than biggest possible number in array");
            }
            int keyPosition = Arrays.binarySearch(sortedIntArray, key);
            int splitPosition = (keyPosition >= 0) ? keyPosition : -(keyPosition + 1);
            int[] left = Arrays.copyOfRange(sortedIntArray, 0, splitPosition);
            int[] right = Arrays.copyOfRange(sortedIntArray, splitPosition, sortedIntArray.length);
            IO.println("sortedIntArray: " + Arrays.toString(sortedIntArray));
            IO.println("left: " + Arrays.toString(left));
            IO.println("right: " + Arrays.toString(right));
        } catch (Exception e) {
            IO.println(e);
        }
    }

    private int getRandomNumber(int max) {
        return (int) Math.floor(Math.random() * (max + 1));
    }
}
