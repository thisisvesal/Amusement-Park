import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Card extends JPanel {
    public final int level;
    public final Coin specialCoin;
    public final int score;
    private Player owner;
    private boolean reserved;
    public final Price price;
    public final CardButton button;
    public final JButton buyButton = new JButton("buy");
    public final JButton reserveButton = new JButton("reserve");

    {
        buyButton.setPreferredSize(new Dimension(60, 20));
        buyButton.setFocusable(false);
        buyButton.setVisible(false);
        buyButton.addActionListener(Utils.listener);
        reserveButton.setPreferredSize(new Dimension(80, 20));
        reserveButton.setFocusable(false);
        reserveButton.setVisible(false);
        reserveButton.addActionListener(Utils.listener);
    }

    // Constructing normal cards:
    public Card(int level, int score, String specialCoinColor, Price price, Player owner) {
        this.setPreferredSize(new Dimension(150, 190));
        this.setOpaque(false);
        this.setBackground(Color.red);
        this.level = level;
        this.score = score;
        this.owner = owner;
        this.specialCoin = new Coin(specialCoinColor, true, owner);
        this.price = price;
        this.button = new CardButton(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(buyButton);
        buttonPanel.add(reserveButton);

        this.add(button);
        this.add(buttonPanel);
    }

    // Constructing prize-claws:
    public Card(int level, int score, Price price, Player owner) {
        this(level, score, null, price, owner);
    }

    public void reserve() {
        reserved = true;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

}