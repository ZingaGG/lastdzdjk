package Main;

import Game.Game;


public class Main {
    public static void main(String[] args) {
        Game game = new Game(1000);
        game.runGames();
        game.printStatistics();
    }
}
