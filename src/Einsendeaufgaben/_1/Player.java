package Einsendeaufgaben._1;

/**
 * Die Klasse Player benötigt zwei private Instanzvariablen,
 * einen String für den Namen
 * und eine Variable vom Typ Token für die Spielsteine der Spielerin bzw. des Spielers.
 * Ergänzen Sie weiterhin einen Konstruktor mit zwei Parametern vom Typ String und Token,
 * der die Instanzvariablen damit initialisiert,
 * sowie zwei Getter-Methoden für die beiden Variablen.
 */
public class Player {
    private String name;
    private Token token;

    public Player(String name, Token token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public Token getToken() {
        return token;
    }
}
