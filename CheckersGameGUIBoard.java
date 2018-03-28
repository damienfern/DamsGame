import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersGameGUIBoard extends JPanel {
    CheckersGameGUIData checkersGameGUIData;
    private int length;
    private JPanel selectedPieceGUI;       // Piece à déplacer

    public CheckersGameGUIBoard(CheckersGameGUIData checkersGameGUIData) {
        super();
        this.checkersGameGUIData = checkersGameGUIData;
        this.length = checkersGameGUIData.getLength();
        this.selectedPieceGUI = null;

        setCheckboard();
    }

    private void setCheckboard()
    {
        this.setLayout(new GridLayout(length, length));
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                JPanel panel = new JPanel();
                if ((i+j) % 2 == 0)
                {
                    panel.setBackground(checkersGameGUIData.getColorBlackSquare());

                    if (i < 3 || i > length - 3)
                    {
                        JCircle pion;
                        if(i > length - 3)
                        {
                            pion = new JCircle(checkersGameGUIData.getColorBlackPiece());
                        }
                        else
                        {
                            pion = new JCircle(checkersGameGUIData.getColorWhitePiece());
                        }
                        pion.setPreferredSize(new Dimension(50, 50));
                        pion.setOpaque(false);
                        pion.addMouseListener(new PionSelectMouseListener());
                        panel.add(pion);
                    }
                }
                else
                {

                    panel.setBackground(checkersGameGUIData.getColorWhiteSquare());
                }

                panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
                panel.addMouseListener(new PionMoveMouseListener());
                this.add(panel);
            }

        }
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
                if (caseGUI.getComponents().length == 0 && caseGUI.getBackground() == checkersGameGUIData.getColorBlackSquare())
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
        this.repaint();
    }

    private void setSelectedPieceGUI(JPanel pieceGUI) {
        this.selectedPieceGUI = pieceGUI;
    }

}