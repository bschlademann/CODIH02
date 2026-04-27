package Einsendeaufgaben._2;

/**
 * Iterable ist ebenfalls ein generisches Interface für einen Datentyp T und besitzt drei abstrakte Methoden reset, hasNext und getNext.
 * Alle drei Methoden haben keine Parameter. Die Methode reset besitzt auch keinen Rückgabewert,
 * die Methode hasNext gibt einen Wert vom Typ boolean zurück und die Methode getNext einen Wert von dem generischen Typ T.
 * Eine Klasse, die dieses Interface implementiert, soll über diese drei Methoden eine Iteration durch die Elemente in der Liste ermöglichen.
 * reset setzt dazu die Iteratorposition auf das erste Element der Liste,
 * hasNext prüft, ob noch ein weiteres Element in der Liste vorhanden ist
 * und getNext gibt das Element an der aktuellen Iteratorposition zurück und setzt die Position auf das nachfolgende Element.
 */
public interface Iterable<T> {
    void reset();

    boolean hasNext();

    T getNext();
}