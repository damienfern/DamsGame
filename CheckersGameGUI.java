import javax.swing.*;

public class CheckersGameGUI extends JFrame{

    private JPanel checkersBoard; // Damier
    private JMenuBar menuBar; // Menu Bar

    public CheckersGameGUI(CheckersGameGUIData checkersGameGUIData) {
        super();
        this.checkersBoard = new CheckersGameGUIBoard(checkersGameGUIData);
        this.menuBar = new CheckersGameGUIMenu(checkersGameGUIData);
        this.setJMenuBar(menuBar);
        this.setContentPane(checkersBoard);
    }
}
