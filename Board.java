import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame {
    private ImageIcon icon;
    private JPanel midPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;
    public final Player player1;
    public final Player player2;
    public final JButton buyButton1 = new JButton("buy");
    public final JButton buyButton2 = new JButton("buy");
    public final JButton reserveButton1 = new JButton("reserve");
    public final JButton reserveButton2 = new JButton("reserve");

    public Board() {
        player1 = new Player("Gorbe");
        player2 = new Player("Goorba");
        player1.isOn = true;

        icon = new ImageIcon("icons/icon.png");
        midPanel = new JPanel();
        player1Panel = new JPanel();
        player2Panel = new JPanel();

        midPanel.setLayout(new BorderLayout(0, 0));
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

        ImageIcon greenCoinIcon = new ImageIcon("icons/coins/green.png");
        ImageIcon redCoinIcon = new ImageIcon("icons/coins/red.png");
        ImageIcon whiteCoinIcon = new ImageIcon("icons/coins/white.png");
        ImageIcon blackCoinIcon = new ImageIcon("icons/coins/black.png");
        ImageIcon blueCoinIcon = new ImageIcon("icons/coins/blue.png");
        ImageIcon goldCoinIcon = new ImageIcon("icons/coins/gold.png");

        JLabel greenCoin1 = new JLabel();
        JLabel redCoin1 = new JLabel();
        JLabel whiteCoin1 = new JLabel();
        JLabel blackCoin1 = new JLabel();
        JLabel blueCoin1 = new JLabel();
        JLabel goldCoin1 = new JLabel();

        greenCoin1.setText("" + player1.getCoinCount("green"));
        redCoin1.setText("" + player1.getCoinCount("red"));
        whiteCoin1.setText("" + player1.getCoinCount("white"));
        blackCoin1.setText("" + player1.getCoinCount("black"));
        blueCoin1.setText("" + player1.getCoinCount("blue"));
        goldCoin1.setText("" + player1.getCoinCount("gold"));

        greenCoin1.setIcon(greenCoinIcon);
        redCoin1.setIcon(redCoinIcon);
        whiteCoin1.setIcon(whiteCoinIcon);
        blackCoin1.setIcon(blackCoinIcon);
        blueCoin1.setIcon(blueCoinIcon);
        goldCoin1.setIcon(goldCoinIcon);

        greenCoin1.setVerticalTextPosition(JLabel.BOTTOM);
        greenCoin1.setHorizontalTextPosition(JLabel.CENTER);
        redCoin1.setVerticalTextPosition(JLabel.BOTTOM);
        redCoin1.setHorizontalTextPosition(JLabel.CENTER);
        whiteCoin1.setVerticalTextPosition(JLabel.BOTTOM);
        whiteCoin1.setHorizontalTextPosition(JLabel.CENTER);
        blackCoin1.setVerticalTextPosition(JLabel.BOTTOM);
        blackCoin1.setHorizontalTextPosition(JLabel.CENTER);
        blueCoin1.setVerticalTextPosition(JLabel.BOTTOM);
        blueCoin1.setHorizontalTextPosition(JLabel.CENTER);
        goldCoin1.setVerticalTextPosition(JLabel.BOTTOM);
        goldCoin1.setHorizontalTextPosition(JLabel.CENTER);

        coinPanel1.add(greenCoin1);
        coinPanel1.add(redCoin1);
        coinPanel1.add(whiteCoin1);
        coinPanel1.add(blackCoin1);
        coinPanel1.add(blueCoin1);
        coinPanel1.add(goldCoin1);

        JLabel greenCoin2 = new JLabel();
        JLabel redCoin2 = new JLabel();
        JLabel whiteCoin2 = new JLabel();
        JLabel blackCoin2 = new JLabel();
        JLabel blueCoin2 = new JLabel();
        JLabel goldCoin2 = new JLabel();

        greenCoin2.setText("" + player2.getCoinCount("green"));
        redCoin2.setText("" + player2.getCoinCount("red"));
        whiteCoin2.setText("" + player2.getCoinCount("white"));
        blackCoin2.setText("" + player2.getCoinCount("black"));
        blueCoin2.setText("" + player2.getCoinCount("blue"));
        goldCoin2.setText("" + player2.getCoinCount("gold"));

        greenCoin2.setIcon(greenCoinIcon);
        redCoin2.setIcon(redCoinIcon);
        whiteCoin2.setIcon(whiteCoinIcon);
        blackCoin2.setIcon(blackCoinIcon);
        blueCoin2.setIcon(blueCoinIcon);
        goldCoin2.setIcon(goldCoinIcon);

        greenCoin2.setVerticalTextPosition(JLabel.BOTTOM);
        greenCoin2.setHorizontalTextPosition(JLabel.CENTER);
        redCoin2.setVerticalTextPosition(JLabel.BOTTOM);
        redCoin2.setHorizontalTextPosition(JLabel.CENTER);
        whiteCoin2.setVerticalTextPosition(JLabel.BOTTOM);
        whiteCoin2.setHorizontalTextPosition(JLabel.CENTER);
        blackCoin2.setVerticalTextPosition(JLabel.BOTTOM);
        blackCoin2.setHorizontalTextPosition(JLabel.CENTER);
        blueCoin2.setVerticalTextPosition(JLabel.BOTTOM);
        blueCoin2.setHorizontalTextPosition(JLabel.CENTER);
        goldCoin2.setVerticalTextPosition(JLabel.BOTTOM);
        goldCoin2.setHorizontalTextPosition(JLabel.CENTER);

        coinPanel2.add(greenCoin2);
        coinPanel2.add(redCoin2);
        coinPanel2.add(whiteCoin2);
        coinPanel2.add(blackCoin2);
        coinPanel2.add(blueCoin2);
        coinPanel2.add(goldCoin2);

        JPanel slotMachinePanel = new JPanel();
        slotMachinePanel.setBackground(new Color(119, 232, 247));
        slotMachinePanel.setPreferredSize(new Dimension(300, 400));
        slotMachinePanel.add(new Slot_Machine("red"));
        slotMachinePanel.add(new Slot_Machine("green"));
        slotMachinePanel.add(new Slot_Machine("blue"));
        slotMachinePanel.add(new Slot_Machine("white"));
        slotMachinePanel.add(new Slot_Machine("black"));
        midPanel.add(slotMachinePanel, BorderLayout.EAST);

        JPanel cardMidPanel = new JPanel();
        cardMidPanel.setPreferredSize(new Dimension(900, 400));
        cardMidPanel.setBackground(new Color(119, 232, 247));

        Card someCard = new Card(1, 3, "blue", new Price(6, 0, 4, 0, 0));
        cardMidPanel.add(someCard);

        midPanel.add(cardMidPanel, BorderLayout.WEST);

        buyButton1.setFocusable(false);
        cardPanel1.add(buyButton1, BorderLayout.NORTH);
        buyButton1.setVisible(false);
        buyButton1.addActionListener(Utils.listener);
        buyButton2.setFocusable(false);
        cardPanel2.add(buyButton2, BorderLayout.SOUTH);
        buyButton2.setVisible(false);
        buyButton2.addActionListener(Utils.listener);

        reserveButton1.setFocusable(false);
        cardPanel1.add(reserveButton1, BorderLayout.NORTH);
        reserveButton1.setVisible(false);
        reserveButton1.addActionListener(Utils.listener);
        reserveButton2.setFocusable(false);
        cardPanel2.add(reserveButton2, BorderLayout.SOUTH);
        reserveButton2.setVisible(false);
        reserveButton2.addActionListener(Utils.listener);

        this.setTitle("Amusement Park");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(20, 20));
        this.setVisible(true);
        this.add(midPanel, BorderLayout.CENTER);
        this.add(player1Panel, BorderLayout.SOUTH);
        this.add(player2Panel, BorderLayout.NORTH);
    }
}
