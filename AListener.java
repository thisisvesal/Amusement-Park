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
                Utils.board.player2.takeCoin(slotMachine);;
                for (int i = 0; i < 6; i++) {
                    if (Utils.board.allCoins2[i].color == slotMachine.color) {
                        Utils.board.allCoins2[i].setText("" + Utils.board.player2.getCoinCount(slotMachine.color));
                    }
                }
                System.out.println(Utils.board.player2.getCoinCount(slotMachine.color));
            }
        } else if (e.getSource() instanceof Card) {
            System.out.println("card");
            if (Utils.board.player1.isOn) {
                if ((Card)e.getSource() != Utils.getPressedCard()) {
                    Utils.board.buyButton1.setVisible(true);
                    Utils.board.reserveButton1.setVisible(true);
                    Utils.setPressedCard((Card)e.getSource());
                    System.out.println("Listener reporting, I've set pressed card to " + Utils.getPressedCard());
                } else {
                    Utils.board.buyButton1.setVisible(false);
                    Utils.board.reserveButton1.setVisible(false);
                    Utils.setPressedCard(null);
                }

            } else if (Utils.board.player2.isOn) {
                if ((Card)e.getSource() != Utils.getPressedCard()) {
                    Utils.board.buyButton2.setVisible(true);
                    Utils.board.reserveButton2.setVisible(true);
                    Utils.setPressedCard((Card)e.getSource());
                } else {
                    Utils.board.buyButton2.setVisible(false);
                    Utils.board.reserveButton2.setVisible(false);
                    Utils.setPressedCard(null);
                }
            }
            // !!!!!!! IMPORTANT STUFF BELOW !!!!!!!
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.buyButton1) {
            System.out.println("buy button 1");
            Utils.board.buyButton1.setVisible(false);
            Utils.board.reserveButton1.setVisible(false);
            Utils.board.player1.buyCard(Utils.getPressedCard());
            Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.reserveButton1) {
            System.out.println("reserve button 1");
            Utils.board.buyButton1.setVisible(false);
            Utils.board.reserveButton1.setVisible(false);
            Utils.board.player1.reserve(Utils.getPressedCard());
            Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.buyButton2) {
            System.out.println("buy button 2");
            Utils.board.buyButton2.setVisible(false);
            Utils.board.reserveButton2.setVisible(false);
            Utils.board.player2.buyCard(Utils.getPressedCard());
            Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.reserveButton2) {
            System.out.println("reserve button 2");
            Utils.board.reserveButton2.setVisible(false);
            Utils.board.buyButton2.setVisible(false);
            Utils.setPressedCard(null);
            Utils.board.revalidate();
            Utils.board.repaint();
        } else if (e.getSource() == Utils.board.passButton) {
            System.out.println("Pass button");
            Utils.switchRound();
        }

        if (Player.getPlayerOfTheRound().isRoundFinished()) {
            Utils.switchRound();
        }

        Utils.refreshBoard();
    }
}
