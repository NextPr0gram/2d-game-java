import game.Game;
import game.GameLoop;

public class Main {
    public static void main(String[] args) throws Exception {
        new Thread(new GameLoop(new Game(800, 600))).start();
    }
}