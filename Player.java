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
        if (!isPrizeclaw) {
            int goldCopy = goldCoinCount;
            if (price.red > 0 && goldCoinCount + redCoinCount + superRedCoinCount < price.red) {
                return false;
            } else if (price.red > 0 && redCoinCount + superRedCoinCount < price.red) {
                goldCopy -= price.red - redCoinCount - superRedCoinCount;
            }

            if (price.blue > 0 && goldCoinCount + blueCoinCount + superBlueCoinCount < price.blue) {
                return false;
            } else if (price.blue > 0 && blueCoinCount + superBlueCoinCount < price.blue) {
                goldCopy -= price.blue - blueCoinCount - superBlueCoinCount;
            }

            if (price.green > 0 && goldCoinCount + greenCoinCount + superGreenCoinCount < price.green) {
                return false;
            } else if (price.green > 0 && greenCoinCount + superGreenCoinCount < price.green) {
                goldCopy -= price.green - greenCoinCount - superGreenCoinCount;
            }

            if (price.black > 0 && goldCoinCount + blackCoinCount + superBlackCoinCount < price.black) {
                return false;
            } else if (price.black > 0 && blackCoinCount + superBlackCoinCount < price.black) {
                goldCopy -= price.black - blackCoinCount - superBlackCoinCount;
            }

            if (price.white > 0 && goldCoinCount + whiteCoinCount + superWhiteCoinCount < price.white) {
                return false;
            } else if (price.white > 0 && whiteCoinCount + superWhiteCoinCount < price.white) {
                goldCopy -= price.white - whiteCoinCount - superWhiteCoinCount;
            }

            if (goldCopy < 0) {
                return false;
            }

        } else {
            if (price.red > 0 && superRedCoinCount < price.red) {
                return false;
            }
            if (price.blue > 0 && superBlueCoinCount < price.blue) {
                return false;
            }
            if (price.green > 0 && superGreenCoinCount < price.green) {
                return false;
            }
            if (price.black > 0 && superBlackCoinCount < price.black) {
                return false;
            }
            if (price.white > 0 && superWhiteCoinCount < price.white) {
                return false;
            }
        }
        return true;
    }

    public void pay(Price price) {
        if (price.red > 0) {
            if (superRedCoinCount >= price.red) {
                // Do something if you have enough superRedCoins
            } else if (superRedCoinCount + redCoinCount >= price.red) {
                returnCoin("red", price.red - superRedCoinCount);
            } else {
                returnCoin("gold", price.red - redCoinCount - superRedCoinCount);
                returnCoin("red", redCoinCount);
            }
        }
        if (price.blue > 0) {
            if (superBlueCoinCount >= price.blue) {
                // Do something if you have enough superBlueCoins
            } else if (superBlueCoinCount + blueCoinCount >= price.blue) {
                returnCoin("blue", price.blue - superBlueCoinCount);
            } else {
                returnCoin("gold", price.blue - blueCoinCount - superBlueCoinCount);
                returnCoin("blue", blueCoinCount);
            }
        }
        if (price.green > 0) {
            if (superGreenCoinCount >= price.green) {
                // Do something if you have enough superGreenCoins
            } else if (superGreenCoinCount + greenCoinCount >= price.green) {
                returnCoin("green", price.green - superGreenCoinCount);
            } else {
                returnCoin("gold", price.green - greenCoinCount - superGreenCoinCount);
                returnCoin("green", greenCoinCount);
            }
        }
        if (price.black > 0) {
            if (superBlackCoinCount >= price.black) {

            } else if (superBlackCoinCount + blackCoinCount >= price.black) {
                returnCoin("black", price.black - superBlackCoinCount);
            } else {
                returnCoin("gold", price.black - blackCoinCount - superBlackCoinCount);
                returnCoin("black", blackCoinCount);
            }
        }
        if (price.white > 0) {
            if (superWhiteCoinCount >= price.white) {

            } else if (superWhiteCoinCount + whiteCoinCount >= price.white) {
                returnCoin("white", price.white - superWhiteCoinCount);
            } else {
                returnCoin("gold", price.white - whiteCoinCount - superWhiteCoinCount);
                returnCoin("white", whiteCoinCount);
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
            card.setPreferredSize(new Dimension(100, 200));
            card.buttonPanel.setPreferredSize(new Dimension(70, 70));
            card.buttonPanel.add(card.unreserveButton);

            if (Utils.board.banker.goldCoinCount > 0) {
                Utils.board.banker.goldCoinCount--;
                goldCoinCount++;
                System.out.println(this.name + "'s gold coin count is " + goldCoinCount);
            }

        }
    }

    public void unreserve(Card card) {
        card.unreserve();
        reservedCards[reservedCardCount] = card;
        System.out.println(reservedCardCount);
        for (int i = 0; i < reservedCardCount; i++) {
            if (card == reservedCards[i]) {
                reservedCards[i] = reservedCards[i + 1];
            }
            System.out.println(i);
        }
        reservedCardCount--;
        if (Utils.getPlayerOfTheRound() == Utils.board.player1) {
            Utils.board.reservedCardPanel1.remove(card);
        } else if (Utils.getPlayerOfTheRound() == Utils.board.player2) {
            Utils.board.reservedCardPanel2.remove(card);
        }

        MusicPlayer.play("music/mixkit-paper-slide-1530.wav");
        Utils.board.revalidate();
        Utils.board.repaint();

        if (card.level == 1) {
            Utils.board.lvl1Cards.add(card);
        } else if (card.level == 2) {
            Utils.board.lvl2Cards.add(card);
        } else if (card.level == 3) {
            Utils.board.lvl3Cards.add(card);
        }
        doneMovesCount++;

        System.out.println(Utils.board.lvl1Cards.size());
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
            Utils.board.redMachine.addCoin();
        } else if (color == "blue") {
            this.blueCoinCount--;
            Utils.board.blueMachine.addCoin();
        } else if (color == "green") {
            this.greenCoinCount--;
            Utils.board.greenMachine.addCoin();
        } else if (color == "black") {
            this.blackCoinCount--;
            Utils.board.blackMachine.addCoin();
        } else if (color == "white") {
            this.whiteCoinCount--;
            Utils.board.whiteMachine.addCoin();
        } else if (color == "gold") {
            this.goldCoinCount--;
            Utils.board.banker.goldCoinCount++;
        }
    }

    public void returnCoin(String color, int count) {
        if (color == "red") {
            this.redCoinCount -= count;
            Utils.board.redMachine.addCoin(count);
        } else if (color == "blue") {
            this.blueCoinCount -= count;
            Utils.board.blueMachine.addCoin(count);
        } else if (color == "green") {
            this.greenCoinCount -= count;
            Utils.board.greenMachine.addCoin(count);
        } else if (color == "black") {
            this.blackCoinCount -= count;
            Utils.board.blackMachine.addCoin(count);
        } else if (color == "white") {
            this.whiteCoinCount -= count;
            Utils.board.whiteMachine.addCoin(count);
        } else if (color == "gold") {
            this.goldCoinCount -= count;
            Utils.board.banker.goldCoinCount += count;
        }
    }
}
