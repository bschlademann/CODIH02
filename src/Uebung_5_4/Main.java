package Uebung_5_4;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Erstellen Sie ein Programm, das eine Ziehung der Lottozahlen simuliert.
 * Implementieren Sie dazu die beiden folgenden statischen Methoden:
 * a)
 * Die Methode ZiehungListe soll die Ziehung mithilfe einer Instanz der Klasse ArrayList durchführen.
 * Fügen Sie dazu die Zahlen 1 bis 49 in die Liste ein.
 * Danach werden 100-mal zwei zufällige Elemente in der Liste getauscht.
 * Erzeugen Sie dazu zwei Zufallszahlen zwischen 0 und 48 mithilfe der Methode Math.random.
 * Zum Schluss werden die ersten sechs Elemente in der Liste als Gewinnzahlen auf der Konsole ausgegeben.
 * b)
 * Die Methode ZiehungMenge soll eine Instanz der Klasse TreeSet verwenden
 * und so lange zufällige Zahlen zwischen 1 und 49 in die Menge einfügen, bis dort sechs Werte enthalten sind.
 * Die Werte in der Menge werden zum Schluss wieder als Gewinnzahlen ausgegeben.
 */
public class Main {
    void main() {
        List<Integer> list = drawFromList();
        IO.println("list: " + list);
        TreeSet<Integer> treeSet = drawFromSet();
        IO.println("treeSet: " + treeSet);

    }

    public static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static List<Integer> drawFromList() {
        return new LottoNumberList(49).shuffle(100).drawAndSort(6);
    }

    public static TreeSet<Integer> drawFromSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            treeSet.add(
                    getRandomNumber(1, 49)
            );
        }
        return treeSet;
    }
}
