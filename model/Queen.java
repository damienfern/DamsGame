package model;

/**
 * Classe model pour les reines (Non utilisé ATM)
 */
public class Queen extends AbstractPiece {

    public Queen(Coord coord, PieceColor pieceColor) {
        super(coord, pieceColor);
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
