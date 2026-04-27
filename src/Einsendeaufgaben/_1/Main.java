package Einsendeaufgaben._1;

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
            IO.print("Name Player 1 (playing \u001B[31mx\u001B[0m): ");
            String playerOne = scanner.nextLine();
            IO.print("Name Player 2 (playing \u001B[33mo\u001B[0m): ");
            String playerTwo = scanner.nextLine();
            IO.println("You can quit the game by entering \"quit\" in the column selection.");
            ConsoleGame consoleGame = new ConsoleGame(playerOne, playerTwo);
            consoleGame.play();
        } catch (Exception e) {
            IO.println(e);
        }
    }
}
