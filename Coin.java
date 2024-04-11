import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Coin extends JButton {
    public final String color;
    public final boolean isSpecial;
    private Player owner;
    // public final JLabel label = new JLabel();
    

    public Coin(String color, boolean isSpecial, Player owner) {
        this.color = color;
        this.isSpecial = isSpecial;
        this.owner = owner;
        if (isSpecial) {
            this.setIcon(Utils.getResizedIcon(new ImageIcon("icons/supercoins/" + color + ".png"), 40, 40));
            this.setText("" + owner.getSuperCoinCount(color));
        } else {
            this.setIcon(Utils.getResizedIcon(new ImageIcon("icons/coins/" + color + ".png"), 40, 40));
            this.setText("" + owner.getCoinCount(color));
        }
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setHorizontalTextPosition(JLabel.CENTER);

        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        if (!isSpecial && color != "gold") {
            this.addActionListener(Utils.listener);
        }
    }

    public Coin(String color, boolean isSpecial) {
        this(color, isSpecial, Utils.board.player1);
    }

    public Coin(String color, Player owner) {
        this(color, false, owner);
        this.setText("" + owner.getCoinCount(color));
    }

    public Coin(String color) {
        this(color, false, Utils.board.banker);
    }

    public void setOwner(Player player) {
        owner = player;
    }

    public Player getOwner() {
        return owner;
    }
}