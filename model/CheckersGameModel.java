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
    }


/*    public static void main(String[] args) {
        LinkedList<Pawn> list = new LinkedList<Pawn>();
        list.add(new Pawn(new Coord(1,0), PieceColor.NOIR));
        list.add(new Pawn(new Coord(3,0), PieceColor.NOIR));
        list.add(new Pawn(new Coord(5,0), PieceColor.NOIR));
        list.add(new Pawn(new Coord(7,0), PieceColor.NOIR));
        list.add(new Pawn(new Coord(9,0), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,1), PieceColor.NOIR));
        list.add(new Pawn(new Coord(2,1), PieceColor.NOIR));
        list.add(new Pawn(new Coord(4,1), PieceColor.NOIR));
        list.add(new Pawn(new Coord(6,1), PieceColor.NOIR));
        list.add(new Pawn(new Coord(8,1), PieceColor.NOIR));
        list.add(new Pawn(new Coord(1,2), PieceColor.NOIR));
        list.add(new Pawn(new Coord(3,2), PieceColor.NOIR));
        list.add(new Pawn(new Coord(5,2), PieceColor.NOIR));
        list.add(new Pawn(new Coord(7,2), PieceColor.NOIR));
        list.add(new Pawn(new Coord(9,2), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,7), PieceColor.BLANC));
        list.add(new Pawn(new Coord(2,7), PieceColor.BLANC));
        list.add(new Pawn(new Coord(4,7), PieceColor.BLANC));
        list.add(new Pawn(new Coord(6,7), PieceColor.BLANC));
        list.add(new Pawn(new Coord(8,7), PieceColor.BLANC));
        list.add(new Pawn(new Coord(1,8), PieceColor.BLANC));
        list.add(new Pawn(new Coord(3,8), PieceColor.BLANC));
        list.add(new Pawn(new Coord(5,8), PieceColor.BLANC));
        list.add(new Pawn(new Coord(7,8), PieceColor.BLANC));
        list.add(new Pawn(new Coord(9,8), PieceColor.BLANC));
        list.add(new Pawn(new Coord(0,9), PieceColor.BLANC));
        list.add(new Pawn(new Coord(2,9), PieceColor.BLANC));
        list.add(new Pawn(new Coord(4,9), PieceColor.BLANC));
        list.add(new Pawn(new Coord(6,9), PieceColor.BLANC));
        list.add(new Pawn(new Coord(8,9), PieceColor.BLANC));

        Pawn pieceMoved = new Pawn(new Coord(0,8), PieceColor.NOIR);
        Pawn pieceTook = new Pawn(new Coord(0,9), PieceColor.NOIR);
        CheckersGameModel m1 = new CheckersGameModel((LinkedList) list, pieceMoved, pieceTook, new Coord(0,5), PieceColor.NOIR, PieceColor.BLANC, 10);
    }*/


    public CheckersGameModel(List<PieceModel> pieceList, PieceModel pieceToMove, PieceModel pieceToTake, Coord lastRevoveCoord, PieceColor currentColor, PieceColor unCurrentColor, int length) {
        this.pieceList = pieceList;
        this.pieceToMove = pieceToMove;
        this.pieceToTake = pieceToTake;
        this.lastRevoveCoord = lastRevoveCoord;
        this.currentColor = currentColor;
        this.unCurrentColor = unCurrentColor;
        this.length = length;

        System.out.println(this);
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

    public int getLength() {
        return length;
    }

    public List<PieceModel> getPieceList() {
        return pieceList;
    }

    public boolean isCurrentPlayer(Coord pieceCoord)
    {
        PieceModel pieceToCheck = findPiece(pieceCoord);
        if(currentColor.equals(pieceToCheck.getPieceColor()))
        {
            pieceToTake = pieceToCheck;
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
      if (pieceToTake.isMoveOk(targetCoord))
      {
          return ActionType.SIMPLEMOVE;
      }
      else
      {
          return ActionType.NOMOVE;
      }
    }
}
