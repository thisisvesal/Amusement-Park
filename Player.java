import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player {
    private String name;
    private int redCoinCount;
    private int superRedCoinCount;
    private int blueCoinCount;
    private int superBlueCoinCount;
    private int greenCoinCount;
    private int superGreenCoinCount;
    private int whiteCoinCount;
    private int superWhiteCoinCount;
    private int blackCoinCount;
    private int superBlackCoinCount;
    private int goldCoinCount;
    private int reservedCardCount;
    private boolean hasReservedCardThisRound;
    private Card[] reservedCards = new Card[3];
    private int cardCount;
    public boolean isOn;
    private int score;
    public final Cursor cursor;
    private int doneMovesCount;
    public final String color;

    public Player(String name) {
        this.name = name;
        if (name == "Player1") {
            Image icon = new ImageIcon("icons/cursors/purpleSmall.png").getImage();
            cursor = Toolkit.getDefaultToolkit().createCustomCursor(icon, new Point(0, 0), "cursor1");
            color = "purple";
        } else if (name == "Player2") {
            Image icon = new ImageIcon("icons/cursors/greenSmall.png").getImage();
            cursor = Toolkit.getDefaultToolkit().createCustomCursor(icon, new Point(0, 0), "cursor1");
            color = "green";
        } else {
            cursor = Cursor.getDefaultCursor();
            color = null;
        }

    }

    public String getName() {
        return name;
    }

    public void setCoinCount(String color, int count) {
        if (color == "red") {
            this.redCoinCount = count;
        } else if (color == "blue") {
            this.blueCoinCount = count;
        } else if (color == "green") {
            this.greenCoinCount = count;
        } else if (color == "black") {
            this.blackCoinCount = count;
        } else if (color == "white") {
            this.whiteCoinCount = count;
        } else if (color == "gold") {
            this.goldCoinCount = count;
        }
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
        } else if (color == "gold") {
            return goldCoinCount;
        } else if (color == "all") {
            return redCoinCount + blueCoinCount + greenCoinCount + whiteCoinCount + blackCoinCount + goldCoinCount;
        }
        return 0;
    }

    public int getSuperCoinCount(String color) {
        if (color == "red") {
            return superRedCoinCount;
        } else if (color == "blue") {
            return superBlueCoinCount;
        } else if (color == "green") {
            return superGreenCoinCount;
        } else if (color == "black") {
            return superBlackCoinCount;
        } else if (color == "white") {
            return superWhiteCoinCount;
        } else if (color == "all") {
            return superRedCoinCount + superBlueCoinCount + superGreenCoinCount + superWhiteCoinCount
                    + superBlackCoinCount;
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

    private void getPrize() {
        System.out.println("Prizeclaw length: " + Utils.board.prizeclawCards.size());
        for (int i = 0; i < Utils.board.prizeclawCards.size(); i++) {
            System.out.println("Iterating " + i);
            Card card = Utils.board.prizeclawCards.get(i);
            if (this.canPay(card.price, true)) {
                System.out.println("The player can pay for " + card);
                pay(card.price);
                cardCount++;
                this.score += card.score;
                card.setOwner(this);
                MusicPlayer.play("music/mixkit-arcade-game-complete-or-approved-mission-205.wav");
                Utils.popUp("PRIZE", "Congrats! You got a prize claw card");
                Utils.board.prizeclawPanel.remove(card);
                Utils.board.prizeclawCards.remove(card);
                Utils.replace(card);
            }
        }
    }

    public boolean canPay(Price price, boolean isPrizeclaw) {
        boolean inProperty = true;
        if (!isPrizeclaw) {
            if (price.red > 0 && goldCoinCount + redCoinCount + superRedCoinCount < price.red) {
                inProperty = false;
            }
            if (price.blue > 0 && goldCoinCount + blueCoinCount + superBlueCoinCount < price.blue) {
                inProperty = false;
            }
            if (price.green > 0 && goldCoinCount + greenCoinCount + superGreenCoinCount < price.green) {
                inProperty = false;
            }
            if (price.black > 0 && goldCoinCount + blackCoinCount + superBlackCoinCount < price.black) {
                inProperty = false;
            }
            if (price.white > 0 && goldCoinCount + whiteCoinCount + superWhiteCoinCount < price.white) {
                inProperty = false;
            }
        } else {
            if (price.red > 0 && superRedCoinCount < price.red) {
                inProperty = false;
            }
            if (price.blue > 0 && superBlueCoinCount < price.blue) {
                inProperty = false;
            }
            if (price.green > 0 && superGreenCoinCount < price.green) {
                inProperty = false;
            }
            if (price.black > 0 && superBlackCoinCount < price.black) {
                inProperty = false;
            }
            if (price.white > 0 && superWhiteCoinCount < price.white) {
                inProperty = false;
            }
        }
        return inProperty;
    }

    public void pay(Price price) {
        if (price.red > 0) {
            if (superRedCoinCount >= price.red) {

            } else if (superRedCoinCount + redCoinCount >= price.red) {
                redCoinCount -= price.red - superRedCoinCount;
            } else {
                goldCoinCount -= price.red - redCoinCount - superRedCoinCount;
                redCoinCount = 0;
            }
        }
        if (price.blue > 0) {
            if (superBlueCoinCount >= price.blue) {

            } else if (superBlueCoinCount + blueCoinCount >= price.blue) {
                blueCoinCount -= price.blue - superBlueCoinCount;
            } else {
                goldCoinCount -= price.blue - blueCoinCount - superBlueCoinCount;
                blueCoinCount = 0;
            }
        }
        if (price.green > 0) {
            if (superGreenCoinCount >= price.green) {

            } else if (superGreenCoinCount + greenCoinCount >= price.green) {
                greenCoinCount -= price.green - superGreenCoinCount;
            } else {
                goldCoinCount -= price.green - greenCoinCount - superGreenCoinCount;
                greenCoinCount = 0;
            }
        }
        if (price.black > 0) {
            if (superBlackCoinCount >= price.black) {

            } else if (superBlackCoinCount + blackCoinCount >= price.black) {
                blackCoinCount -= price.black - superBlackCoinCount;
            } else {
                goldCoinCount -= price.black - blackCoinCount - superBlackCoinCount;
                blackCoinCount = 0;
            }
        }
        if (price.white > 0) {
            if (superWhiteCoinCount >= price.white) {

            } else if (superWhiteCoinCount + whiteCoinCount >= price.white) {
                whiteCoinCount -= price.white - superWhiteCoinCount;
            } else {
                goldCoinCount -= price.white - whiteCoinCount - superWhiteCoinCount;
                whiteCoinCount = 0;
            }
        }
    }

    public void buyCard(Card card) {
        if (canPay(card.price, card.isPrizeclaw) && (!card.isReserved() || this.hasReserved(card))) {
            pay(card.price);
            cardCount++;
            doneMovesCount++;
            this.score += card.score;
            card.setOwner(this);

            MusicPlayer.play("music/mixkit-gold-coin-prize-1999.wav");

            if (card.isReserved()) {
                if (Utils.getPlayerOfTheRound() == Utils.board.player1) {
                    Utils.board.reservedCardPanel1.remove(card);
                } else if (Utils.getPlayerOfTheRound() == Utils.board.player2) {
                    Utils.board.reservedCardPanel2.remove(card);
                }
            } else {
                if (card.level == 1) {
                    Utils.board.lvl1Panel.remove(card);
                } else if (card.level == 2) {
                    Utils.board.lvl2Panel.remove(card);
                } else if (card.level == 3) {
                    Utils.board.lvl3Panel.remove(card);
                }
                Utils.replace(card);
            }

            if (card.superCoin.color == "red") {
                superRedCoinCount++;
            } else if (card.superCoin.color == "blue") {
                superBlueCoinCount++;
            } else if (card.superCoin.color == "green") {
                superGreenCoinCount++;
            } else if (card.superCoin.color == "black") {
                superBlackCoinCount++;
            } else if (card.superCoin.color == "white") {
                superWhiteCoinCount++;
            }

            this.getPrize();

        } else {
            MusicPlayer.play("music/mixkit-single-key-type-2533.wav");
            Utils.popUp("Whoops!", "You can't buy this card!");
        }
    }

    public boolean doubleCoinRequestedFrom(Slot_Machine slotMachine) {
        if (Slot_Machine.getPressedMachineCount() > 1 && slotMachine.wasPressedThisRound()) {
            return true;
        } else {
            return false;
        }
    }

    public void takeCoin(Slot_Machine slotMachine) {
        if (this.name != "Banker") {
            if (getCoinCount("all") < 10 && !doubleCoinRequestedFrom(slotMachine)) {
                slotMachine.press();
                slotMachine.removeOneCoin();
                MusicPlayer.play("music/mixkit-coins-sound-2003.wav");
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
            } else if (getCoinCount("all") >= 10) {
                MusicPlayer.play("music/mixkit-arcade-game-jump-coin-216.wav");
                Utils.popUp("Whoops!", "You can't have more than 10 coins at once!\nReturn some coins if you want");
            } else if (doubleCoinRequestedFrom(slotMachine)) {
                MusicPlayer.play("music/mixkit-arcade-game-jump-coin-216.wav");
                Utils.popUp("Whoops!", "You just took a coin from here, choose another machine");
            }
        }

    }

    public void reserve(Card card) {
        if (hasReservedCardThisRound || reservedCardCount >= 3) {
            MusicPlayer.play("music/mixkit-single-key-type-2533.wav");
            Utils.popUp("Whoops!", "You can't reserve any more cards!");
        } else {
            MusicPlayer.play("music/mixkit-paper-slide-1530.wav");
            card.reserve();
            reservedCards[reservedCardCount] = card;
            reservedCardCount++;
            if (Utils.getPlayerOfTheRound() == Utils.board.player1) {
                Utils.board.reservedCardPanel1.add(card);
            } else if (Utils.getPlayerOfTheRound() == Utils.board.player2) {
                Utils.board.reservedCardPanel2.add(card);
            }
            Utils.replace(card);

            hasReservedCardThisRound = true;
            doneMovesCount++;

            card.buttonPanel.remove(card.reserveButton);
            card.buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            card.setPreferredSize(new Dimension(100, 160));
            card.buttonPanel.setPreferredSize(new Dimension(100, 30));

            if (Utils.board.banker.goldCoinCount > 0) {
                Utils.board.banker.goldCoinCount--;
                goldCoinCount++;
                System.out.println(this.name + "'s gold coin count is " + goldCoinCount);
            }

        }
    }

    public void unreserve(Card card) {
        card.reserve();
        reservedCards[reservedCardCount] = card;
        boolean found = false;
        for (int i = 0; i < reservedCards.length - 1; i++) {
            if (card == reservedCards[i]) {
                found = true;
            }
            if (found) {
                reservedCards[i] = reservedCards[i + 1];
            }
        }
        reservedCardCount--;
        if (Utils.getPlayerOfTheRound() == Utils.board.player1) {
            Utils.board.reservedCardPanel1.remove(card);
        } else if (Utils.getPlayerOfTheRound() == Utils.board.player2) {
            Utils.board.reservedCardPanel2.remove(card);
        }

        doneMovesCount++;

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

    public boolean hasReserved(Card card) {
        for (int i = 0; i < reservedCards.length; i++) {
            if (reservedCards[i] == card) {
                return true;
            }
        }
        return false;
    }

    public void returnCoin(String color) {
        if (color == "red") {
            this.redCoinCount--;
            Utils.board.redMachine.addOneCoin();
        } else if (color == "blue") {
            this.blueCoinCount--;
            Utils.board.blueMachine.addOneCoin();
        } else if (color == "green") {
            this.greenCoinCount--;
            Utils.board.greenMachine.addOneCoin();
        } else if (color == "black") {
            this.blackCoinCount--;
            Utils.board.blackMachine.addOneCoin();
        } else if (color == "white") {
            this.whiteCoinCount--;
            Utils.board.whiteMachine.addOneCoin();
        }
    }
}
