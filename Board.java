import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame {
    public final ImageIcon icon;
    public final JPanel midPanel = new JPanel();
    public final JPanel player1Panel = new JPanel();
    public final JPanel player2Panel = new JPanel();
    public final Player player1 = new Player("Player1"); {player1.isOn = true;}
    public final Player player2 = new Player("Player2");
    public final Player banker = new Player("Banker");
    // public final JButton buyButton1 = new JButton("buy");
    // public final JButton buyButton2 = new JButton("buy");
    // public final JButton reserveButton1 = new JButton("reserve");
    // public final JButton reserveButton2 = new JButton("reserve");

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

    public final JLabel score1 = new JLabel();
    public final JLabel score2 = new JLabel();
    public final JButton passButton = new JButton();

    Slot_Machine redMachine = new Slot_Machine("red");
    Slot_Machine greenMachine = new Slot_Machine("green");
    Slot_Machine blueMachine = new Slot_Machine("blue");
    Slot_Machine whiteMachine = new Slot_Machine("white");
    Slot_Machine blackMachine = new Slot_Machine("black");

    public Board() {
        this.addMouseMotionListener(Utils.mouseListener);
        icon = new ImageIcon("icons/icon.png");

        JPanel playersPanel = new JPanel(new BorderLayout(10, 0));
        playersPanel.setOpaque(false);
        playersPanel.setPreferredSize(new Dimension(1200, 200));
        playersPanel.add(player1Panel, BorderLayout.WEST);
        playersPanel.add(player2Panel, BorderLayout.EAST);

        midPanel.setLayout(new BorderLayout(0, 0));
        player1Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        player2Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        player1Panel.setBackground(Color.white);
        player2Panel.setBackground(Color.white);
        midPanel.setBackground(new Color(119, 232, 247));

        midPanel.setPreferredSize(new Dimension(1200, 600));
        player1Panel.setPreferredSize(new Dimension(595, 200));
        player2Panel.setPreferredSize(new Dimension(595, 200));

        JPanel coinPanel1 = new JPanel();
        JPanel coinPanel2 = new JPanel();
        coinPanel1.setBackground(new Color(218, 184, 245));
        coinPanel2.setBackground(new Color(184, 245, 210));
        coinPanel1.setPreferredSize(new Dimension(290, 200));
        coinPanel2.setPreferredSize(new Dimension(290, 200));

        JPanel ownedCardPanel1 = new JPanel();
        JPanel reservedCardPanel1 = new JPanel();
        JPanel ownedCardPanel2 = new JPanel();
        JPanel reservedCardPanel2 = new JPanel();
        ownedCardPanel1.setBackground(new Color(218, 184, 245));
        reservedCardPanel1.setBackground(new Color(218, 184, 245));
        ownedCardPanel2.setBackground(new Color(184, 245, 210));
        reservedCardPanel2.setBackground(new Color(184, 245, 210));
        ownedCardPanel1.setPreferredSize(new Dimension(575, 200));
        ownedCardPanel2.setPreferredSize(new Dimension(575, 200));
        reservedCardPanel1.setPreferredSize(new Dimension(295, 200));
        reservedCardPanel2.setPreferredSize(new Dimension(295, 200));

        player1Panel.add(reservedCardPanel1);
        player2Panel.add(reservedCardPanel2);
        // player1Panel.add(ownedCardPanel1);
        // player2Panel.add(ownedCardPanel2);
        player1Panel.add(coinPanel1);
        player2Panel.add(coinPanel2);

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
        slotMachinePanel.setPreferredSize(new Dimension(300, 600));
        slotMachinePanel.add(redMachine);
        slotMachinePanel.add(greenMachine);
        slotMachinePanel.add(blueMachine);
        slotMachinePanel.add(whiteMachine);
        slotMachinePanel.add(blackMachine);
        midPanel.add(slotMachinePanel, BorderLayout.EAST);

        JPanel cardMidPanel = new JPanel();
        cardMidPanel.setLayout(new FlowLayout());
        cardMidPanel.setPreferredSize(new Dimension(900, 600));
        cardMidPanel.setBackground(new Color(119, 232, 247));

        // ---------------------------- TEST CARD
        // ----------------------------------------------------------------------------
        Card someCard = new Card(1, 1, "white", new Price(1, 0, 1, 0, 0), banker);
        cardMidPanel.add(someCard);

        // -------------------------------------------------------------------------------------------------------------------

        midPanel.add(cardMidPanel, BorderLayout.CENTER);

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
        // The score board:
        JPanel scoreTray = new JPanel(new FlowLayout());
        scoreTray.setPreferredSize(new Dimension(50, 300));
        scoreTray.setOpaque(false);
        JPanel scoreBoard = new JPanel(new FlowLayout());
        scoreBoard.setPreferredSize(new Dimension(50, 150));
        score1.setPreferredSize(new Dimension(50, 75));
        score2.setPreferredSize(new Dimension(50, 75));
        score1.setText(" " + player1.getScore());
        score2.setText(" " + player2.getScore());
        score1.setVerticalTextPosition(JLabel.CENTER);
        score1.setHorizontalTextPosition(JLabel.CENTER);
        score2.setVerticalTextPosition(JLabel.CENTER);
        score2.setHorizontalTextPosition(JLabel.CENTER);
        score1.setFont(new Font("Tahoma", Font.BOLD, 30));
        score2.setFont(new Font("Tahoma", Font.BOLD, 30));
        score1.setBackground(new Color(218, 184, 245));
        score2.setBackground(new Color(184, 245, 210));
        score1.setOpaque(true);
        score2.setOpaque(true);
        scoreBoard.add(score2);
        scoreBoard.add(score1);
        JPanel invisibleBox = new JPanel();
        invisibleBox.setOpaque(false);
        invisibleBox.setPreferredSize(new Dimension(50, 75));
        scoreTray.add(invisibleBox);
        scoreTray.add(scoreBoard);
        midPanel.add(scoreTray, BorderLayout.WEST);
        // NOTE: The scores are updated within the buyCard method in class Player

        // Pass button:
        passButton.setPreferredSize(new Dimension(50, 75));
        passButton.setFocusable(false);
        passButton.setBackground(Color.white);
        passButton.setText("<html>P<br>A<br>S<br>S</html>");
        passButton.addActionListener(Utils.listener);
        scoreTray.add(passButton);

        

        this.setTitle("Amusement Park");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1220, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.add(midPanel);
        this.add(playersPanel);
    }
}
