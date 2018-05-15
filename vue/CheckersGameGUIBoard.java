package vue;

import controller.CheckersgameController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class CheckersGameGUIBoard extends JPanel {
    CheckersGameGUIData checkersGameGUIData;
    private int length;
    private JPanel selectedPieceGUI;       // Piece à déplacer
    private Map<Coord, SquareGUI> damier;
    private CheckersGameModel checkersGameModel;
    private CheckersgameController checkersgameController;

    public CheckersGameGUIBoard(CheckersGameGUIData checkersGameGUIData, CheckersGameModel checkersGameModel, CheckersgameController checkersgameController) {
        super();
        this.checkersGameGUIData = checkersGameGUIData;
        this.length = checkersGameGUIData.getLength();
        this.selectedPieceGUI = null;
        this.damier = new HashMap<Coord, SquareGUI>();
        this.checkersGameModel = checkersGameModel;
        this.checkersgameController = checkersgameController;
        setCheckboard();
    }

    /**
     * Création et définition du damier et pions
     */
    private void setCheckboard()
    {
        this.setLayout(new GridLayout(length, length));
        for (int ligne = 0; ligne < length; ligne++) {
            for (int colonne = 0; colonne < length; colonne++) {
                SquareGUI panel;
                if ((ligne+colonne) % 2 == 0)
                {
                    panel = new SquareGUI(checkersGameGUIData.getColorWhiteSquare(), new Coord(colonne, ligne));
                    panel.setBorder_couleur(checkersGameGUIData.getColorWhiteSquareBorder());
                }

                else
                {
                    panel = new SquareGUI(checkersGameGUIData.getColorBlackSquareBorder(), new Coord(colonne, ligne));
                    panel.setCouleur(checkersGameGUIData.getColorBlackSquare());
                }
                panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
                panel.addMouseListener(checkersgameController.new SquareListener());
                this.damier.put(new Coord(colonne, ligne), panel);
                this.add(panel);
            }
        }

       for (PieceModel pieceModel: checkersGameModel.getPieceList()) {
            PieceGUI pion = new PieceGUI(checkersGameGUIData, pieceModel.getPieceColor());
            SquareGUI square = damier.get(pieceModel.getCoord());
            pion.setCoord(pieceModel.getCoord());
            pion.setPreferredSize(new Dimension(50, 50));
            pion.setOpaque(false);
            pion.addMouseListener(checkersgameController.new PieceListener());
            checkersGameGUIData.addObserver(pion);
            square.add(pion);
        }

        this.repaint();
    }

    public JPanel getSelectedPieceGUI() {
        return selectedPieceGUI;
    }

    public void setSelectedPieceGUI(JPanel pieceGUI) {
        this.selectedPieceGUI = pieceGUI;
    }


}
