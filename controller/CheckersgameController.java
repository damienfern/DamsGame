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
        this.checkersGameGUIBoard = new CheckersGameGUIBoard(this.checkersGameGUIData, checkersGameModel);
        this.checkersGameModel = checkersGameModel;

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



}
