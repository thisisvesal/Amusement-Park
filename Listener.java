import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Slot_Machine) {
            System.out.println("slotmachine");

        } else if (e.getSource() instanceof Card) {
            System.out.println("card");
            Utils.board.buyButton1.setVisible(true);
            // !!!!!!! IMPORTANT STUFF BELOW !!!!!!!
            Utils.board.revalidate();
            Utils.board.repaint();
        }
        else if (e.getSource() == Utils.board.buyButton1) {
            System.out.println("buy button 1");
            Utils.board.buyButton1.setVisible(false);
            Utils.board.revalidate();
            Utils.board.repaint();
        }

    }
}
