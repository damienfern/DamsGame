import javax.swing.*;
import java.awt.*;

class JPion extends JPanel
{
    protected Color couleur;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(couleur);
        g.fillOval(0,0, getHeight(),getWidth());
    }

    public JPion(Color couleur) {
        this.couleur = couleur;
    }
}