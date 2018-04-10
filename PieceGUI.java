import javax.swing.*;
import java.awt.*;

class PieceGUI extends JPanel
{
    protected Color couleur;
    private  PieceColor pieceColor;

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

    public PieceGUI(Color couleur, PieceColor piececolor) {
        this.pieceColor = piececolor;
        this.couleur = couleur;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }
}