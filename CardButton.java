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

public class CardButton extends JButton {
    public final Card card;
    public CardButton(Card card)
    {
        this.card = card;
        this.setPreferredSize(new Dimension(110, 180));
        this.setOpaque(true);
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(100, 150));
        this.setBackground(new Color(232, 249, 250));
        this.setFocusable(false);
        this.setLayout(new BorderLayout(0, 0));
        ImageIcon superCoinIcon = new ImageIcon("icons/coins/" + this.card.superCoin.color + ".png");
        ImageIcon toyIcon;
        ImageIcon[] priceIcon = new ImageIcon[3];
        JLabel superCoinLabel = new JLabel();
        JLabel toyLabel;
        JLabel[] priceLabel = new JLabel[3];
        JPanel superCoinPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 0, 0));
        JPanel toyPanel = new JPanel(new FlowLayout());
        JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JLabel scoreLabel = new JLabel("" + card.score + " ");
        scoreLabel.setPreferredSize(new Dimension(15, 15));
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);

        superCoinPanel.setPreferredSize(new Dimension(95, 33));
        superCoinPanel.setOpaque(false);
        superCoinPanel.add(scoreLabel);
        toyPanel.setPreferredSize(new Dimension(95, 50));
        toyPanel.setOpaque(false);
        pricePanel.setPreferredSize(new Dimension(95, 33));
        pricePanel.setOpaque(false);

        if (card.level != 0) {
            Image image = superCoinIcon.getImage();
            Image resizedImage = image.getScaledInstance(33, 33, java.awt.Image.SCALE_SMOOTH);
            superCoinIcon = new ImageIcon(resizedImage);
            superCoinLabel = new JLabel(superCoinIcon);
            superCoinPanel.add(superCoinLabel);

            if (card.level == 1) {
                if (card.superCoin.color == "white") {
                    toyIcon = new ImageIcon("icons/cards/1circus.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (card.superCoin.color == "blue") {
                    toyIcon = new ImageIcon("icons/cards/1magician.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (card.superCoin.color == "green") {
                    toyIcon = new ImageIcon("icons/cards/1merrygoround.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                }
            } else if (card.level == 2) {
                if (card.superCoin.color == "white") {
                    toyIcon = new ImageIcon("icons/cards/2ferriswheel.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (card.superCoin.color == "blue") {
                    toyIcon = new ImageIcon("icons/cards/2rings.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (card.superCoin.color == "green") {
                    toyIcon = new ImageIcon("icons/cards/2trampoline.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                }
            } else if (card.level == 3) {
                if (card.superCoin.color == "green") {
                    toyIcon = new ImageIcon("icons/cards/3bumpercar.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (card.superCoin.color == "blue") {
                    toyIcon = new ImageIcon("icons/cards/3rollercoaster.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                } else if (card.superCoin.color == "red") {
                    toyIcon = new ImageIcon("icons/cards/3houseofmirrors.png");
                    image = toyIcon.getImage();
                    resizedImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    toyIcon = new ImageIcon(resizedImage);
                    toyLabel = new JLabel(toyIcon);
                    toyPanel.add(toyLabel);
                }
            }

            // this.add(superCoinPanel, BorderLayout.NORTH);
        } else {
            toyIcon = new ImageIcon("icons/cards/prizeclaw.png");
            Image image = toyIcon.getImage();
            Image resizedImage = image.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
            toyIcon = new ImageIcon(resizedImage);
            toyLabel = new JLabel(toyIcon);
            toyPanel.add(toyLabel);
        }

        int priceCount = 0;
        if (card.price.red > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/red.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + card.price.red);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (card.price.blue > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/blue.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + card.price.blue);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (card.price.green > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/green.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + card.price.green);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (card.price.white > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/white.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + card.price.white);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }
        if (card.price.black > 0) {
            priceIcon[priceCount] = new ImageIcon("icons/coins/black.png");
            Image image = priceIcon[priceCount].getImage();
            Image resizedImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            priceIcon[priceCount] = new ImageIcon(resizedImage);
            priceLabel[priceCount] = new JLabel(priceIcon[priceCount]);
            priceLabel[priceCount].setText("" + card.price.black);
            priceLabel[priceCount].setHorizontalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setVerticalTextPosition(JLabel.CENTER);
            priceLabel[priceCount].setFont(new Font("Tahoma", Font.BOLD, 12));
            priceLabel[priceCount].setForeground(Color.white);
            pricePanel.add(priceLabel[priceCount]);
            priceCount++;
        }

        this.add(superCoinPanel, BorderLayout.NORTH);
        this.add(toyPanel, BorderLayout.CENTER);
        this.add(pricePanel, BorderLayout.SOUTH);
        this.addActionListener(Utils.listener);
    }

    public Card getCard() {
        return card;
    }
}
