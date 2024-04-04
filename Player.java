import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player {
    private String name;
    private int redCoinCount;
    private int special_redCoinCount;
    private int blueCoinCount;
    private int special_blueCoinCount;
    private int greenCoinCount;
    private int special_greenCoinCount;
    private int whiteCoinCount;
    private int special_whiteCoinCount;
    private int blackCoinCount;
    private int special_blackCoinCount;
    private int goldCoinCount;
    private int reservedCardCount;
    private boolean hasReservedCardThisRound;
    private Card[] reservedCards = new Card[3];
    private int coinCount;
    private int cardCount;
    public boolean isOn;
    private int score;
    public final Cursor cursor;
    private int doneMovesCount;

    public Player(String name) {
        this.name = name;
        if (name == "Player1") {
            Image icon = new ImageIcon("icons/cursors/purpleSmall.png").getImage();
            cursor = Toolkit.getDefaultToolkit().createCustomCursor(icon, new Point(0, 0), "cursor1");
        } else if (name == "Player2") {
            Image icon = new ImageIcon("icons/cursors/greenSmall.png").getImage();
            cursor = Toolkit.getDefaultToolkit().createCustomCursor(icon, new Point(0, 0), "cursor1");
        } else {
            cursor = Cursor.getDefaultCursor();
        }

    }

    public String getName() {
        return name;
    }

    public int getCoinCount(String color) {
        if (color == "red") {
            return redCoinCount;
        } else if (color == "blue") {
            return blueCoinCount;
        } else if (color == "green") {
            return greenCoinCount;
        } else if (color == "black") {
            return blackCoinCount;
        } else if (color == "white") {
            return whiteCoinCount;
        } else if (color == "all") {
            return coinCount;
        }
        return 0;
    }

    public int getCardCount() {
        return cardCount;
    }

    public int getReservedCount() {
        return reservedCardCount;
    }

    public int getScore() {
        return score;
    }

    public boolean pay(Price price) {
        boolean inProperty = false;
        if (price.red > 0 && goldCoinCount + redCoinCount + special_redCoinCount >= price.red) {
            if (special_redCoinCount >= price.red) {

            } else if (special_redCoinCount + redCoinCount >= price.red) {
                redCoinCount -= price.red - special_redCoinCount;
            } else {
                goldCoinCount -= price.red - redCoinCount - special_redCoinCount;
                redCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.blue > 0 && goldCoinCount + blueCoinCount + special_blueCoinCount >= price.blue) {
            if (special_blueCoinCount >= price.blue) {

            } else if (special_blueCoinCount + blueCoinCount >= price.blue) {
                blueCoinCount -= price.blue - special_blueCoinCount;
            } else {
                goldCoinCount -= price.blue - blueCoinCount - special_blueCoinCount;
                blueCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.green > 0 && goldCoinCount + greenCoinCount + special_greenCoinCount >= price.green) {
            if (special_greenCoinCount >= price.green) {

            } else if (special_greenCoinCount + greenCoinCount >= price.green) {
                greenCoinCount -= price.green - special_greenCoinCount;
            } else {
                goldCoinCount -= price.green - greenCoinCount - special_greenCoinCount;
                greenCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.black > 0 && goldCoinCount + blackCoinCount + special_blackCoinCount >= price.black) {
            if (special_blackCoinCount >= price.black) {

            } else if (special_blackCoinCount + blackCoinCount >= price.black) {
                blackCoinCount -= price.black - special_blackCoinCount;
            } else {
                goldCoinCount -= price.black - blackCoinCount - special_blackCoinCount;
                blackCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.white > 0 && goldCoinCount + whiteCoinCount + special_whiteCoinCount >= price.white) {
            if (special_whiteCoinCount >= price.white) {

            } else if (special_whiteCoinCount + whiteCoinCount >= price.white) {
                whiteCoinCount -= price.white - special_whiteCoinCount;
            } else {
                goldCoinCount -= price.white - whiteCoinCount - special_whiteCoinCount;
                whiteCoinCount = 0;
            }
            inProperty = true;
        }
        return inProperty;
    }

    public void buyCard(Card card) {
        if (pay(card.price)) {
            cardCount++;
            doneMovesCount++;
            this.score += card.score;
            card.setOwner(this);
            
            if (card.specialCoin.color == "red") {
                special_redCoinCount++;
            } else if (card.specialCoin.color == "blue") {
                special_blueCoinCount++;
            } else if (card.specialCoin.color == "green") {
                special_greenCoinCount++;
            } else if (card.specialCoin.color == "black") {
                special_blackCoinCount++;
            } else if (card.specialCoin.color == "white") {
                special_whiteCoinCount++;
            }
        }
        else {
            System.out.println("\nThe player doesn't have enough money!");
        }
    }

    public void takeCoin(Slot_Machine slotMachine) {
        slotMachine.press();
        slotMachine.removeOneCoin();
        if (slotMachine.color == "red") {
            redCoinCount++;
        } else if (slotMachine.color == "blue") {
            blueCoinCount++;
        } else if (slotMachine.color == "green") {
            greenCoinCount++;
        } else if (slotMachine.color == "white") {
            whiteCoinCount++;
        } else if (slotMachine.color == "black") {
            blackCoinCount++;
        }

        if (Slot_Machine.isDoneForTheRound() && this.doneMovesCount < 3) {
            doneMovesCount++;
            Utils.board.redMachine.setEnabled(false);
            Utils.board.greenMachine.setEnabled(false);
            Utils.board.blueMachine.setEnabled(false);
            Utils.board.whiteMachine.setEnabled(false);
            Utils.board.blackMachine.setEnabled(false);
        }
        
    }

    

    public void reserve(Card card) {
        if (hasReservedCardThisRound || reservedCardCount >= 3) {
            Utils.popUp("You can't reserve any more cards!");
        } else {
            reservedCards[reservedCardCount] = card;
            reservedCardCount++;
            hasReservedCardThisRound = true;
            doneMovesCount++;
        }
    }

    public boolean isRoundFinished() {
        System.out.println("Done moves of " + name + ": " + doneMovesCount);
        if (doneMovesCount == 3) {
            return true;
        }
        return false;
    }

    public void addOneMove() {
        doneMovesCount++;
    }

    public void setHasReservedCardThisRound(boolean hasReservedCardThisRound) {
        this.hasReservedCardThisRound = hasReservedCardThisRound;
    }

    public void setDoneMovesCount(int doneMovesCount) {
        this.doneMovesCount = doneMovesCount;
    }

}
