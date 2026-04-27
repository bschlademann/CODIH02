package Einsendeaufgaben;

import java.util.Scanner;

/**
 * Die Klasse Main enthält eine main-Methode für den Programmstart.
 * Lesen Sie in der main-Methode die beiden Namen der Mitspielenden ein,
 * erzeugen Sie damit eine Instanz der Klasse ConsoleGame
 * und starten Sie dann das Spiel durch den Aufruf der Methode play.
 */
public class Main {
    void main() {

        try (Scanner scanner = new Scanner(System.in);) {
            IO.println("Name Player 1: ");
            String playerOne = scanner.nextLine();
            IO.println("Name Player 2: ");
            String playerTwo = scanner.nextLine();
            ConsoleGame consoleGame = new ConsoleGame(playerOne, playerTwo);
            consoleGame.play();
        } catch (Exception e) {
            IO.println(e);
        }
    }
}
