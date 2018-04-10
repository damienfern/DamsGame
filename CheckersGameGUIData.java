import java.awt.*;
import java.util.Observable;

public class CheckersGameGUIData extends Observable {
    private Color colorBlackPiece;
    private Color colorWhitePiece;
    private Color colorBlackSquare;
    private Color colorWhiteSquare;
    private Color colorBlackSquareBorder;
    private Color colorWhiteSquareBorder;

    private int length;

    public CheckersGameGUIData(Color colorBlackPiece, Color colorWhitePiece, Color colorBlackSquare, Color colorWhiteSquare, Color colorWhiteSquareBorder, Color colorBlackSquareBorder, int length) {
        this.colorBlackPiece = colorBlackPiece;
        this.colorWhitePiece = colorWhitePiece;
        this.colorBlackSquare = colorBlackSquare;
        this.colorWhiteSquare = colorWhiteSquare;
        this.colorWhiteSquareBorder = colorWhiteSquareBorder;
        this.colorBlackSquareBorder = colorBlackSquareBorder;
        this.length = length;

    }

    public Color getColorBlackPiece() {
        return colorBlackPiece;
    }

    public void setColorBlackPiece(Color colorBlackPiece) {
        this.colorBlackPiece = colorBlackPiece;
        setChanged();
        notifyObservers(colorBlackPiece);
    }

    public Color getColorWhitePiece() {
        return colorWhitePiece;
    }

    public void setColorWhitePiece(Color colorWhitePiece) {
        this.colorWhitePiece = colorWhitePiece;
        setChanged();
        notifyObservers(colorWhitePiece);
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

    public Color getColorBlackSquareBorder() {
        return colorBlackSquareBorder;
    }

    public void setColorBlackSquareBorder(Color colorBlackSquareBorder) {
        this.colorBlackSquareBorder = colorBlackSquareBorder;
    }

    public Color getColorWhiteSquareBorder() {
        return colorWhiteSquareBorder;
    }

    public void setColorWhiteSquareBorder(Color colorWhiteSquareBorder) {
        this.colorWhiteSquareBorder = colorWhiteSquareBorder;
    }
}
