import controller.CheckersgameController;
import model.CheckersGameGUIData;
import model.CheckersGameModel;
import model.Coord;
import model.PieceColor;
import vue.CheckersGameGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;


public class CheckersGamePOOMVC {

    public static void main(String[] args)
    {
        CheckersGameModel checkersGameModel = new CheckersGameModel(newBlackCoords(), newWhiteCoords(), 10, PieceColor.BLANC);
        System.out.println(checkersGameModel);
        Color beerus = new Color(173,0,255); // VIOLET
        CheckersGameGUIData checkersGameGUIData = new CheckersGameGUIData(Color.RED, beerus, Color.BLACK, Color.WHITE, Color.RED, beerus,10);

        CheckersgameController controler = new CheckersgameController(checkersGameGUIData, checkersGameModel);

        JFrame f = new CheckersGameGUI(controler);

        CheckersGamePOOMVC.setFrameConfig(f, "Ben & Dams");

        checkersGameGUIData.addObserver((Observer) f);

        f.setVisible(true);
    }

    /**
     * Fonction qui retourne un tableau de coordonnee des pions blanches
     * @return
     */
    private static Coord[] newWhiteCoords() {
        return new Coord[]{
                new Coord(0,7),
                new Coord(2,7),
                new Coord(4,7),
                new Coord(6,7),
                new Coord(8,7),
                new Coord(1,8),
                new Coord(3,8),
                new Coord(5,8),
                new Coord(7,8),
                new Coord(9,8),
                new Coord(0,9),
                new Coord(2,9),
                new Coord(4,9),
                new Coord(6,9),
                new Coord(8,9)
        };
    }

    /**
     * Fonction qui retourne un tableau de coordonnee des pions noirs
     * @return
     */
    private static Coord[] newBlackCoords() {
        return new Coord[]{
                new Coord(1,0),
                new Coord(3,0),
                new Coord(5,0),
                new Coord(7,0),
                new Coord(9,0),
                new Coord(0,1),
                new Coord(2,1),
                new Coord(4,1),
                new Coord(6,1),
                new Coord(8,1),
                new Coord(1,2),
                new Coord(3,2),
                new Coord(5,2),
                new Coord(7,2),
                new Coord(9,2)
        };
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
