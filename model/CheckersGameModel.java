package model;

import vue.CheckersGameGUI;

import javax.swing.*;
import java.rmi.NoSuchObjectException;
import java.util.*;

public class CheckersGameModel {

    private List<PieceModel> pieceList; // la liste de pièces noires et blanches
    private PieceModel pieceToMove;     // la pièce à déplacer (changement de coord)
    private PieceModel pieceToTake;     // la pièce à capturer (suppression de la liste)
    private Coord lastRevoveCoord;      // coordonnées de la dernière piece capturée
    private PieceColor currentColor, unCurrentColor;
    private int length;                 // le nombre de lignes et colonnes du damier

    public CheckersGameModel(Coord[] blackPieceTab, Coord[] whitePieceTab, int length, PieceColor firstPlayer) {
        this.currentColor = firstPlayer;
        this.pieceList = new LinkedList<PieceModel>();
        this.length = length;
        for (Coord coord : blackPieceTab) {
            pieceList.add(new Pawn(coord, PieceColor.NOIR));
        }

        for (Coord coord : whitePieceTab) {
            pieceList.add(new Pawn(coord, PieceColor.BLANC));
        }

        if(firstPlayer.equals(PieceColor.NOIR))
        {
            unCurrentColor = PieceColor.BLANC;
        }
        else
        {
            unCurrentColor = PieceColor.NOIR;
        }
    }

    @Override
    public String toString() {
        String value = "";
        ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();
        ArrayList<String> header = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            header.add("--"+Integer.toString(i)+"--");
        }

        for (int i = 0; i < length; i++) {
            ArrayList<String> line = new ArrayList<String>();
            for (int j = 0; j < length; j++) {
                line.add("-----");
            }
            myList.add(line);
        }

        for (PieceModel piece : pieceList) {
            ArrayList<String> a = myList.get(piece.getY());
            a.set(piece.getX(), piece.toString());
            myList.set(piece.getY(),a);
        }
        myList.add(0,header);

        for (int i = 0; i <= length; i++) {

            value += myList.get(i).toString()+"\n";
        }

        return value;
    }

    private PieceModel findPiece(Coord coord){
        for (PieceModel pieceModel : this.pieceList) {
            if (pieceModel.getCoord().equals(coord)) {
                return pieceModel;
            }
        }
        return null;
    }

    public List<PieceModel> getPieceList() {
        return pieceList;
    }

    public boolean isCurrentPlayer(Coord pieceCoord)
    {
        PieceModel pieceToCheck = findPiece(pieceCoord);
        if(currentColor.equals(pieceToCheck.getPieceColor()))
        {
            pieceToMove = pieceToCheck;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Déplacement d'un pion
     * @param targetCoord : case de destination
     */
    public ActionType movePiece(Coord targetCoord)
    {
      if (pieceToMove.isMoveOk(targetCoord) && isCurrentPlayer(pieceToMove.getCoord()))
      {
          pieceToMove.setCoord(targetCoord);
          int indexPieceMoved = pieceList.indexOf(pieceToMove);
          pieceList.set(indexPieceMoved, pieceToMove);
          pieceToMove = null;
          PieceColor save = unCurrentColor;
          unCurrentColor = currentColor;
          currentColor = save;
          return ActionType.SIMPLEMOVE;
      }
      else
      {
          return ActionType.NOMOVE;
      }
    }
}
