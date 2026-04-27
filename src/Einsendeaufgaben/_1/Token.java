package Einsendeaufgaben._1;

/**
 * Die Klasse Token benötigt eine private Instanzvariable vom Typ int für die Farbe des Spielsteins.
 * Legen Sie zwei öffentliche, statische Konstanten YELLOW und RED für die Farben der Spielsteine an.
 * Implementieren Sie einen Konstruktor mit einem Parameter zum Initialisieren der Instanzvariable
 * und eine Getter-Methode, die den Wert der Instanzvariable zurückgibt.
 */
public class Token {
    private int color;
    public static final int RED = 1;
    public static final int YELLOW = 2;

    public Token(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
