import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Slot_Machine extends JButton{
    public final String color;
    private int coinCount = 4;

    public Slot_Machine(String color, ImageIcon icon) {
        this.color = color;
        this.setIcon(icon); // https://icons8.com/icon/16446/slot-machine
        this.setBackground(new Color(48, 181, 199));
        this.setFocusable(false);
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void giveCoin(Player player, int requestType) {
        if (requestType == 1) {
            if (coinCount == 4) {
                player.addCoin(new Coin(color, player));
                player.addCoin(new Coin(color, player));
            } else {
                requestType = 2; // I don't know if this is okay, change it if needed
            }
        }
        if (requestType == 2) {
            player.addCoin(new Coin(color, player));
        }
    }
}
