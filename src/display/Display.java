package display;

import javax.swing.JFrame;

import game.Game;
import input.Input;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    // JFrame is the window

    private Canvas canvas;
    private Renderer renderer;

    public Display(int width, int height, Input input) {
        setTitle("Anaf's 2d Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.renderer = new Renderer();

        canvas = new Canvas(); // blank rectangular area where user can draw
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack(); // calculates the size of the jFrame depending on its childrens sizes
        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null); // window will be centered
        setVisible(true);

    }

    public void render(Game game) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        renderer.render(game, graphics);

        graphics.dispose();
        bufferStrategy.show();

    }

}