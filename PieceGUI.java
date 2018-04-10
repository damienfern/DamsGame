import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

class PieceGUI extends JPanel implements Observer
{
    protected Color couleur;

    private PieceColor pieceColor;
    private CheckersGameGUIData checkersGameGUIData;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int h = getHeight();
        int w = getWidth();

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(0, 0, couleur, 0, h, Color.WHITE);
        g2d.setPaint(gp);

        g.fillOval(0,0, h, w);
    }

    public PieceGUI(CheckersGameGUIData checkersGameGUIData, PieceColor piececolor) {
        this.pieceColor = piececolor;
        this.checkersGameGUIData = checkersGameGUIData;
        if(piececolor == piececolor.NOIR)
        {
            this.couleur = checkersGameGUIData.getColorBlackPiece();
        }
        else
        {
            this.couleur = checkersGameGUIData.getColorWhitePiece();
        }
    }


    @Override
    public void update(Observable observable, Object o) {
        if (this.pieceColor == PieceColor.NOIR)
        {
            this.couleur = checkersGameGUIData.getColorBlackPiece();
        }
        else
        {
            this.couleur = checkersGameGUIData.getColorWhitePiece();
        }
        this.repaint();
    }
}