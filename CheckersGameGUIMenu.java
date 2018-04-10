import javax.swing.*;

public class CheckersGameGUIMenu extends JMenuBar {

    private JMenu choix_couleur_menu = new JMenu("Choix couleur");


    private JMenuItem choix_couleur_pblanc = new JMenuItem("Piece Blanche");
    private JMenuItem choix_couleur_pnoire = new JMenuItem("Piece Noire");

    public CheckersGameGUIMenu(CheckersGameGUIData checkersGameGUIData) {
        choix_couleur_menu.add(choix_couleur_pblanc);
        choix_couleur_menu.add(choix_couleur_pnoire);
        this.add(choix_couleur_menu);
    }
}
