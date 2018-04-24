package vue;

import controller.CheckersgameController;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class CheckersGameGUI extends JFrame implements Observer {

    private CheckersGameGUIBoard checkersBoard; // Damier
    private JMenuBar menuBar; // Menu Bar

    public CheckersGameGUI(CheckersgameController controller) {
        super();
        this.menuBar = new CheckersGameGUIMenu(controller.getCheckersGameGUIData());
        this.checkersBoard = controller.getCheckersGameGUIBoard();
        this.setJMenuBar(menuBar);
        this.setContentPane(checkersBoard);
    }

    @Override
    public void update(Observable observable, Object o) {
        this.repaint();
    }

}
