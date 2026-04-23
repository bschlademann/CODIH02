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
        int boardRowIndex = getBoardIndex(rowIndex, ROWS, "row index");
        int boardColIndex = getBoardIndex(colIndex, COLS, "column index");
        return board[boardRowIndex][boardColIndex];
    }

    private int getBoardIndex(int index, int max, String name) throws GameException {
        if (index < 1 || index > max) {
            throw new GameException(String.format("invalid %s: %d (erlaubt: 1 bis %d)", name, index, max));
        }
        return index - 1;
    }

    public void drop(int colIndex, Player player) throws GameException {
        int boardColIndex = getBoardIndex(colIndex, COLS, "column index");
        Token playerToken = player.getToken();
        int bottomRow = ROWS - 1;
        int topRow = 0;
        for (int boardRowIndex = bottomRow; boardRowIndex >= topRow; boardRowIndex--) {
            if (board[boardRowIndex][boardColIndex] == null) {
                board[boardRowIndex][boardColIndex] = playerToken;
                return;
            }
        }
        throw new GameException("the column is full, choose another column");
    }

    public boolean finished() {
        int leftColumn = 0;
        int rightColumn = COLS - 1;
        int bottomRow = ROWS - 1;
        int topRow = 0;

        for (int colIndex = leftColumn; colIndex <= rightColumn; colIndex++) {
            for (int rowIndex = bottomRow; rowIndex >= topRow; rowIndex--) {

                Token current = board[rowIndex][colIndex];

//                if cell is empty, a win condition from here is impossible
                if (current == null) {
                    break;
                }

                int currentColor = current.getColor();

//                check all directions
                if (checkRight(rowIndex, colIndex, currentColor, rightColumn)
                        || checkUpwardsRight(rowIndex, colIndex, currentColor, rightColumn)
                        || checkUpwards(rowIndex, colIndex, currentColor)
                        || checkUpwardsLeft(rowIndex, colIndex, currentColor)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkTokenColor(int color, int rowIndex, int colIndex) {
//        check if there is a token in this cell
        if (board[rowIndex][colIndex] == null) {
            return false;
        }
        int tokenColor = board[rowIndex][colIndex].getColor();
//        does the tokenColor match the currentColor
        return tokenColor == color;
    }

    private boolean checkRight(int rowIndex, int colIndex, int color, int rightColumn) {
        if (colIndex <= rightColumn - 3) {
            return checkTokenColor(color, rowIndex, colIndex + 1) &&
                    checkTokenColor(color, rowIndex, colIndex + 2) &&
                    checkTokenColor(color, rowIndex, colIndex + 3);
        }
        return false;
    }

    private boolean checkUpwardsRight(int rowIndex, int colIndex, int color, int rightColumn) {
        if (rowIndex >= 3 && colIndex <= rightColumn - 3) {
            return checkTokenColor(color, rowIndex - 1, colIndex + 1) &&
                    checkTokenColor(color, rowIndex - 2, colIndex + 2) &&
                    checkTokenColor(color, rowIndex - 3, colIndex + 3);
        }
        return false;
    }

    private boolean checkUpwards(int rowIndex, int colIndex, int color) {
        if (rowIndex >= 3) {
            return checkTokenColor(color, rowIndex - 1, colIndex) &&
                    checkTokenColor(color, rowIndex - 2, colIndex) &&
                    checkTokenColor(color, rowIndex - 3, colIndex);
        }
        return false;
    }

    private boolean checkUpwardsLeft(int rowIndex, int colIndex, int color) {
        if (rowIndex >= 3 && colIndex >= 3) {
            return checkTokenColor(color, rowIndex - 1, colIndex - 1) &&
                    checkTokenColor(color, rowIndex - 2, colIndex - 2) &&
                    checkTokenColor(color, rowIndex - 3, colIndex - 3);
        }
        return false;
    }
}
