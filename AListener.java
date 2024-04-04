import java.awt.event.ActionListener;
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
            if ((Card) ((CardButton)e.getSource()).card != Utils.getPressedCard()) {
                Utils.setPressedCard((Card) ((CardButton)e.getSource()).card);
                Utils.getPressedCard().buyButton.setVisible(true);
                Utils.getPressedCard().reserveButton.setVisible(true);
                System.out.println("Listener reporting, I've set pressed card to " + Utils.getPressedCard());
            } else {
                Utils.getPressedCard().buyButton.setVisible(false);
                Utils.getPressedCard().reserveButton.setVisible(false);
                Utils.setPressedCard(null);
            }
            // !!!!!!! IMPORTANT STUFF BELOW !!!!!!!
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (Utils.getPressedCard() != null && e.getSource() == Utils.getPressedCard().buyButton) {
            System.out.println("buy button");
            Utils.getPressedCard().buyButton.setVisible(false);
            Utils.getPressedCard().reserveButton.setVisible(false);
            Utils.getPlayerOfTheRound().buyCard(Utils.getPressedCard());
            Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (Utils.getPressedCard() != null && e.getSource() == Utils.getPressedCard().reserveButton) {
            System.out.println("reserve button ");
            Utils.getPressedCard().reserveButton.setVisible(false);
            Utils.getPressedCard().buyButton.setVisible(false);
            Utils.getPlayerOfTheRound().reserve(Utils.getPressedCard());
            Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.passButton) {
            System.out.println("\nPass button\n");
            Utils.switchRound();
        }

        if (Utils.getPlayerOfTheRound().isRoundFinished()) {
            Utils.switchRound();
        }

        Utils.refreshBoard();
    }
}
