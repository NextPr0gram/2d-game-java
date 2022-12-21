import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    // JFrame is the window

    private Canvas canvas;

    public Display(int width, int height, Input input) {
        setTitle("Anaf's 2d Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas(); // blank rectangular area where user can draw
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack(); // calculates the size of the jFrame depending on its childrens sizes

        /*
         * A buffer strategy is an algorithm for managing the graphics buffer (memory).
         * A buffer strategy can hav one or more buffers.
         * A two buffer strategy means the Canvas had two buffers to temporarily store
         * graphics operations before they are displayed to the screen.
         * This reduces flickering and other visual artefacts and also increases
         * performance.
         */
        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null); // window will be centered
        setVisible(true);

    }

    public void render(Game game) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());



        /*
         * Casting
         * 
         * change one primitive data type to another.
         * Widening casting is done automatically, converts smaller type to larger type,
         * byte -> short -> char -> int -> long -> float -> double
         * example: int myInt = 9; double myDouble = myInt;
         * 
         * Widening casing is done manually, converts larger type into smaller type,
         * double -> float -> long -> int -> char -> short -> byte
         * example: double myDouble = 9.78d; int myInt = (int) myDouble;
         */
        game.getGameObjects().forEach(gameObject -> graphics.drawImage(
            gameObject.getSprite(),
            gameObject.getPosition().getX(),
            gameObject.getPosition().getY(),
            null
        ));

        graphics.dispose();
        bufferStrategy.show();


    }

}