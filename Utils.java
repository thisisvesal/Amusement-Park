public class Utils {
    public static final Listener listener = new Listener(); 
    public static final Board board = new Board();
    private static Card pressedCard;

    public static void arrangeCards() {

    }

    public static void setPressedCard(Card card) {
        Utils.pressedCard = card;
    }

    public static Card getPressedCard() {
        return pressedCard;
    }
}
