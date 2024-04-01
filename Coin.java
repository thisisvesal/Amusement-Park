public class Coin {
    final String color;
    final boolean isSpecial;
    private Player owner;

    public Coin(String color, boolean isSpecial, Player owner) {
        this.color = color;
        this.isSpecial = isSpecial;
        this.owner = owner;
    }

    public Coin(String color, Player owner) {
        this(color, false, owner);
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