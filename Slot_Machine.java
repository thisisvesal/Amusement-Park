public class Slot_Machine {
    public final String color;
    private int coinCount = 4;

    public Slot_Machine(String color) {
        this.color = color;
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
