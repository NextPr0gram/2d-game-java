package game;
public class GameLoop implements Runnable {

    private Game game;

    private boolean running;
    private double updateRate = 1.0 / 60.0;
    private long nextStatTime;
    private int fps, ups;

    public GameLoop(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        /*
         * The game loop tracks the time that has passed since the last update and
         * rendering,
         * and updates the game state and renders the game at a fixed rate based on the
         * value
         * of the updateRate
         */

        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000.0;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            if (accumulator >= updateRate) {
                while (accumulator > updateRate) {
                    update();
                    accumulator -= updateRate;
                }
                render();
            }

            // printStats();
        }
    }

    private void printStats() {
        if (System.currentTimeMillis() > nextStatTime) {
            System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
            ups = 0;
            fps = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;
    }

    private void render() {
        game.render();
        fps++;
    }

}