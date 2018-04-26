package model;

import vue.CheckersGameGUI;

import java.util.LinkedList;
import java.util.List;

public class CheckersGameModel {

    private List<PieceModel> pieceList; // la liste de pièces noires et blanches
    private PieceModel pieceToMove;     // la pièce à déplacer (changement de coord)
    private PieceModel pieceToTake;     // la pièce à capturer (suppression de la liste)
    private Coord lastRevoveCoord;      // coordonnées de la dernière piece capturée
    private PieceColor currentColor, unCurrentColor;
    private int length;                 // le nombre de lignes et colonnes du damier

    public CheckersGameModel(Coord[] coords, Coord[] coords1, int i, PieceColor blanc) {

    }

    public static void main(String[] args) {
        LinkedList<Pawn> list = new LinkedList<Pawn>();
        list.add(new Pawn(new Coord(0,1), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,2), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,3), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,4), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,5), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,6), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,7), PieceColor.NOIR));
        list.add(new Pawn(new Coord(0,8), PieceColor.NOIR));
        Pawn pieceMoved = new Pawn(new Coord(0,8), PieceColor.NOIR);
        Pawn pieceTook = new Pawn(new Coord(0,9), PieceColor.NOIR);
        CheckersGameModel m1 = new CheckersGameModel((LinkedList) list, pieceMoved, pieceTook, new Coord(0,5), PieceColor.NOIR, PieceColor.BLANC, 10);
    }


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
        return "CheckersGameModel{" +
                "pieceList=" + pieceList +
                ", pieceToMove=" + pieceToMove +
                ", pieceToTake=" + pieceToTake +
                ", lastRevoveCoord=" + lastRevoveCoord +
                ", currentColor=" + currentColor +
                ", unCurrentColor=" + unCurrentColor +
                ", length=" + length +
                '}';
    }
}
