import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Utils {
    public static final AListener listener = new AListener();
    public static final MListener mouseListener = new MListener();
    public static final Board board = new Board();
    private static Card pressedCard;
    public static final Random randomizer = new Random();

    public static int getRandomCardIndex(int level) {
        if (level == 0) {
            return (int)(Math.random() * board.prizeclawCards.size()); 
        } else if (level == 1) {
            return (int)(Math.random() * board.lvl1Cards.size()); 
        } else if (level == 2) {
            return (int)(Math.random() * board.lvl2Cards.size()); 
        } else if (level == 3) {
            return (int)(Math.random() * board.lvl3Cards.size()); 
        }
        return 0;
    }

    public static void arrangeCards() {
        int randIndex;
        for (int i = 0; i < 3; i++) {
            randIndex = getRandomCardIndex(0);
            board.prizeclawPanel.add(board.prizeclawCards.get(randIndex));
            System.out.println("prizeclaw " + ((Card)board.prizeclawCards.get(randIndex)).getOwner());
            board.prizeclawCards.remove(randIndex);

            randIndex = getRandomCardIndex(1);
            board.lvl1Panel.add(board.lvl1Cards.get(randIndex));
            System.out.println("lvl1 " +((Card)board.lvl1Cards.get(randIndex)).getOwner().getName());
            board.lvl1Cards.remove(randIndex);


            randIndex = getRandomCardIndex(2);
            board.lvl2Panel.add(board.lvl2Cards.get(randIndex));
            System.out.println("lvl2 " + ((Card)board.lvl2Cards.get(randIndex)).getOwner().getName());
            board.lvl2Cards.remove(randIndex);

            
            randIndex = getRandomCardIndex(3);
            board.lvl3Panel.add(board.lvl3Cards.get(randIndex));
            System.out.println("lvl3 " + ((Card)board.lvl3Cards.get(randIndex)).getOwner().getName());
            board.lvl3Cards.remove(randIndex);
        }

        System.out.println("prizeclaw length after arrange: " + board.prizeclawCards.size());
        System.out.println("lvl1 length after arrange: " + board.lvl1Cards.size());
        System.out.println("lvl2 length after arrange: " + board.lvl2Cards.size());
        System.out.println("lvl3 length after arrange: " + board.lvl3Cards.size());
    }

    public static void replace(Card card) {
        int randIndex;
        if (card.level == 0 && board.prizeclawCards.size() > 0) {
            randIndex = getRandomCardIndex(0);
            board.prizeclawPanel.add(board.prizeclawCards.get(randIndex));
            board.prizeclawCards.remove(board.prizeclawCards.get(randIndex));
        } else if (card.level == 1 && board.lvl1Cards.size() > 0) {
            randIndex = getRandomCardIndex(1);
            board.lvl1Panel.add(board.lvl1Cards.get(randIndex));
            board.lvl1Cards.remove(board.lvl1Cards.get(randIndex));
        } else if (card.level == 2 && board.lvl2Cards.size() > 0) {
            randIndex = getRandomCardIndex(2);
            board.lvl2Panel.add(board.lvl2Cards.get(randIndex));
            board.lvl2Cards.remove(board.lvl2Cards.get(randIndex));
        } else if (card.level == 3 && board.lvl3Cards.size() > 0) {
            randIndex = getRandomCardIndex(3);
            board.lvl3Panel.add(board.lvl3Cards.get(randIndex));
            board.lvl3Cards.remove(board.lvl3Cards.get(randIndex));
        }
    }

    // public static void setPressedCard(Card card) {
    //     Utils.pressedCard = card;
    // }

    // public static Card getPressedCard() {
    //     if (pressedCard != null) {
    //         System.out.println("getPressed reports " + pressedCard.superCoin.color + " card as pressed");
    //     } else {
    //         System.out.println("getPressed reports null card as pressed");
    //     }
    //     return pressedCard;
    // }

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
        System.out.println("\npop up: " + message + "\n");
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

        board.superGreenCoin1.setText("" + board.player1.getSuperCoinCount("green"));
        board.superRedCoin1.setText("" + board.player1.getSuperCoinCount("red"));
        board.superBlueCoin1.setText("" + board.player1.getSuperCoinCount("blue"));
        board.superBlackCoin1.setText("" + board.player1.getSuperCoinCount("black"));
        board.superWhiteCoin1.setText("" + board.player1.getSuperCoinCount("white"));

        board.superGreenCoin2.setText("" + board.player2.getSuperCoinCount("green"));
        board.superRedCoin2.setText("" + board.player2.getSuperCoinCount("red"));
        board.superBlueCoin2.setText("" + board.player2.getSuperCoinCount("blue"));
        board.superBlackCoin2.setText("" + board.player2.getSuperCoinCount("black"));
        board.superWhiteCoin2.setText("" + board.player2.getSuperCoinCount("white"));

        board.redMachine.setText("" + board.redMachine.getCoinCount());
        board.greenMachine.setText("" + board.greenMachine.getCoinCount());
        board.blueMachine.setText("" + board.blueMachine.getCoinCount());
        board.blackMachine.setText("" + board.blackMachine.getCoinCount());
        board.whiteMachine.setText("" + board.whiteMachine.getCoinCount());

        board.score1.setText(" " + board.player1.getScore());
        board.score2.setText(" " + board.player2.getScore());

    }

    public static Player getPlayerOfTheRound() {
        if (board.player1.isOn) {
            return board.player1;
        } else if (board.player2.isOn) {
            return board.player2;
        }
        return null;
    }

    public static ImageIcon getResizedIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
