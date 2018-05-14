package controller;

import model.*;
import vue.CheckersGameGUIBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersgameController {

    private CheckersGameGUIData checkersGameGUIData;
    private CheckersGameGUIBoard checkersGameGUIBoard;
    private CheckersGameModel checkersGameModel;

    public CheckersgameController(CheckersGameGUIData checkersGameGUIData, CheckersGameModel checkersGameModel) {
        this.checkersGameGUIData = checkersGameGUIData;
        this.checkersGameGUIBoard = new CheckersGameGUIBoard(this.checkersGameGUIData);
        this.checkersGameModel = checkersGameModel;
        setCheckboard();
    }

    /**
     * Création et définition du damier et pions
     */
    private void setCheckboard()
    {

        checkersGameGUIBoard.setLayout(new GridLayout(checkersGameModel.getLength(), checkersGameModel.getLength()));
        for (int i = 0; i < checkersGameModel.getLength(); i++) {
            for (int j = 0; j < checkersGameModel.getLength(); j++) {
                SquareGUI panel;
                if ((i+j) % 2 == 0)
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
                checkersGameGUIBoard.add(panel);
            }
        }

        for (PieceModel pieceModel: checkersGameModel.getPieceList()) {
            PieceGUI pion = new PieceGUI(checkersGameGUIData, pieceModel.getPieceColor());
//            SquareGUI square = checkersGameGUIBoard.;
            pion.setPreferredSize(new Dimension(50, 50));
            pion.setOpaque(false);
            pion.addMouseListener(new PionSelectMouseListener());
            checkersGameGUIData.addObserver(pion);
            square.add(pion);
        }

        checkersGameGUIBoard.repaint();
    }

    /**
     * Déplacement d'un pion
     * @param caseDest : case de destination
     */
    public void movePiece(JPanel caseDest)
    {
        caseDest.add(checkersGameGUIBoard.getSelectedPieceGUI());
        checkersGameGUIBoard.repaint();
        checkersGameGUIBoard.setSelectedPieceGUI(null);
    }

    public CheckersGameGUIBoard getCheckersGameGUIBoard() {
        return checkersGameGUIBoard;
    }

    public CheckersGameGUIData getCheckersGameGUIData() {
        return checkersGameGUIData;
    }

    /**
     * classe listener associé à la case
     */
    class PionMoveMouseListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if(mouseEvent.getSource() instanceof JPanel && checkersGameGUIBoard.getSelectedPieceGUI() != null)
            {
                JPanel caseGUI = (JPanel) mouseEvent.getSource();
                if (caseGUI.getComponents().length == 0 && caseGUI.getBackground() == checkersGameGUIData.getColorBlackSquare())
                    movePiece(caseGUI);
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
                checkersGameGUIBoard.setSelectedPieceGUI(pieceGUI);
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
