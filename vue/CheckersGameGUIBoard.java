package vue;

import model.CheckersGameGUIData;
import model.PieceColor;
import model.PieceGUI;
import model.SquareGUI;

import javax.swing.*;
import java.awt.*;

public class CheckersGameGUIBoard extends JPanel {
    CheckersGameGUIData checkersGameGUIData;
    private int length;
    private JPanel selectedPieceGUI;       // Piece à déplacer

    public CheckersGameGUIBoard(CheckersGameGUIData checkersGameGUIData) {
        super();
        this.checkersGameGUIData = checkersGameGUIData;
        this.length = checkersGameGUIData.getLength();
        this.selectedPieceGUI = null;
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

    public void updatePionColor(){

    }

}
