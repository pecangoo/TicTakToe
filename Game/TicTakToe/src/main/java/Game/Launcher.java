package Game;

public final class Launcher {
    public static void main(String[] args) {
        Game game = new Game(new ComputerMove(),
                new DataPrinter(),
                new UserMove(),
                new WinnerVerifier(),
                new DrawVerifier());
        game.start();
    }
}
