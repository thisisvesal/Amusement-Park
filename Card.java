public class Card {
    public final int level;
    public final Coin specialCoin;
    public final int score;
    private Player owner;
    private boolean reserved;
    public final Price price;

    public Card(int level, int score, String specialCoinColor, Price price) {
        this.level = level;
        this.score = score;
        specialCoin = new Coin(specialCoinColor, true, this.owner);
        this.price = price;
    }

    public void reserve() {
        reserved = true;
    }

    public boolean isReserved() {
        return reserved;
    }
}