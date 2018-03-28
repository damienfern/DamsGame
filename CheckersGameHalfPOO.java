import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CheckersGameHalfPOO {

    private JFrame frame;                                                       // Fenetre
    private JPanel
            checkersBoard,                                                      // Damier
            selectedPieceGUI;                                                   // Piece à déplacer
    private Color
            colorBlack,                                                         // Couleur pion 1
            colorWhite;                                                         // Couleur pion 2
    private static final int length = 10;                                       // nb ligne et colonne du damier

    public static void  main(String[] args)
    {
        new CheckersGameHalfPOO();
    }

    public CheckersGameHalfPOO() {
        this.colorBlack = new Color(173, 0, 255);
        this.colorWhite = Color.RED;
        this.frame = setFrameConfig("This is SPARTA plein de dames !!!");

        this.checkersBoard = setCheckboard();
        this.frame.setPreferredSize(new Dimension(666, 666));
        this.frame.pack();
        this.frame.add(checkersBoard);
        this.frame.setVisible(true);
    }

    private JFrame setFrameConfig(String title)
    {
        return new JFrame();
    }


    private void setSelectedPieceGUI(JPanel pieceGUI) {
        this.selectedPieceGUI = pieceGUI;
    }

    class PionSelectMouseListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if(mouseEvent.getSource() instanceof JPanel)
            {
                JPanel pieceGUI = (JPanel) mouseEvent.getSource();
                setSelectedPieceGUI(pieceGUI);
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    class PionMoveMouseListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if(mouseEvent.getSource() instanceof JPanel)
            {
                JPanel caseGUI = (JPanel) mouseEvent.getSource();
                if (caseGUI.getComponents().length == 0)
                    movePiece(caseGUI);
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    private void movePiece(JPanel caseDest)
    {
        caseDest.add(selectedPieceGUI);
        frame.repaint();
    }

    private JPanel setCheckboard()
    {
        JPanel intercheckersBoard = new JPanel();
        intercheckersBoard.setLayout(new GridLayout(length, length));
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                JPanel panel = new JPanel();
                if ((i+j) % 2 == 0)
                {
                    panel.setBackground(Color.BLACK);
                    if (i < 3 || i > 6)
                    {
                        JCircle pion;
                        if(i>6)
                        {
                            pion = new JCircle(colorBlack);
                        }
                        else
                        {
                            pion = new JCircle(colorWhite);
                        }
                        pion.setPreferredSize(new Dimension(50, 50));
                        pion.setOpaque(false);
                        pion.addMouseListener(new PionSelectMouseListener());
                        panel.add(pion);
                    }
                }
                else
                {

                    panel.setBackground(Color.WHITE);
                }

                panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
                panel.addMouseListener(new PionMoveMouseListener());
                intercheckersBoard.add(panel);
            }

        }

        return intercheckersBoard;
    }

    private class JCircle extends JPanel
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
}
