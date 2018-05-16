package model;

import javax.swing.*;
import java.awt.*;

/**
 * Classe graphique d'une case
 */
public class SquareGUI extends JPanel {
    private Coord coord;
    protected Color couleur;
    protected Color border_couleur;

    public SquareGUI(Color couleur, Coord coord) {
        this.coord = coord;
        this.couleur = couleur;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(couleur);
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
        this.setBackground(couleur);
    }

    public Color getBorder_couleur() {
        return border_couleur;
    }

    public void setBorder_couleur(Color border_couleur) {
        this.border_couleur = border_couleur;
        this.setBorder(BorderFactory.createLineBorder(border_couleur));
    }

    public Coord getCoord() {
        return coord;
    }
}
