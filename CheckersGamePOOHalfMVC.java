import controller.CheckersgameController;
import model.CheckersGameGUIData;
import vue.CheckersGameGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;


public class CheckersGamePOOHalfMVC {

    public static void main(String[] args)
    {
        Color beerus = new Color(173,0,255); // VIOLET
        CheckersGameGUIData checkersGameGUIData = new CheckersGameGUIData(Color.RED, beerus, Color.BLACK, Color.WHITE, Color.RED, beerus,10);

        CheckersgameController controler = new CheckersgameController(checkersGameGUIData);

        JFrame f = new CheckersGameGUI(controler);

        CheckersGamePOOHalfMVC.setFrameConfig(f, "Ben & Dams");

        checkersGameGUIData.addObserver((Observer) f);

        f.setVisible(true);
    }

    /**
     * Création et définition de la fenetre
     * @param f : fenetre
     * @param name : nom de la fenetre
     */
    private static void setFrameConfig(JFrame f, String name)
    {
        f.setTitle(name);
        f.setSize(new Dimension(600,600));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
