import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame {
    public final ImageIcon icon;
    public final JPanel midPanel;
    public final JPanel player1Panel;
    public final JPanel player2Panel;
    public final Player player1;
    public final Player player2;
    public final Player banker;
    public final JButton buyButton1 = new JButton("buy");
    public final JButton buyButton2 = new JButton("buy");
    public final JButton reserveButton1 = new JButton("reserve");
    public final JButton reserveButton2 = new JButton("reserve");

    public final Coin greenCoin1;
    public final Coin redCoin1;
    public final Coin whiteCoin1;
    public final Coin blackCoin1;
    public final Coin blueCoin1;
    public final Coin goldCoin1;
    public final Coin[] allCoins1 = new Coin[6];
    public final Coin greenCoin2;
    public final Coin redCoin2;
    public final Coin whiteCoin2;
    public final Coin blackCoin2;
    public final Coin blueCoin2;
    public final Coin goldCoin2;
    public final Coin[] allCoins2 = new Coin[6];

    public final Card[] prizeclawCards = new Card[3];
    public final Card[] lvl1Cards = new Card[15];
    public final Card[] lvl2Cards = new Card[15];
    public final Card[] lvl3Cards = new Card[15];

    public Board() {
        player1 = new Player("Gorbe");
        player2 = new Player("Goorba");
        banker = new Player("Banker");
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

        greenCoin1 = new Coin("green", player1);
        redCoin1 = new Coin("red", player1);
        whiteCoin1 = new Coin("white", player1);
        blackCoin1 = new Coin("black", player1);
        blueCoin1 = new Coin("blue", player1);
        goldCoin1 = new Coin("gold", player1);

        allCoins1[0] = greenCoin1;
        allCoins1[1] = redCoin1;
        allCoins1[2] = whiteCoin1;
        allCoins1[3] = blackCoin1;
        allCoins1[4] = blueCoin1;
        allCoins1[5] = goldCoin1;

        greenCoin2 = new Coin("green", player2);
        redCoin2 = new Coin("red", player2);
        whiteCoin2 = new Coin("white", player2);
        blackCoin2 = new Coin("black", player2);
        blueCoin2 = new Coin("blue", player2);
        goldCoin2 = new Coin("gold", player2);

        allCoins2[0] = greenCoin2;
        allCoins2[1] = redCoin2;
        allCoins2[2] = whiteCoin2;
        allCoins2[3] = blackCoin2;
        allCoins2[4] = blueCoin2;
        allCoins2[5] = goldCoin2;

        for (int i = 0; i < 6; i++) {
            coinPanel1.add(allCoins1[i]);
            coinPanel2.add(allCoins2[i]);
        }

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
        cardMidPanel.setLayout(new FlowLayout());
        cardMidPanel.setPreferredSize(new Dimension(900, 400));
        cardMidPanel.setBackground(new Color(119, 232, 247));

    // ---------------------------- TEST CARD
    // ----------------------------------------------------------------------------
        Card someCard = new Card(1, 1, "white", new Price(1, 0, 1, 0, 0), banker);
        cardMidPanel.add(someCard);

        midPanel.add(cardMidPanel, BorderLayout.WEST);

    // -------------------------------------------------------------------------------------------------------------------

        prizeclawCards[0] = new Card(0, 3, new Price(4, 0, 4, 0, 0), banker);
        prizeclawCards[1] = new Card(0, 3, new Price(4, 0, 4, 0, 0), banker);
        prizeclawCards[2] = new Card(0, 4, new Price(5, 5, 0, 0, 0), banker);

        // -------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            lvl1Cards[i] = new Card(1, 1, "white", new Price(0, 0, 2, 3, 0), banker);
        }
        for (int i = 5; i < 10; i++) {
            lvl1Cards[i] = new Card(1, 1, "blue", new Price(3, 0, 1, 0, 0), banker);
        }
        for (int i = 10; i < 15; i++) {
            lvl1Cards[i] = new Card(1, 1, "green", new Price(0, 2, 2, 0, 0), banker);
        }
        // -------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            lvl2Cards[i] = new Card(2, 2, "white", new Price(2, 0, 0, 3, 1), banker);
        }
        for (int i = 5; i < 10; i++) {
            lvl2Cards[i] = new Card(2, 3, "green", new Price(3, 4, 0, 0, 0), banker);
        }
        for (int i = 10; i < 15; i++) {
            lvl2Cards[i] = new Card(2, 4, "blue", new Price(3, 2, 0, 0, 0), banker);
        }
        // -------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            lvl3Cards[i] = new Card(3, 4, "green", new Price(5, 2, 0, 0, 0), banker);
        }
        for (int i = 5; i < 10; i++) {
            lvl3Cards[i] = new Card(3, 4, "blue", new Price(6, 6, 0, 0, 0), banker);
        }
        for (int i = 10; i < 15; i++) {
            lvl3Cards[i] = new Card(3, 4, "red", new Price(5, 3, 0, 1, 0), banker);
        }
    // -------------------------------------------------------------------------------------------------------------------
 
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
