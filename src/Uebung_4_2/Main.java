package Uebung_4_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Erstellen Sie ein Programm zur Berechnung der Fakultät einer positiven ganzen Zahl n,
 * diese ist definiert durch f (0) = 1 und f (n) = 1 * 2 * …* n für n > 0.
 * <p>
 * Erstellen Sie eine innere statische Klasse OverflowException,
 * die von der Klasse Exception abgeleitet wird.
 * Die Klasse soll einen Konstruktor besitzen, dieser hat einen Parameter vom Typ String,
 * der den Grund für die Exception angibt.
 * <p>
 * Implementieren Sie dann die Methode factorial zur Berechnung der Fakultät.
 * Die Methode hat einen Parameter n vom Typ int.
 * Berechnen Sie das Ergebnis in einer Variable vom Typ long
 * und überprüfen Sie während der Berechnung, ob der Wert größer als der maximale Wert einer Integer-Variablen ist.
 * Dieser ist durch die Konstante Integer.MAX_VALUE gegeben. Ist dies der Fall,
 * dann soll eine Exception der Klasse OverflowException ausgeworfen werden.
 * <p>
 * Implementieren Sie eine main-Methode, die einen Wert n von der Konsole einliest
 * und die Fakultät von n mit der Methode aus factorial berechnet.
 * Die main-Methode soll dabei die Exceptions vom Typ OverflowException auffangen.
 */
public class Main {
    void main() {
        long factorialResult = 0;

        Scanner scanner = new Scanner(System.in);
        IO.print("enter int: ");
        try {
            int n = scanner.nextInt();
            factorialResult = factorial(n);
            IO.println("factorial result: " + factorialResult);
        } catch (OverflowException e) {
            IO.println(e);
        } catch (InputMismatchException e) {
            IO.println("input mismatch @n: expected int");
        }
        scanner.close();
    }

    static class OverflowException extends Exception {
        public OverflowException(String message) {
            super(message);
        }
    }

    private static long factorial(int n) throws OverflowException {

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
            if (result > Integer.MAX_VALUE) {
                throw new OverflowException("int overflow @result: result > Integer.MAX_VALUE");
            }
        }
        return result;
    }
}
