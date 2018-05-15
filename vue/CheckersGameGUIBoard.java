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

    public CheckersGameGUIBoard(CheckersGameGUIData checkersGameGUIData, CheckersGameModel checkersGameModel) {
        super();
        this.checkersGameGUIData = checkersGameGUIData;
        this.length = checkersGameGUIData.getLength();
        this.selectedPieceGUI = null;
        this.damier = new HashMap<Coord, SquareGUI>();
        this.checkersGameModel = checkersGameModel;
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
                    panel = new SquareGUI(checkersGameGUIData.getColorBlackSquare());
                    panel.setBorder_couleur(checkersGameGUIData.getColorBlackSquareBorder());
                }

                else
                {
                    panel = new SquareGUI(checkersGameGUIData.getColorWhiteSquareBorder());
                    panel.setCouleur(checkersGameGUIData.getColorWhiteSquare());
                }
                panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
                panel.addMouseListener(new PionMoveMouseListener());
                this.damier.put(new Coord(colonne, ligne), panel);
                this.add(panel);
            }
        }

       for (PieceModel pieceModel: checkersGameModel.getPieceList()) {
            PieceGUI pion = new PieceGUI(checkersGameGUIData, pieceModel.getPieceColor());
            SquareGUI square = damier.get(pieceModel.getCoord());
            pion.setPreferredSize(new Dimension(50, 50));
            pion.setOpaque(false);
            pion.addMouseListener(new PionSelectMouseListener());
            checkersGameGUIData.addObserver(pion);
            square.add(pion);
        }

        this.repaint();
    }

    public int getLength() {
        return length;
    }

    public JPanel getSelectedPieceGUI() {
        return selectedPieceGUI;
    }

    public void setSelectedPieceGUI(JPanel pieceGUI) {
        this.selectedPieceGUI = pieceGUI;
    }

    public JPanel getCheckersGUIBoard()
    {
        return this;
    }

    /**
     * classe listener associé à la case
     */
    class PionMoveMouseListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if(mouseEvent.getSource() instanceof JPanel && getSelectedPieceGUI() != null)
            {
                JPanel caseGUI = (JPanel) mouseEvent.getSource();
                if (caseGUI.getComponents().length == 0 && caseGUI.getBackground() == checkersGameGUIData.getColorBlackSquare())
                {
                    System.out.println("OK");
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    /**
     * classe listener associé au pion
     */
    class PionSelectMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getSource() instanceof JPanel) {
                JPanel pieceGUI = (JPanel) mouseEvent.getSource();
                setSelectedPieceGUI(pieceGUI);
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
