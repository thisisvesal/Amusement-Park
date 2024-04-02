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
    public boolean isOn;
    private int score;

    public Player(String name) {
        this.name = name;
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

    public void addCoin(Coin coin) {
        if (coin.color == "red") {
            redCoinCount++;
        } else if (coin.color == "blue") {
            blueCoinCount++;
        } else if (coin.color == "green") {
            greenCoinCount++;
        } else if (coin.color == "blue") {
            blueCoinCount++;
        } else if (coin.color == "white") {
            whiteCoinCount++;
        } else if (coin.color == "black") {
            blackCoinCount++;
        } else if (coin.color == "gold") {
            goldCoinCount++;
        }
    }

    public boolean pay(Price price) {
        boolean inProperty = false;
        if (price.red > 0 && goldCoinCount + redCoinCount + special_redCoinCount > price.red) {
            if (special_redCoinCount > price.red) {

            } else if (special_redCoinCount + redCoinCount > price.red) {
                redCoinCount -= price.red - special_redCoinCount;
            } else {
                goldCoinCount -= price.red - redCoinCount - special_redCoinCount;
                redCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.blue > 0 && goldCoinCount + blueCoinCount + special_blueCoinCount > price.blue) {
            if (special_blueCoinCount > price.blue) {

            } else if (special_blueCoinCount + blueCoinCount > price.blue) {
                blueCoinCount -= price.blue - special_blueCoinCount;
            } else {
                goldCoinCount -= price.blue - blueCoinCount - special_blueCoinCount;
                blueCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.green > 0 && goldCoinCount + greenCoinCount + special_greenCoinCount > price.green) {
            if (special_greenCoinCount > price.green) {

            } else if (special_greenCoinCount + greenCoinCount > price.green) {
                greenCoinCount -= price.green - special_greenCoinCount;
            } else {
                goldCoinCount -= price.green - greenCoinCount - special_greenCoinCount;
                greenCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.black > 0 && goldCoinCount + blackCoinCount + special_blackCoinCount > price.black) {
            if (special_blackCoinCount > price.black) {

            } else if (special_blackCoinCount + blackCoinCount > price.black) {
                blackCoinCount -= price.black - special_blackCoinCount;
            } else {
                goldCoinCount -= price.black - blackCoinCount - special_blackCoinCount;
                blackCoinCount = 0;
            }
            inProperty = true;
        }
        if (price.white > 0 && goldCoinCount + whiteCoinCount + special_whiteCoinCount > price.white) {
            if (special_whiteCoinCount > price.white) {

            } else if (special_whiteCoinCount + whiteCoinCount > price.white) {
                whiteCoinCount -= price.white - special_whiteCoinCount;
            } else {
                goldCoinCount -= price.white - whiteCoinCount - special_whiteCoinCount;
                whiteCoinCount = 0;
            }
            inProperty = true;
        }
        return inProperty;
    }

    // public Coin spendCoin(String color, int count) {
    // boolean inProperty = false;
    // boolean isSpecial = false;
    // if (color == "red") {
    // if (special_redCoinCount > 0) {
    // inProperty = true;
    // isSpecial = true;
    // } else if (redCoinCount > 0) {
    // inProperty = true;
    // redCoinCount -= count;
    // }
    // } else if (color == "blue") {
    // if (special_blueCoinCount > 0) {
    // inProperty = true;
    // isSpecial = true;
    // } else if (blueCoinCount > 0) {
    // inProperty = true;
    // blueCoinCount -= count;
    // }
    // } else if (color == "green") {
    // if (special_greenCoinCount > 0) {
    // inProperty = true;
    // isSpecial = true;
    // } else if (greenCoinCount > 0) {
    // inProperty = true;
    // greenCoinCount -= count;
    // }
    // } else if (color == "white") {
    // if (special_whiteCoinCount > 0) {
    // inProperty = true;
    // isSpecial = true;
    // } else if (whiteCoinCount > 0) {
    // inProperty = true;
    // whiteCoinCount -= count;
    // }
    // } else if (color == "black") {
    // if (special_blackCoinCount > 0) {
    // inProperty = true;
    // isSpecial = true;
    // } else if (blackCoinCount > 0) {
    // inProperty = true;
    // blackCoinCount -= count;
    // }
    // } else if (color == "gold") {
    // if (goldCoinCount > 0) {
    // inProperty = true;
    // goldCoinCount -= count;
    // }
    // }

    // if (inProperty) {
    // return new Coin(color, isSpecial, this);
    // } else {
    // return null;
    // }
    // }

    public void buyCard(Card card) {
        if (pay(card.price)) {
            cardCount++;
            this.score += card.score;
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
    }

    public void takeCoinType1(Slot_Machine slotMachine) {
        slotMachine.giveCoin(this, 1);
    }

    public void takeCoinType2(Slot_Machine machine1, Slot_Machine machine2, Slot_Machine machine3) {
        machine1.giveCoin(this, 2);
        machine2.giveCoin(this, 2);
        machine3.giveCoin(this, 2);
    }

    // public int chooseAction() {

    // }

    public void play() {

    }

}
