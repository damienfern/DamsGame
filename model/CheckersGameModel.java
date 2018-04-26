package model;

import vue.CheckersGameGUI;

import java.util.ArrayList;
import java.util.Iterator;
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
        String value = "";
        ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();
        ArrayList<String> header = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            header.add(Integer.toString(i));
        }

        for (int i = 0; i < length; i++) {
            ArrayList<String> line = new ArrayList<String>();
            for (int j = 0; j < length; j++) {
                line.add("-----");
            }
            myList.add(line);
        }

        for (Iterator<PieceModel> i = pieceList.iterator(); i.hasNext();) {
            PieceModel item = i.next();
            ArrayList<String> a = myList.get(item.getY());
            a.set(item.getX(), item.toString());
            myList.set(item.getY(),a);
        }
        myList.add(0,header);

        for (int i = 0; i < length; i++) {

            value += myList.get(i).toString()+"\n";
        }

        return value;

        /*return "CheckersGameModel{\n" +
                "pieceList=" + pieceList +
                ", pieceToMove=" + pieceToMove +
                ", pieceToTake=" + pieceToTake +
                ", lastRevoveCoord=" + lastRevoveCoord +
                ", currentColor=" + currentColor +
                ", unCurrentColor=" + unCurrentColor +
                ", length=" + length +
                '}';*/
    }
}
