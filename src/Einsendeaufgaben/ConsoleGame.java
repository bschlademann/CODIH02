package Einsendeaufgaben;

import java.util.Scanner;

import static Einsendeaufgaben.Gameboard.COLS;
import static Einsendeaufgaben.Gameboard.ROWS;

/**
 * Die Klasse ConsoleGame wird von der Klasse Game abgeleitet.
 * Ergänzen Sie dort einen Konstruktor mit den gleichen Parametern wie beim Konstruktor der Oberklasse.
 * Implementieren Sie dann die drei abstrakten Methoden der Oberklasse wie folgt:
 * <p>
 * Die Methode play ist für den Spielablauf zuständig. Führen Sie hier die Spielrunden aus,
 * indem Sie abwechselnd die Mitspielenden auffordern, eine Spaltennummer einzugeben und einen Wert von der Konsole einzulesen.
 * Fügen Sie mithilfe der Methode drop einen Spielstein der Spielerin bzw. des Spielers in der Eingabespalte ein
 * und zeichnen Sie anschließend das Spielfeld mithilfe der Methode printBoard.
 * Fangen Sie dabei die Exceptions, die durch eine falsche Eingabe entstehen, auf
 * und wiederholen Sie in diesem Fall die Konsoleneingabe.
 * Prüfen Sie nach einer gültigen Eingabe mithilfe der Methode finished, ob das Spiel beendet ist,
 * und geben Sie in diesem Fall die Siegerin oder den Sieger mithilfe der Methode printWinner aus.
 * Falls alle Spielrunden ohne Siegerin oder Sieger durchlaufen wurden, wird zum Schluss die Methode printWinner mit dem Wert null ausgeführt.
 * <p>
 * Die Methode printBoard gibt das Spielfeld auf der Konsole aus.
 * Über und unter dem Spielfeld sollen die Spaltennummern von 1 bis COLS ausgegeben werden.
 * Geben Sie dabei die gelben Spielsteine als ‚x‘ und die roten Spielsteine als ‚o‘ aus.
 * Ausnahmen vom Typ GameException sollen von der Methode nicht gefangen werden.
 * <p>
 * Die Methode printWinner erhält eine Variable vom Typ Player
 * und gibt den Namen der Spielerin oder des Spielers als Gewinnerin bzw. Gewinner auf der Konsole aus.
 * Ist der Parameter null, dann endet das Spiel unentschieden.
 */
public class ConsoleGame extends Game {
    public ConsoleGame(String playerOne, String playerTwo) {
        super(playerOne, playerTwo);
    }

    @Override
    void play() {
        int maxMoves = ROWS * COLS;
        int currentMove = 0;
        Player winner = null;
        Scanner scanner = new Scanner(System.in);

        while (currentMove < maxMoves) {
            Player currentPlayer = players[currentMove % 2];
            boolean validTurn = false;

            while (!validTurn) {
                try {
                    IO.print(String.format("%s, enter column (1-%d): ", currentPlayer.getName(), COLS));

                    if (!scanner.hasNextInt()) {
                        IO.println("Invalid input. Please enter a number.");
                        scanner.next();
                        continue;
                    }

                    int col = scanner.nextInt();
                    board.drop(col, currentPlayer);
                    printBoard();

                    validTurn = true;
                } catch (GameException e) {
                    IO.println(e.getMessage());
                }
            }

            if (board.finished()) {
                winner = currentPlayer;
                break;
            }

            currentMove++;
        }

        printWinner(winner);
    }

    @Override
    void printBoard() throws GameException {
        Gameboard board = this.board;
        StringBuilder boardString = new StringBuilder();

        for (int rowIndex = 1; rowIndex <= ROWS; rowIndex++) {
            boardString.append("\n");
            for (int colIndex = 1; colIndex <= COLS; colIndex++) {

                String tokenSymbol = " ";
                Token token = board.getToken(rowIndex, colIndex);
                boolean hasToken = token != null;
                if (hasToken) {
                    switch (token.getColor()) {
                        case Token.RED:
                            tokenSymbol = "x";
                            break;
                        case Token.YELLOW:
                            tokenSymbol = "o";
                            break;
                    }
                }
                boardString.append(String.format(" %s ", tokenSymbol));
            }
        }
        IO.print(getColumnNumbers());
        IO.println(boardString);
        IO.println(getColumnNumbers());
    }

    @Override
    void printWinner(Player winner) {
        String message = "The game ended in a tie.";
        if (winner != null) {
            message = String.format("Player %s has won the game.", winner.getName());
        }
        IO.println(message);
    }

    String getColumnNumbers() {
        StringBuilder columnNumbers = new StringBuilder();
        for (int colIndex = 1; colIndex <= COLS; colIndex++) {
            columnNumbers.append(" ").append(colIndex).append(" ");
        }
        return columnNumbers.toString();
    }
}
