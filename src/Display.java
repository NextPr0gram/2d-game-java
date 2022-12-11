import javax.swing.JFrame;
import java.awt.*;

public class Display extends JFrame{
    //JFrame is the window

    private Canvas canvas;

    public Display(int width, int height){
        setTitle("Anaf's 2d Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas(); //blank rectangular area where user can draw
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        pack(); //calculates the size of the jFrame depending on its childrens sizes
        setLocationRelativeTo(null); //window will be centered
        setVisible(true);


    }

}