package vue;

import model.CheckersGameGUIData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckersGameGUIMenu extends JMenuBar {

    private JMenu choix_couleur_menu = new JMenu("Choix couleur");

    private CheckersGameGUIData checkersGameGUIData;
    private JMenuItem choix_couleur_pblanc = new JMenuItem("Piece Blanche");
    private JMenuItem choix_couleur_pnoire = new JMenuItem("Piece Noire");

    public CheckersGameGUIMenu(final CheckersGameGUIData checkersGameGUIData)
    {
        this.checkersGameGUIData = checkersGameGUIData;
        choix_couleur_menu.add(choix_couleur_pblanc);
        choix_couleur_menu.add(choix_couleur_pnoire);

        choix_couleur_pblanc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color new_couleur = JColorChooser.showDialog(choix_couleur_pblanc, "Sélectionner une couleur pour les pièces blanches", checkersGameGUIData.getColorWhitePiece());
                checkersGameGUIData.setColorWhitePiece(new_couleur);
            }
        });

        choix_couleur_pnoire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color new_couleur = JColorChooser.showDialog(choix_couleur_pnoire, "Sélectionner une couleur pour les pièces noires", checkersGameGUIData.getColorBlackPiece());
                checkersGameGUIData.setColorBlackPiece(new_couleur);
            }
        });

        this.add(choix_couleur_menu);
    }
}