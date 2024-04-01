import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JButton {
    public final int level;
    public final Coin specialCoin;
    public final int score;
    private Player owner;
    private boolean reserved;
    public final Price price;

    public Card(int level, int score, String specialCoinColor, Price price, Player owner) {
        this.setPreferredSize(new Dimension(100, 150));
        // this.setBackground(new Color(247, 246, 195));
        this.setBackground(new Color(232, 249, 250));
        // this.setOpaque(true); not necessary for a button
        this.setFocusable(false);
        this.level = level;
        this.score = score;
        this.owner = owner;
        this.setLayout(new BorderLayout(0, 0));
        this.specialCoin = new Coin(specialCoinColor, true, owner);
        this.price = price;
        ImageIcon specialCoinIcon = new ImageIcon("icons/coins/" + specialCoinColor + ".png");
        ImageIcon toyIcon;
        ImageIcon[] priceIcon = new ImageIcon[3];
        JLabel specialCoinLabel = new JLabel();
        JLabel toyLabel;
        JLabel[] priceLabel = new JLabel[3];
        JPanel specialCoinPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 0, 0));
        JPanel toyPanel = new JPanel(new FlowLayout());
        JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JLabel scoreLabel = new JLabel("" + score + " ");
        scoreLabel.setPreferredSize(new Dimension(15, 15));
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);

        specialCoinPanel.setPreferredSize(new Dimension(95, 33));
        specialCoinPanel.setOpaque(false);
        specialCoinPanel.add(scoreLabel);
        toyPanel.setPreferredSize(new Dimension(95, 50));
        toyPanel.setOpaque(false);
        pricePanel.setPreferredSize(new Dimension(95, 33));
        pricePanel.setOpaque(false);

        if (level != 0) {
            Image image = specialCoinIcon.getImage();
            Image resizedImage = image.getScaledInstance(33, 33, java.awt.Image.SCALE_SMOOTH);
            specialCoinIcon = new ImageIcon(resizedImage);
            specialCoinLabel = new JLabel(specialCoinIcon);
            specialCoinPanel.add(specialCoinLabel);

            if (level == 1) {
                if (specialCoinColor == "white") {
                    toyIcon = new ImageIcon("icons/cards/1circus.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (specialCoinColor == "blue") {
                    toyIcon = new ImageIcon("icons/cards/1magician.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (specialCoinColor == "green") {
                    toyIcon = new ImageIcon("icons/cards/1merrygoround.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                }
            } else if (level == 2) {
                if (specialCoinColor == "white") {
                    toyIcon = new ImageIcon("icons/cards/2ferriswheel.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (specialCoinColor == "blue") {
                    toyIcon = new ImageIcon("icons/cards/2rings.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (specialCoinColor == "green") {
                    toyIcon = new ImageIcon("icons/cards/2trampoline.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                }
            } else if (level == 3) {
                if (specialCoinColor == "green") {
                    toyIcon = new ImageIcon("icons/cards/3bumpercar.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (specialCoinColor == "blue") {
                    toyIcon = new ImageIcon("icons/cards/3rollercoaster.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (specialCoinColor == "red") {
                    toyIcon = new ImageIcon("icons/cards/3houseofmirrors.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                }
            }

            // this.add(specialCoinPanel, BorderLayout.NORTH);
        } else {
            toyIcon = new ImageIcon("icons/cards/prizeclaw.png");
            Image image = toyIcon.getImage();
            Image resizedImage = image.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
            toyIcon = new ImageIcon(resizedImage);
            toyLabel = new JLabel(toyIcon);
            toyPanel.add(toyLabel);
        }

        int priceCount = 0;
        if (price.red > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/red.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + price.red);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (price.blue > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/blue.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + price.blue);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (price.green > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/green.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + price.green);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (price.white > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/white.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + price.white);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (price.black > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/black.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + price.black);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }

        this.add(specialCoinPanel, BorderLayout.NORTH);
        this.add(toyPanel, BorderLayout.CENTER);
        this.add(pricePanel, BorderLayout.SOUTH);

        this.addActionListener(Utils.listener);
    }

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