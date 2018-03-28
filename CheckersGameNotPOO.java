import javax.swing.*;
import java.awt.*;

public class CheckersGameNotPOO {

    public static void  main(String[] args)
    {
        System.out.println("Je suis pas venu ici pour souffrir OK ?");
        CheckersGameNotPOO checkersFrame = new CheckersGameNotPOO();
        checkersFrame.go();
    }

    public void go()
    {
        System.out.println("Fonction GO, je te choisis ! [THROW POKEBALL]");

        JFrame frame = new JFrame("THIS IS SPARTA !");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(666, 666));



        JPanel checkersBoard = setCheckboard(10);
        frame.add(checkersBoard);
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel setCheckboard(int cases)
    {
        JPanel frame = new JPanel();
        frame.setLayout(new GridLayout(cases, cases));
        for (int i = 0; i < cases; i++) {
            for (int j = 0; j < cases; j++) {

                JPanel panel = new JPanel();
                if ((i+j) % 2 == 0)
                {
                    panel.setBackground(Color.BLACK);
                }
                else
                {
                    panel.setBackground(Color.WHITE);
                }
                frame.add(panel);
            }

        }

        return frame;
    }
}
