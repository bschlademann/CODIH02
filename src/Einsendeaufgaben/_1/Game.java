package Einsendeaufgaben._1;

public abstract class Game {
    protected Player[] players;
    protected Gameboard board;

    public Game(String playerOne, String playerTwo) {
        this.players = new Player[2];
        players[0] = new Player(playerOne, new Token(1));
        players[1] = new Player(playerTwo, new Token(2));
        this.board = new Gameboard();
    }

    abstract void play();

    abstract void printBoard() throws GameException;

    abstract void printWinner(Player player);
}
