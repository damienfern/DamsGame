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

                SquareGUI panel = new SquareGUI();
                if ((i+j) % 2 == 0)
                {
                    panel.setCouleur(checkersGameGUIData.getColorBlackSquare());
                    panel.setBorder_couleur(checkersGameGUIData.getColorBlackSquareBorder());

                    if (i < 3 || i >= length - 3)
                    {
                        PieceGUI pion;
                        if(i >= length - 3)
                        {
                            pion = new PieceGUI(checkersGameGUIData.getColorBlackPiece(), PieceColor.NOIR);
                        }
                        else
                        {
                            pion = new PieceGUI(checkersGameGUIData.getColorWhitePiece(), PieceColor.BLANC);
                        }
                        pion.setPreferredSize(new Dimension(50, 50));
                        pion.setOpaque(false);
                        pion.addMouseListener(new PionSelectMouseListener());
                        panel.add   (pion);
                    }
                }

                else
                {
                    panel.setBorder_couleur(checkersGameGUIData.getColorWhiteSquareBorder());
                    panel.setCouleur(checkersGameGUIData.getColorWhiteSquare());
                }

                panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
                panel.addMouseListener(new PionMoveMouseListener());
                this.add(panel);
            }

        }
        this.repaint();
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
            if(mouseEvent.getSource() instanceof JPanel && selectedPieceGUI != null)
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
        selectedPieceGUI = null;
    }

    private void setSelectedPieceGUI(JPanel pieceGUI) {
        this.selectedPieceGUI = pieceGUI;
    }

}
