package Einsendeaufgaben;

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

    }

    @Override
    void printBoard() throws GameException {

    }

    @Override
    void printWinner(Player player) {

    }


}
