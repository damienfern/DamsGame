import javax.swing.*;
import java.awt.*;

class JCircle extends JPanel
{
    protected Color couleur;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(couleur);
        g.fillOval(0,0, getHeight(),getWidth());
    }

    public JCircle(Color couleur) {
        this.couleur = couleur;
    }
}