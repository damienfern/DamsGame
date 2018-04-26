package model;

public class Pawn extends AbstractPiece{


    public Pawn(Coord coord, PieceColor pieceColor) {
        super(coord, pieceColor);
    }

    public static void main(String[] args) {
        Pawn p1 = new Pawn(new Coord(5,7),PieceColor.NOIR);
        System.out.println(p1);
        Queen q1 = new Queen(new Coord(5,7), PieceColor.NOIR);
        System.out.println(q1);
    }


    @Override
    public boolean isMoveOk(Coord targetCoord) {
        return false;
    }

    @Override
    public boolean isMoveOKWithCatch(Coord targetCoord, int deltaX, int deltaY, boolean isPieceToCatch) {
        return false;
    }
}
