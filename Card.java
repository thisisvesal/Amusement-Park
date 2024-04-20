import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Card extends JPanel {
    public final int level;
    public final Coin superCoin;
    public final int score;
    public final boolean isPrizeclaw;
    private Player owner;
    private boolean reserved;
    public final Price price;
    public final CardButton button;
    public final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
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

        buyButton.setBackground(new Color(232, 249, 250));
        reserveButton.setBackground(new Color(232, 249, 250));
    }

    // Constructing normal cards:
    public Card(int level, int score, String superCoinColor, Price price, Player owner) {
        this.setPreferredSize(new Dimension(150, 160));
        this.setOpaque(false);
        this.setBackground(Color.red);
        this.level = level;
        this.score = score;
        this.owner = owner;
        this.superCoin = new Coin(superCoinColor, true, owner);
        this.price = price;
        this.button = new CardButton(this);

        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new Dimension(150, 30));
        buttonPanel.add(buyButton);
        buttonPanel.add(reserveButton);

        this.add(button);
        if (this.level != 0) {
            this.add(buttonPanel);
        } else {
            this.button.setEnabled(false);
        }
        
        if (this.superCoin.color == null) {
            isPrizeclaw = true;
        } else {
            isPrizeclaw = false;
        }
    }

    // Constructing prize-claws:
    public Card(int level, int score, Price price, Player owner) {
        this(level, score, null, price, owner);
    }

    public void reserve() {
        reserved = true;
    }

    public void unreserve() {
        reserved = false;
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