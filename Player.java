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
    private Card[] reservedCards = new Card[3];
    private int coinCount;
    private int cardCount;
    public boolean playedTheRound;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCoinCount() {
        return coinCount;
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

    public void addCoin(Coin coin) {
        if (coin.color == "red") {
            redCoinCount++;
            if (coin.isSpecial) {
                special_redCoinCount++;
            }

        } else if (coin.color == "blue") {
            blueCoinCount++;
            if (coin.isSpecial) {
                special_blueCoinCount++;
            }

        } else if (coin.color == "green") {
            greenCoinCount++;
            if (coin.isSpecial) {
                special_greenCoinCount++;
            }

        } else if (coin.color == "blue") {
            blueCoinCount++;
            if (coin.isSpecial) {
                special_blueCoinCount++;
            }

        } else if (coin.color == "white") {
            whiteCoinCount++;
            if (coin.isSpecial) {
                special_whiteCoinCount++;
            }

        } else if (coin.color == "black") {
            blackCoinCount++;
            if (coin.isSpecial) {
                special_blackCoinCount++;
            }

        } else if (coin.color == "gold") {
            goldCoinCount++;

        }
    }

    public Coin spendCoin(String color, int count) {
        boolean inProperty = false;
        boolean isSpecial = false;
        if (color == "red") {
            if (special_redCoinCount > 0) {
                inProperty = true;
                isSpecial = true;
            } else if (redCoinCount > 0) {
                inProperty = true;
                redCoinCount -= count;
            }
        } else if (color == "blue") {
            if (special_blueCoinCount > 0) {
                inProperty = true;
                isSpecial = true;
            } else if (blueCoinCount > 0) {
                inProperty = true;
                blueCoinCount -= count;
            }
        } else if (color == "green") {
            if (special_greenCoinCount > 0) {
                inProperty = true;
                isSpecial = true;
            } else if (greenCoinCount > 0) {
                inProperty = true;
                greenCoinCount -= count;
            }
        } else if (color == "white") {
            if (special_whiteCoinCount > 0) {
                inProperty = true;
                isSpecial = true;
            } else if (whiteCoinCount > 0) {
                inProperty = true;
                whiteCoinCount -= count;
            }
        } else if (color == "black") {
            if (special_blackCoinCount > 0) {
                inProperty = true;
                isSpecial = true;
            } else if (blackCoinCount > 0) {
                inProperty = true;
                blackCoinCount -= count;
            }
        } else if (color == "gold") {
            if (goldCoinCount > 0) {
                inProperty = true;
                goldCoinCount -= count;
            }
        }

        if (inProperty) {
            return new Coin(color, isSpecial, this);
        } else {
            return null;
        }
    }

    public void buyCard(Card card) {
        if (card.price.red > 0) {
            if (spendCoin("red", card.price.red) != null) {
                cardCount++;
                this.score += card.score;
            }
        } else if (card.price.blue > 0) {
            if (spendCoin("blue", card.price.blue) != null) {
                cardCount++;
                this.score += card.score;
            }
        } else if (card.price.green > 0) {
            if (spendCoin("green", card.price.green) != null) {
                cardCount++;
                this.score += card.score;
            }
        } else if (card.price.white > 0) {
            if (spendCoin("white", card.price.white) != null) {
                cardCount++;
                this.score += card.score;
            }
        } else if (card.price.black > 0) {
            if (spendCoin("black", card.price.black) != null) {
                cardCount++;
                this.score += card.score;
            }
        }
    }

    public void takeCoinType1(Slot_Machine slotMachine) {
        slotMachine.giveCoin(this, 1);
        playedTheRound = true;
    }

    public void takeCoinType2(Slot_Machine machine1, Slot_Machine machine2, Slot_Machine machine3) {
        machine1.giveCoin(this, 2);
        machine2.giveCoin(this, 2);
        machine3.giveCoin(this, 2);
        playedTheRound = true;
    }

}
