import java.awt.*;

public class CheckersGameGUIData {
    private Color colorBlackPiece;
    private Color colorWhitePiece;
    private Color colorBlackSquare;
    private Color colorWhiteSquare;
    private int length;

    public CheckersGameGUIData(Color colorBlackPiece, Color colorWhitePiece, Color colorBlackSquare, Color colorWhiteSquare, int length) {
        this.colorBlackPiece = colorBlackPiece;
        this.colorWhitePiece = colorWhitePiece;
        this.colorBlackSquare = colorBlackSquare;
        this.colorWhiteSquare = colorWhiteSquare;
        this.length = length;
    }

    public Color getColorBlackPiece() {
        return colorBlackPiece;
    }

    public void setColorBlackPiece(Color colorBlackPiece) {
        this.colorBlackPiece = colorBlackPiece;
    }

    public Color getColorWhitePiece() {
        return colorWhitePiece;
    }

    public void setColorWhitePiece(Color colorWhitePiece) {
        this.colorWhitePiece = colorWhitePiece;
    }

    public Color getColorBlackSquare() {
        return colorBlackSquare;
    }

    public void setColorBlackSquare(Color colorBlackSquare) {
        this.colorBlackSquare = colorBlackSquare;
    }

    public Color getColorWhiteSquare() {
        return colorWhiteSquare;
    }

    public void setColorWhiteSquare(Color colorWhiteSquare) {
        this.colorWhiteSquare = colorWhiteSquare;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
