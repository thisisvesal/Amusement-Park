import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame {
    // Game board components:
    public final ImageIcon icon;
    public final JPanel midPanel = new JPanel();
    public final JPanel player1Panel = new JPanel();
    public final JPanel player2Panel = new JPanel();
    public final Player player1 = new Player("Player1"); {player1.isOn = true;}
    public final Player player2 = new Player("Player2");
    public final Player banker = new Player("Banker");
    {
        banker.setCoinCount("red", 4);
        banker.setCoinCount("green", 4);
        banker.setCoinCount("blue", 4);
        banker.setCoinCount("white", 4);
        banker.setCoinCount("black", 4);
        banker.setCoinCount("gold", 5);
    }

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

    public final Coin superGreenCoin1;
    public final Coin superRedCoin1;
    public final Coin superWhiteCoin1;
    public final Coin superBlackCoin1;
    public final Coin superBlueCoin1;
    public final Coin[] allSuperCoins1 = new Coin[5];
    public final Coin superGreenCoin2;
    public final Coin superRedCoin2;
    public final Coin superWhiteCoin2;
    public final Coin superBlackCoin2;
    public final Coin superBlueCoin2;
    public final Coin[] allSuperCoins2 = new Coin[5];

    public final ArrayList<Card> prizeclawCards = new ArrayList<Card>();
    public final ArrayList<Card> lvl1Cards = new ArrayList<Card>();
    public final ArrayList<Card> lvl2Cards = new ArrayList<Card>();
    public final ArrayList<Card> lvl3Cards = new ArrayList<Card>();

    public final JPanel prizeclawPanel = new JPanel();
    public final JPanel lvl1Panel = new JPanel();
    public final JPanel lvl2Panel = new JPanel();
    public final JPanel lvl3Panel = new JPanel();

    public final JLabel score1 = new JLabel();
    public final JLabel score2 = new JLabel();
    public final JButton passButton = new JButton();

    public final Slot_Machine redMachine = new Slot_Machine("red");
    public final Slot_Machine greenMachine = new Slot_Machine("green");
    public final Slot_Machine blueMachine = new Slot_Machine("blue");
    public final Slot_Machine whiteMachine = new Slot_Machine("white");
    public final Slot_Machine blackMachine = new Slot_Machine("black");

    public final JLabel turnLabel = new JLabel();

    public final JPanel reservedCardPanel1 = new JPanel();
    public final JPanel reservedCardPanel2 = new JPanel();
    public final JPanel cardMidPanel = new JPanel();

    // Menu components:
    public final JButton startButton = new JButton("START");
    public final JButton settingsButton = new JButton("SETTINGS");
    public final JButton howToPlayButton = new JButton("HOW TO PLAY");

    public Board() {
        icon = new ImageIcon("icons/icon.png");

        greenCoin1 = new Coin("green", player1);
        redCoin1 = new Coin("red", player1);
        whiteCoin1 = new Coin("white", player1);
        blackCoin1 = new Coin("black", player1);
        blueCoin1 = new Coin("blue", player1);
        goldCoin1 = new Coin("gold", player1);

        superGreenCoin1 = new Coin("green", true, player1);
        superRedCoin1 = new Coin("red", true, player1);
        superWhiteCoin1 = new Coin("white", true, player1);
        superBlackCoin1 = new Coin("black", true, player1);
        superBlueCoin1 = new Coin("blue", true, player1);

        greenCoin2 = new Coin("green", player2);
        redCoin2 = new Coin("red", player2);
        whiteCoin2 = new Coin("white", player2);
        blackCoin2 = new Coin("black", player2);
        blueCoin2 = new Coin("blue", player2);
        goldCoin2 = new Coin("gold", player2);

        superGreenCoin2 = new Coin("green", true, player2);
        superRedCoin2 = new Coin("red", true, player2);
        superWhiteCoin2 = new Coin("white", true, player2);
        superBlackCoin2 = new Coin("black", true, player2);
        superBlueCoin2 = new Coin("blue", true, player2);

        this.setTitle("Amusement Park");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1220, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    public void initializeGameBoard() {
        getContentPane().removeAll();
        this.setLayout(new FlowLayout());
        this.addMouseMotionListener(Utils.mouseListener);

        JPanel playersPanel = new JPanel(new BorderLayout(10, 0));
        playersPanel.setOpaque(false);
        playersPanel.setPreferredSize(new Dimension(1200, 300));
        playersPanel.add(player1Panel, BorderLayout.WEST);
        playersPanel.add(player2Panel, BorderLayout.EAST);

        midPanel.setLayout(new BorderLayout(0, 0));
        player1Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        player2Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        player1Panel.setBackground(new Color(218, 184, 245));
        player2Panel.setBackground(new Color(184, 245, 210));
        midPanel.setBackground(new Color(119, 232, 247));

        midPanel.setPreferredSize(new Dimension(1200, 500));
        player1Panel.setPreferredSize(new Dimension(595, 300));
        player2Panel.setPreferredSize(new Dimension(595, 300));

        JPanel coinPanel1 = new JPanel();
        JPanel coinPanel2 = new JPanel();
        coinPanel1.setBackground(new Color(218, 184, 245));
        coinPanel2.setBackground(new Color(184, 245, 210));
        coinPanel1.setPreferredSize(new Dimension(250, 300));
        coinPanel2.setPreferredSize(new Dimension(250, 300));

        JPanel normalCoinPanel1 = new JPanel();
        normalCoinPanel1.setOpaque(false);
        normalCoinPanel1.setPreferredSize(new Dimension(250, 150));
        JPanel superCoinPanel1 = new JPanel();
        superCoinPanel1.setOpaque(false);
        superCoinPanel1.setPreferredSize(new Dimension(250, 150));
        JPanel normalCoinPanel2 = new JPanel();
        normalCoinPanel2.setOpaque(false);
        normalCoinPanel2.setPreferredSize(new Dimension(250, 150));
        JPanel superCoinPanel2 = new JPanel();
        superCoinPanel2.setOpaque(false);
        superCoinPanel2.setPreferredSize(new Dimension(250, 150));

        coinPanel1.add(normalCoinPanel1);
        coinPanel1.add(superCoinPanel1);
        coinPanel2.add(normalCoinPanel2);
        coinPanel2.add(superCoinPanel2);

        reservedCardPanel1.setBackground(new Color(218, 184, 245));
        reservedCardPanel2.setBackground(new Color(184, 245, 210));
        reservedCardPanel1.setPreferredSize(new Dimension(335, 300));
        reservedCardPanel2.setPreferredSize(new Dimension(335, 300));

        player1Panel.add(reservedCardPanel1);
        player2Panel.add(reservedCardPanel2);
        player1Panel.add(coinPanel1);
        player2Panel.add(coinPanel2); 

        allCoins1[0] = greenCoin1;
        allCoins1[1] = redCoin1;
        allCoins1[2] = whiteCoin1;
        allCoins1[3] = blackCoin1;
        allCoins1[4] = blueCoin1;
        allCoins1[5] = goldCoin1;

        allSuperCoins1[0] = superGreenCoin1;
        allSuperCoins1[1] = superRedCoin1;
        allSuperCoins1[2] = superWhiteCoin1;
        allSuperCoins1[3] = superBlackCoin1;
        allSuperCoins1[4] = superBlueCoin1;

        allCoins2[0] = greenCoin2;
        allCoins2[1] = redCoin2;
        allCoins2[2] = whiteCoin2;
        allCoins2[3] = blackCoin2;
        allCoins2[4] = blueCoin2;
        allCoins2[5] = goldCoin2;

        allSuperCoins2[0] = superGreenCoin2;
        allSuperCoins2[1] = superRedCoin2;
        allSuperCoins2[2] = superWhiteCoin2;
        allSuperCoins2[3] = superBlackCoin2;
        allSuperCoins2[4] = superBlueCoin2;

        for (int i = 0; i < 6; i++) {
            normalCoinPanel1.add(allCoins1[i]);
            normalCoinPanel2.add(allCoins2[i]);
            if (i != 5) {
                superCoinPanel1.add(allSuperCoins1[i]);
                superCoinPanel2.add(allSuperCoins2[i]);
            }  
        }

        turnLabel.setPreferredSize(new Dimension(200, 150));
        turnLabel.setText(Utils.getPlayerOfTheRound().color + "'s turn");
        turnLabel.setVerticalTextPosition(JLabel.CENTER);
        turnLabel.setHorizontalTextPosition(JLabel.CENTER);
        turnLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

        JPanel slotMachinePanel = new JPanel();
        slotMachinePanel.setBackground(new Color(119, 232, 247));
        slotMachinePanel.setPreferredSize(new Dimension(300, 500));
        slotMachinePanel.add(redMachine);
        slotMachinePanel.add(greenMachine);
        slotMachinePanel.add(blueMachine);
        slotMachinePanel.add(whiteMachine);
        slotMachinePanel.add(blackMachine);
        slotMachinePanel.add(turnLabel);
        midPanel.add(slotMachinePanel, BorderLayout.EAST);

        cardMidPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        cardMidPanel.setPreferredSize(new Dimension(900, 500));
        cardMidPanel.setBackground(new Color(119, 232, 247));

        prizeclawPanel.setPreferredSize(new Dimension(200, 500));
        lvl1Panel.setPreferredSize(new Dimension(200, 500));
        lvl2Panel.setPreferredSize(new Dimension(200, 500));
        lvl3Panel.setPreferredSize(new Dimension(200, 500));

        prizeclawPanel.setOpaque(false);
        lvl1Panel.setOpaque(false);
        lvl2Panel.setOpaque(false);
        lvl3Panel.setOpaque(false);

        // For testing purposes, although they're invisible:
        prizeclawPanel.setBackground(Color.red);
        lvl1Panel.setBackground(Color.blue);
        lvl2Panel.setBackground(Color.magenta);
        lvl3Panel.setBackground(Color.yellow);

        cardMidPanel.add(prizeclawPanel);
        cardMidPanel.add(lvl1Panel);
        cardMidPanel.add(lvl2Panel);
        cardMidPanel.add(lvl3Panel);

        midPanel.add(cardMidPanel, BorderLayout.CENTER);

        prizeclawCards.add(new Card(0, 3, new Price(4, 0, 4, 0, 0), banker));
        prizeclawCards.add(new Card(0, 3, new Price(4, 0, 4, 0, 0), banker));
        prizeclawCards.add(new Card(0, 4, new Price(5, 5, 0, 0, 0), banker));

        // -------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            lvl1Cards.add(new Card(1, 1, "white", new Price(0, 0, 2, 3, 0), banker));
        }
        for (int i = 5; i < 10; i++) {
            lvl1Cards.add(new Card(1, 1, "blue", new Price(3, 0, 1, 0, 0), banker));
        }
        for (int i = 10; i < 15; i++) {
            lvl1Cards.add(new Card(1, 1, "green", new Price(0, 2, 2, 0, 0), banker));
        }
        // -------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            lvl2Cards.add(new Card(2, 2, "white", new Price(2, 0, 0, 3, 1), banker));
        }
        for (int i = 5; i < 10; i++) {
            lvl2Cards.add(new Card(2, 3, "green", new Price(3, 4, 0, 0, 0), banker));
        }
        for (int i = 10; i < 15; i++) {
            lvl2Cards.add(new Card(2, 4, "blue", new Price(3, 2, 0, 0, 0), banker));
        }
        // -------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            lvl3Cards.add(new Card(3, 4, "green", new Price(5, 2, 0, 0, 0), banker));
        }
        for (int i = 5; i < 10; i++) {
            lvl3Cards.add(new Card(3, 4, "blue", new Price(6, 6, 0, 0, 0), banker));
        }
        for (int i = 10; i < 15; i++) {
            lvl3Cards.add(new Card(3, 4, "red", new Price(5, 3, 0, 1, 0), banker));
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

        this.add(midPanel);
        this.add(playersPanel);

        Utils.arrangeCards();
        Utils.refreshBoard();
    }
    
    public void initializeMenu() {
        getContentPane().removeAll();
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(119, 232, 247));

        JLabel title = new JLabel("AMUSEMENT PARK");
        title.setFont(new Font("Bauhaus 93", Font.BOLD, 107));
        title.setForeground(new Color(182, 90, 196));
        title.setBackground(new Color(184, 245, 210));
        // title.setOpaque(true);
        title.setBounds(160, 50, 900, 200);
        this.add(title);

        startButton.addActionListener(Utils.listener);
        startButton.setFont(new Font("Tahoma", Font.BOLD, 45));
        startButton.setFocusable(false);
        startButton.setBounds(370, 300, 450, 100);
        startButton.setBackground(new Color(219, 245, 255));
        this.add(startButton);
        settingsButton.addActionListener(Utils.listener);
        settingsButton.setFont(new Font("Tahoma", Font.BOLD, 45));
        settingsButton.setFocusable(false);
        settingsButton.setBounds(370, 425, 450, 100);
        settingsButton.setBackground(new Color(184, 245, 210));
        this.add(settingsButton);
        howToPlayButton.addActionListener(Utils.listener);
        howToPlayButton.setFont(new Font("Tahoma", Font.BOLD, 45));
        howToPlayButton.setFocusable(false);
        howToPlayButton.setBounds(370, 550, 450, 100);
        howToPlayButton.setBackground(new Color(232, 213, 247));
        this.add(howToPlayButton);
    }

}
