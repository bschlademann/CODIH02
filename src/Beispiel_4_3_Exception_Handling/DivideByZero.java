package Beispiel_4_3_Exception_Handling;

import java.util.Scanner;

public class DivideByZero {

    /**
     * Führt die Division aus.
     * 'throws Beispiel_4_3.DivideByZeroException' ist der Vertrag: Die Methode sagt,
     * dass sie diesen spezifischen Fehler auslösen kann.
     */
    public static double divide(double x, double y) throws DivideByZeroException {
        if (y == 0) {
            // Hier wird das Objekt unserer eigenen Exception-Klasse erstellt und geworfen.
            throw new DivideByZeroException();
        }
        return x / y;
    }

    /**
     * Die main-Methode reicht Exceptions der Oberklasse 'Exception' weiter (throws).
     */
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("x und y eingeben: ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            // Aufruf der Methode. Wenn y=0 ist, springt das Programm sofort zum catch-Block.
            double r = divide(x, y);
            System.out.println(x + " / " + y + " = " + r);

            // Dieser Fehler wird manuell geworfen, um den zweiten catch-Block zu testen.
            // Er ist vom Typ 'Exception', nicht 'Beispiel_4_3.DivideByZeroException'.
            throw new Exception("sonstiger Fehler");

        } catch (DivideByZeroException e) {
            // Dieser Block greift NUR bei unserer spezifischen Division-Exception.
            // Er gibt die Nachricht aus, die wir oben in 'super' definiert haben.
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // Dieser Block greift bei ALLEN anderen Exceptions (Polymorphie),
            // da 'Exception' die Mutter aller Exceptions ist.
            System.out.println("Exception wird nicht bearbeitet!");

            // 'throw e' wirft den Fehler wieder aus der main-Methode heraus.
            // Deshalb muss oben in Zeile 21 'throws Exception' stehen.
            throw e;
        }
    }
}