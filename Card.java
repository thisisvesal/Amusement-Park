import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton {
    public final int level;
    public final Coin specialCoin;
    public final int score;
    private Player owner;
    private boolean reserved;
    public final Price price;

    public Card(int level, int score, String specialCoinColor, Price price) {
        this.setPreferredSize(new Dimension(100, 150));
        this.setBackground(new Color(247, 246, 195));
        // this.setOpaque(true); not necessary for a button
        this.setFocusable(false);
        this.level = level;
        this.score = score;
        specialCoin = new Coin(specialCoinColor, true, this.owner);
        this.price = price;
        ImageIcon specialCoinIcon = new ImageIcon("icons/coins/" + specialCoinColor + ".png");
        this.setIcon(specialCoinIcon);
        this.addActionListener(Utils.listener);
    }

    public void reserve() {
        reserved = true;
    }

    public boolean isReserved() {
        return reserved;
    }

}