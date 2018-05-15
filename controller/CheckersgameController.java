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
            if(mouseEvent.getSource() instanceof SquareGUI && checkersGameGUIBoard.getSelectedPieceGUI() != null)
            {
                SquareGUI caseGUI = (SquareGUI) mouseEvent.getSource();
                Coord caseCoord = caseGUI.getCoord();
                System.out.println(caseCoord);
                if(checkersGameModel.movePiece(caseCoord).equals(ActionType.SIMPLEMOVE))
                {
                    PieceGUI piece = (PieceGUI) checkersGameGUIBoard.getSelectedPieceGUI();
                    piece.setCoord(caseCoord);
                    caseGUI.add(checkersGameGUIBoard.getSelectedPieceGUI());
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
            if (mouseEvent.getSource() instanceof JPanel) {
                System.out.println("PIONSELECT");
                PieceGUI pieceGUI = (PieceGUI) mouseEvent.getSource();
                if(checkersGameModel.isCurrentPlayer(pieceGUI.getCoord()))
                {
                    checkersGameGUIBoard.setSelectedPieceGUI(pieceGUI);
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
