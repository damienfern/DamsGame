package model;

abstract class AbstractPiece implements PieceModel{
    private Coord coord;
    private PieceColor pieceColor;

    public AbstractPiece(Coord coord, PieceColor pieceColor) {
        this.coord = coord;
        this.pieceColor = pieceColor;
    }

    @Override
    public abstract boolean isMoveOk(Coord targetCoord);

    @Override
    public abstract boolean isMoveOKWithCatch(Coord targetCoord, int deltaX, int deltaY, boolean isPieceToCatch);

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "coord=" + coord +
                ", pieceColor=" + pieceColor +
                '}';
    }

    @Override
    public Coord getCoord() {
        return coord;
    }

    @Override
    public int getX() {
        return coord.getX();
    }

    @Override
    public int getY() {
        return coord.getY();
    }

    @Override
    public void setCoord(Coord pieceCoord) {
        this.coord = pieceCoord;
    }

    @Override
    public PieceColor getPieceColor() {
        return pieceColor;
    }
}
