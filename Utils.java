public class Utils {
    public static final AListener listener = new AListener(); 
    public static final MListener mouseListener = new MListener();
    public static final Board board = new Board();
    private static Card pressedCard;

    public static void arrangeCards() {

    }

    public static void setPressedCard(Card card) { // Add this to class Card maybe
        Utils.pressedCard = card;
    }

    public static Card getPressedCard() {
        System.out.println("getPressed reports " + pressedCard + " card as pressed");
        return pressedCard;
    }

    public static void switchRound() {
        System.out.println("switching round");
        if (board.player1.isOn) {
            board.player1.isOn = false;
            board.player1.setHasReservedCardThisRound(false);
            board.player1.setDoneMovesCount(0);
            board.player2.isOn = true;
        } else if (board.player2.isOn) {
            board.player2.isOn = false;
            board.player2.setHasReservedCardThisRound(false);
            board.player2.setDoneMovesCount(0);
            board.player1.isOn = true;
        }

        Slot_Machine.reset();
    }

    public static void popUp(String message) {
        // Should popup a message
        System.out.println("\nPOPUP MESSAGE\n");
    }

    public static void refreshBoard() {
        board.greenCoin1.setText("" + board.player1.getCoinCount("green"));
        board.redCoin1.setText("" + board.player1.getCoinCount("red"));
        board.blueCoin1.setText("" + board.player1.getCoinCount("blue"));
        board.blackCoin1.setText("" + board.player1.getCoinCount("black"));
        board.whiteCoin1.setText("" + board.player1.getCoinCount("white"));
        board.goldCoin1.setText("" + board.player1.getCoinCount("gold"));

        board.greenCoin2.setText("" + board.player2.getCoinCount("green"));
        board.redCoin2.setText("" + board.player2.getCoinCount("red"));
        board.blueCoin2.setText("" + board.player2.getCoinCount("blue"));
        board.blackCoin2.setText("" + board.player2.getCoinCount("black"));
        board.whiteCoin2.setText("" + board.player2.getCoinCount("white"));
        board.goldCoin2.setText("" + board.player2.getCoinCount("gold"));

        board.redMachine.setText("" + board.redMachine.getCoinCount());
        board.greenMachine.setText("" + board.greenMachine.getCoinCount());
        board.blueMachine.setText("" + board.blueMachine.getCoinCount());
        board.blackMachine.setText("" + board.blackMachine.getCoinCount());
        board.whiteMachine.setText("" + board.whiteMachine.getCoinCount());

        board.score1.setText("" + board.player1.getScore());
        board.score2.setText("" + board.player2.getScore());
        
    }
}
