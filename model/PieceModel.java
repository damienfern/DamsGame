package model;

public interface PieceModel {
    public boolean isMoveOk(Coord targetCoord);

    public boolean isMoveOKWithCatch(Coord targetCoord, int deltaX, int deltaY, boolean isPieceToCatch);

    public Coord getCoord();
    public int getX();
    public int getY();
    public void setCoord(Coord pieceCoord);
    public PieceColor getPieceColor();

}
