package controller;

import model.*;
import vue.CheckersGameGUIBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class CheckersgameController {

    private CheckersGameGUIData checkersGameGUIData;
    private CheckersGameGUIBoard checkersGameGUIBoard;
    private CheckersGameModel checkersGameModel;

    public CheckersgameController(CheckersGameGUIData checkersGameGUIData, CheckersGameModel checkersGameModel) {
        this.checkersGameGUIData = checkersGameGUIData;
        this.checkersGameGUIBoard = new CheckersGameGUIBoard(this.checkersGameGUIData, checkersGameModel, this);
        this.checkersGameModel = checkersGameModel;

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
    public class SquareListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            /**
             * Vérification que la source de l'évenement est une SquareGUI et qu'un pion a été sélectionné avant
             */
            if(mouseEvent.getSource() instanceof SquareGUI && checkersGameGUIBoard.getSelectedPieceGUI() != null)
            {
                SquareGUI caseGUI = (SquareGUI) mouseEvent.getSource(); // Récupération de la case de destination
                Coord caseCoord = caseGUI.getCoord(); // Récup des coord de destination
                System.out.println(caseCoord); // Affichage des coords
                if(checkersGameModel.movePiece(caseCoord).equals(ActionType.SIMPLEMOVE)) // Si movePiece renvoie l'action SIMPLEMOVE
                {
                    PieceGUI piece = (PieceGUI) checkersGameGUIBoard.getSelectedPieceGUI(); // Récup du pion sélectionné
                    piece.setCoord(caseCoord);
                    caseGUI.add(checkersGameGUIBoard.getSelectedPieceGUI()); // Ajout du pion dans la case
                    checkersGameGUIBoard.setSelectedPieceGUI(null);
                    checkersGameGUIBoard.repaint();
                    System.out.println(checkersGameModel);
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
    public class PieceListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            /**
             * Vérification que la source de l'évenement est un pion
             */
            if (mouseEvent.getSource() instanceof PieceGUI) {
                System.out.println("PIONSELECT");
                PieceGUI pieceGUI = (PieceGUI) mouseEvent.getSource();
                if(checkersGameModel.isCurrentPlayer(pieceGUI.getCoord())) // Si c'est au tour du joueur
                {
                    checkersGameGUIBoard.setSelectedPieceGUI(pieceGUI); // mise à jour de la piece sélectionnée
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

}
