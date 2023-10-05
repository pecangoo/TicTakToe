package Game;

import Game.service.*;

public final class Launcher {
    public static void main(String[] args) {
        Game game = new Game(new ComputerMove(),
                new DataPrinter(),
                new UserMove(),
                new WinnerVerifier(),
                new CellVerifier());
        game.start();
    }
}
