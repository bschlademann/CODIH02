package Einsendeaufgaben._2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * QueueList ist eine generische Klasse für einen Parameter T.
 * Diese Klasse wird von der API-Klasse LinkedList abgeleitet und implementiert die beiden Interfaces Queue und Writeable.
 * Die Methode enqueue aus dem Interface Queue soll den Übergabewert am Ende der verketteten Liste einfügen,
 * die Methode dequeue entnimmt den ersten Wert aus der Queue und gibt ihn zurück.
 * Prüfen Sie in der Methode dequeue, ob die Liste leer ist, und werfen Sie in diesem Fall eine Exception vom Typ NoSuchElementException aus.
 * Die Methode isEmpty gibt den Wert true bzw. false zurück, wenn die Queue leer bzw. nicht leer ist.
 * Weiterhin müssen noch die drei Methoden aus dem Interface Iterable implementiert werden.
 * Legen Sie dazu eine private Instanzvariable vom Typ int für die aktuelle Iteratorposition an
 * und initialisieren Sie die Variable mit 0. Implementieren Sie dann die drei Methoden reset, hasNext und getNext aus dem Interface Iterable.
 * Die erste Methode setzt die Iteratorposition auf den Anfang zurück, die zweite Methode prüft,
 * ob die Iteratorposition noch nicht auf das Ende der Liste zeigt
 * und die dritte Methode gibt das Element an der aktuellen Iteratorposition zurück
 * und setzt die Position auf das nachfolgende Element.
 * Prüfen Sie zuvor, ob das Ende der Liste erreicht wurde und werfen Sie in diesem Fall eine Exception vom Typ IndexOutOfBoundsException aus.
 */
public class QueueList<T> extends LinkedList<T> implements Queue<T>, Writeable<T> {

    private int iteratorPosition = 0;

    @Override
    public void enqueue(T element) {
        this.addLast(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void reset() {
        this.iteratorPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return iteratorPosition < this.size();
    }

    @Override
    public T getNext() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("End of List reached.");
        }
        return this.get(iteratorPosition++);
    }
}