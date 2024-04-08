import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.event.ActionEvent;

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
            System.out.println("card");
            if (((Card) ((CardButton) e.getSource()).card).buyButton.isVisible()
                    || ((Card) ((CardButton) e.getSource()).card).reserveButton.isVisible()) {
                ((Card) ((CardButton) e.getSource()).card).buyButton.setVisible(false);
                ((Card) ((CardButton) e.getSource()).card).reserveButton.setVisible(false);
                // Utils.setPressedCard(null);
                
            } else {
                // Utils.setPressedCard((Card) ((CardButton) e.getSource()).card);
                ((Card) ((CardButton) e.getSource()).card).buyButton.setVisible(true);
                ((Card) ((CardButton) e.getSource()).card).reserveButton.setVisible(true);
                // System.out.println("Listener reporting, I've set pressed card to " + Utils.getPressedCard());
            }
            // !!!!!!! IMPORTANT STUFF BELOW !!!!!!!
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (((JButton)e.getSource()).getText() == "buy") {
            Card sourceCard = (Card) ((((JButton)e.getSource()).getParent()).getParent());
            System.out.println("buy button");
            sourceCard.buyButton.setVisible(false);
            sourceCard.reserveButton.setVisible(false);
            Utils.getPlayerOfTheRound().buyCard(sourceCard);
            // Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (((JButton)e.getSource()).getText() == "reserve") {
            Card sourceCard = (Card) ((((JButton)e.getSource()).getParent()).getParent());
            System.out.println("reserve button ");
            sourceCard.reserveButton.setVisible(false);
            sourceCard.buyButton.setVisible(false);
            Utils.getPlayerOfTheRound().reserve(sourceCard);
            // Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.passButton) {
            System.out.println("\nPass button\n");
            Utils.switchRound();
        }

        if (Utils.getPlayerOfTheRound().getScore() == 15) {
            Utils.popUp(Utils.getPlayerOfTheRound() + " winssssss", "");
        }

        if (Utils.getPlayerOfTheRound().isRoundFinished()) {
            Utils.switchRound();
        }

        Utils.refreshBoard();
    }
}
