import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CheckersGamePOOLauncher {

    public static void main(String[] args)
    {
        CheckersGameGUIData checkersGameGUIData = new CheckersGameGUIData(Color.BLUE, Color.LIGHT_GRAY, Color.BLACK, Color.WHITE, 10);

        JFrame f = new CheckersGameGUI(checkersGameGUIData);

        setFrameConfig(f, "THIS IS SPARTA plein de dames !!!");
        f.setVisible(true);
    }
/*
    public CheckersGamePOOLauncher() {
        this.colorBlack = new Color(173, 0, 255);
        this.colorWhite = Color.RED;
        this.frame = setFrameConfig("This is SPARTA plein de dames !!!");

        this.checkersBoard = setCheckboard();
        this.frame.setPreferredSize(new Dimension(666, 666));
        this.frame.pack();
        this.frame.add(checkersBoard);
        this.frame.setVisible(true);
    }*/

    private static void setFrameConfig(JFrame f, String name)
    {
        f.setTitle(name);
        f.setSize(new Dimension(600,600));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
