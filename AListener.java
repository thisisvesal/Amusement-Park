import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Slot_Machine) {
            Slot_Machine slotMachine = (Slot_Machine) e.getSource();
            System.out.println("slotmachine");
            if (Utils.board.player1.isOn) {
                Utils.board.player1.takeCoin(slotMachine);
                for (int i = 0; i < 6; i++) {
                    if (Utils.board.allCoins1[i].color == slotMachine.color) {
                        Utils.board.allCoins1[i].setText("" + Utils.board.player1.getCoinCount(slotMachine.color));
                    }
                }
                System.out.println(Utils.board.player1.getCoinCount(slotMachine.color));
            } else if (Utils.board.player2.isOn) {
                Utils.board.player2.takeCoin(slotMachine);
                ;
                for (int i = 0; i < 6; i++) {
                    if (Utils.board.allCoins2[i].color == slotMachine.color) {
                        Utils.board.allCoins2[i].setText("" + Utils.board.player2.getCoinCount(slotMachine.color));
                    }
                }
                System.out.println(Utils.board.player2.getCoinCount(slotMachine.color));
            }
        } else if (e.getSource() instanceof CardButton) {
            MusicPlayer.play("music/mixkit-cool-interface-click-tone-2568.wav");
            System.out.println("card");
            if (((Card) ((CardButton) e.getSource()).card).buyButton.isVisible()
                    || ((Card) ((CardButton) e.getSource()).card).reserveButton.isVisible()) {
                ((Card) ((CardButton) e.getSource()).card).buyButton.setVisible(false);
                ((Card) ((CardButton) e.getSource()).card).reserveButton.setVisible(false);

            } else {
                ((Card) ((CardButton) e.getSource()).card).buyButton.setVisible(true);
                ((Card) ((CardButton) e.getSource()).card).reserveButton.setVisible(true);
            }
            // !!!!!!! IMPORTANT STUFF BELOW !!!!!!!
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (((JButton) e.getSource()).getText() == "buy") {
            Card sourceCard = (Card) ((((JButton) e.getSource()).getParent()).getParent());
            System.out.println("buy button");
            sourceCard.buyButton.setVisible(false);
            sourceCard.reserveButton.setVisible(false);
            Utils.getPlayerOfTheRound().buyCard(sourceCard);

            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (((JButton) e.getSource()).getText() == "reserve") {
            Card sourceCard = (Card) ((((JButton) e.getSource()).getParent()).getParent());
            System.out.println("reserve button ");
            sourceCard.reserveButton.setVisible(false);
            sourceCard.buyButton.setVisible(false);
            Utils.getPlayerOfTheRound().reserve(sourceCard);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.passButton) {
            MusicPlayer.play("music/mixkit-light-switch-sound-2579.wav");
            System.out.println("\nPass button\n");
            Utils.switchRound();
            Utils.board.setCursor(Utils.getPlayerOfTheRound().cursor);
        } else if (e.getSource() instanceof Coin) {
            System.out.println(((Coin) e.getSource()).color + " coin");
            if (((Coin) e.getSource()).getOwner() == Utils.getPlayerOfTheRound()) {
                MusicPlayer.play("music/mixkit-arcade-game-jump-coin-216.wav");
                int reply = JOptionPane.showConfirmDialog(Utils.board,
                        "Do you want to return a " + ((Coin) e.getSource()).color + " coin?", "Coin return",
                        JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION
                        && Utils.getPlayerOfTheRound().getCoinCount(((Coin) e.getSource()).color) > 0) {
                    Utils.getPlayerOfTheRound().returnCoin(((Coin) e.getSource()).color);
                } else if (Utils.getPlayerOfTheRound().getCoinCount(((Coin) e.getSource()).color) == 0) {
                    System.out.println("not enough coins to return");
                    Utils.popUp("Whoops!", "You don't have any " + ((Coin) e.getSource()).color + " coins to return!");
                }
            }

        } else if (e.getSource() == Utils.board.multiPlayerButton) {
            MusicPlayer.play("music/mixkit-cool-interface-click-tone-2568.wav");
            Utils.board.initializeGameBoard();
        } else if (e.getSource() == Utils.board.soloButton) {
            MusicPlayer.play("music/mixkit-cool-interface-click-tone-2568.wav");
            Utils.popUp(":)", "Coming soon!");
        }

        if (Utils.getPlayerOfTheRound().getScore() >= 15) {
            if (Utils.getPlayerOfTheRound() == Utils.board.player1) {
                Utils.addFinalRoundMoveCount();
            } else if (Utils.getPlayerOfTheRound() == Utils.board.player2) {
                Utils.addFinalRoundMoveCount();
                Utils.addFinalRoundMoveCount();
            }
        }

        if (Utils.getFinalRoundMoveCount() >= 2) {
            MusicPlayer.play("music/mixkit-cartoon-positive-sound-2255.wav");
            if (Utils.board.player1.getScore() > Utils.board.player2.getScore()) {
                Utils.popUp("WINNER", "The " + Utils.board.player1.color + " player winssssss!");
            } else if (Utils.board.player1.getScore() < Utils.board.player2.getScore()) {
                Utils.popUp("WINNER", "The " + Utils.board.player1.color + " player winssssss!");
            } else {
                Utils.popUp("TIE", "That's a tie!");
            }
        }

        if (Utils.getPlayerOfTheRound().isRoundFinished()) {
            MusicPlayer.play("music/mixkit-light-switch-sound-2579.wav");
            Utils.switchRound();
            Utils.board.setCursor(Utils.getPlayerOfTheRound().cursor);
        }

        Utils.refreshBoard();
    }
}
