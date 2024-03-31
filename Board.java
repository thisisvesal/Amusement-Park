import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame{
    private ImageIcon icon;
    private JPanel midPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;

    public Board() {
        icon = new ImageIcon("icon.png");
        midPanel = new JPanel();
        player1Panel = new JPanel();
        player2Panel = new JPanel();

        player1Panel.setLayout(new BorderLayout(0, 0));
        player2Panel.setLayout(new BorderLayout(0, 0));

        player1Panel.setBackground(Color.white);
        player2Panel.setBackground(Color.white);
        midPanel.setBackground(new Color(119, 232, 247));
        

        midPanel.setPreferredSize(new Dimension(1200, 400));
        player1Panel.setPreferredSize(new Dimension(1200, 200));
        player2Panel.setPreferredSize(new Dimension(1200, 200));

        JPanel coinPanel1 = new JPanel();
        JPanel coinPanel2 = new JPanel();
        coinPanel1.setBackground(new Color(218, 184, 245));
        coinPanel2.setBackground(new Color(184, 245, 210));
        coinPanel1.setPreferredSize(new Dimension(295, 200));
        coinPanel2.setPreferredSize(new Dimension(295, 200));

        player1Panel.add(coinPanel1, BorderLayout.EAST);
        player2Panel.add(coinPanel2, BorderLayout.WEST);

        JPanel cardPanel1 = new JPanel();
        JPanel cardPanel2 = new JPanel();
        cardPanel1.setBackground(new Color(218, 184, 245));
        cardPanel2.setBackground(new Color(184, 245, 210));
        cardPanel1.setPreferredSize(new Dimension(875, 200));
        cardPanel2.setPreferredSize(new Dimension(875, 200));


        player1Panel.add(cardPanel1, BorderLayout.WEST);
        player2Panel.add(cardPanel2, BorderLayout.EAST);

        this.setTitle("Amusement Park");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(20, 20));
        this.setVisible(true);
        this.add(midPanel, BorderLayout.CENTER);
        this.add(player1Panel, BorderLayout.SOUTH);
        this.add(player2Panel, BorderLayout.NORTH);
    }
}
