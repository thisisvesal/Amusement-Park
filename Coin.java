import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Coin extends JLabel{
    final String color;
    final boolean isSpecial;
    private Player owner;

    public Coin(String color, boolean isSpecial, Player owner) {
        this.color = color;
        this.isSpecial = isSpecial;
        this.owner = owner;
        this.setIcon(new ImageIcon("icons/coins/" + color + ".png"));
        this.setText("" + owner.getCoinCount(color));
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setHorizontalTextPosition(JLabel.CENTER);
    }

    public Coin(String color, boolean isSpecial) {
        this(color, isSpecial, Utils.board.player1);
    }

    public Coin(String color, Player owner) {
        this(color, false, owner);
        this.setText("" + owner.getCoinCount(color));
    }

    public Coin(String color) {
        this.color = color;
        this.isSpecial = false;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    public Player getOwner() {
        return owner;
    }
}