package model;

public class Pawn extends AbstractPiece{


    public Pawn(Coord coord, PieceColor pieceColor) {
        super(coord, pieceColor);
    }

    public static void main(String[] args) {
        Pawn p1 = new Pawn(new Coord(3,3),PieceColor.BLANC);

        System.out.println("=================================");
        System.out.println("BLANC");
        System.out.println("=================================");
        // TEST BLANC
        System.out.println(new Coord(2, 2).toString() + " " + p1.isMoveOk(new Coord(2, 2)));
        System.out.println(new Coord(2, 4).toString() + " " + p1.isMoveOk(new Coord(2, 4)));
        System.out.println(new Coord(4, 2).toString() + " " + p1.isMoveOk(new Coord(4, 2)));
        System.out.println(new Coord(4, 4).toString() + " " + p1.isMoveOk(new Coord(4, 4)));
        System.out.println(new Coord(3, 2).toString() + " " + p1.isMoveOk(new Coord(3, 2)));
        System.out.println(new Coord(2, 3).toString() + " " + p1.isMoveOk(new Coord(2, 3)));
        System.out.println(new Coord(4, 3).toString() + " " + p1.isMoveOk(new Coord(4, 3)));
        System.out.println(new Coord(3, 4).toString() + " " + p1.isMoveOk(new Coord(3, 4)));

        Pawn p2 = new Pawn(new Coord(3,3),PieceColor.NOIR);
        System.out.println("=================================");
        System.out.println("NOIR");
        System.out.println("=================================");

        // TEST NOIR
        System.out.println(new Coord(2, 2) + " " + p2.isMoveOk(new Coord(2, 2)));
        System.out.println(new Coord(2, 4) + " " + p2.isMoveOk(new Coord(2, 4)));
        System.out.println(new Coord(4, 2) + " " + p2.isMoveOk(new Coord(4, 2)));
        System.out.println(new Coord(4, 4) + " " + p2.isMoveOk(new Coord(4, 4)));
        System.out.println(new Coord(3, 2) + " " + p2.isMoveOk(new Coord(3, 2)));
        System.out.println(new Coord(2, 3) + " " + p2.isMoveOk(new Coord(2, 3)));
        System.out.println(new Coord(4, 3) + " " + p2.isMoveOk(new Coord(4, 3)));
        System.out.println(new Coord(3, 4) + " " + p2.isMoveOk(new Coord(3, 4)));
    }


    @Override
    public boolean isMoveOk(Coord targetCoord) {
        int forward;
        if(getPieceColor().equals(PieceColor.BLANC))
        {
            forward = -1;
        }
        else
        {
            forward = 1;
        }
        boolean CondY = getY() + forward == targetCoord.getY();
        boolean CondX = ( targetCoord.getX() == getX() + 1 || targetCoord.getX() == getX() - 1);
        boolean Cond = CondY && CondX;

        if(Cond)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean isMoveOKWithCatch(Coord targetCoord, int deltaX, int deltaY, boolean isPieceToCatch) {
        return false;
    }
}
