package Einsendeaufgaben._2;

/**
 * Queue ist ein generisches Interface für einen Datentyp T und hat drei abstrakte Methoden enqueue, dequeue und isEmpty.
 * Die erste Methode besitzt einen Parameter vom Datentyp T und keinen Rückgabewert.
 * Die anderen beiden Methoden haben keine Parameter, der Rückgabewert der Methode dequeue ist vom Typ T,
 * während die Methode isEmpty einen Wert vom Typ boolean zurückgibt.
 */
public interface Queue<T> {
    void enqueue(T element);

    T dequeue();

    boolean isEmpty();
}
