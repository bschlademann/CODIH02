package Einsendeaufgaben;

/**
 * Die Klasse GameBoard besitzt eine private Instanzvariable für ein zweidimensionales Feld vom Typ Token.
 * Legen Sie zwei öffentliche, statische Konstanten ROWS und COLS
 * für die Anzahl der Zeilen und der Spalten des Spielfeldes an
 * und erzeugen Sie damit das Spielfeld.
 * <p>
 * Implementieren Sie dann in der Klasse die folgenden Instanzmethoden:
 * Die Methode getToken besitzt zwei Parameter vom Typ int für den Zeilenindex (von 1 bis ROWS)
 * und den Spaltenindex (von 1 bis COLS) und gibt den Spielstein in der Zeile und Spalte zurück.
 * Ist ein Index ungültig, dann wird eine Ausnahme vom Typ GameException ausgeworfen.
 * Die Methode drop hat keinen Rückgabewert und erhält einen Parameter vom Typ int
 * und einen Parameter vom Typ Player.
 * Der erste Parameter gibt die Spaltennummer als Wert zwischen 1 und COLS an.
 * Speichern Sie in der zugehörigen Spalte im ersten freien Platz einen Spielstein von der Spielerin bzw. dem Spieler
 * im zweiten Parameter.
 * Ist der Spaltenindex ungültig oder in der Spalte kein freies Feld vorhanden,
 * dann soll die Methode eine Ausnahme vom Typ GameException auswerfen.
 * Die Methode finished hat keine Parameter und einen Rückgabewert vom Typ boolean.
 * Sie überprüft, ob eine Spielerin oder ein Spieler das Spiel gewonnen hat,
 * und gibt in diesem Fall den Wert true zurück.
 * Durchlaufen Sie dazu alle Zeilen und Spalten des Feldes und prüfen Sie für jede Position,
 * ob die folgenden drei Felder die gleiche Farbe haben wie das aktuelle Feld.
 * Sie müssen dazu vier Richtungen nach oben, nach rechts, diagonal nach links-oben
 * und diagonal nach rechts-oben untersuchen.
 */

public class Gameboard {
    private Token[][] board;
    public static final int ROWS = 6;
    public static final int COLS = 7;

    public Gameboard() {
        this.board = new Token[ROWS][COLS];
    }
    public Token getToken(int rowIndex, int colIndex) throws GameException {
        validateIndex(rowIndex, ROWS, "row index");
        validateIndex(colIndex, COLS, "column index");
        return board[rowIndex - 1][colIndex - 1];
    }

    private void validateIndex(int index, int max, String name) throws GameException {
        if (index < 1 || index > max) {
            throw new GameException(String.format("invalid %s: %d (erlaubt: 1 bis %d)", name, index, max));
        }
    }
}
