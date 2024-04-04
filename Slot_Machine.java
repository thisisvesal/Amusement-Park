import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Slot_Machine extends JButton {
    public final String color;
    private int coinCount = 4;
    private static int pressedMachineCount;
    private static Slot_Machine[] pressedMachines = new Slot_Machine[3];

    public Slot_Machine(String color) {
        this.color = color;
        this.setIcon(new ImageIcon("icons/slot_machine/s" + color + ".png")); // https://icons8.com/icon/16446/slot-machine
        this.setBackground(new Color(48, 181, 199));
        this.setFocusable(false);
        this.addActionListener(Utils.listener);
        this.setText("" + coinCount);
        this.setFont(new Font("Tahoma", Font.BOLD, 15));
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void removeOneCoin() {
        Utils.board.banker.takeCoin(this);
        coinCount--;
        if (this.coinCount == 0) {
            this.setEnabled(false);
        }
    }

    public boolean canDoType1() {
        if (coinCount == 4) {
            return true;
        }
        return false;
    }

    public static boolean isDoneForTheRound() {
        if (pressedMachineCount == 3) {
            return true;
        } else if (pressedMachineCount == 2 && pressedMachines[0] == pressedMachines[1]) {
            return true;
        }
        return false;
    }

    public void press() {
        pressedMachines[pressedMachineCount] = this;
        pressedMachineCount++;
    }

    public static void reset() {
        pressedMachineCount = 0;
        for (int i = 0; i < 3; i++) {
            pressedMachines[i] = null;
        }

        if (Utils.board.redMachine.getCoinCount() != 0) {
            Utils.board.redMachine.setEnabled(true);
        }
        if (Utils.board.greenMachine.getCoinCount() != 0) {
            Utils.board.greenMachine.setEnabled(true);
        }
        if (Utils.board.blueMachine.getCoinCount() != 0) {
            Utils.board.blueMachine.setEnabled(true);
        }
        if (Utils.board.whiteMachine.getCoinCount() != 0) {
            Utils.board.whiteMachine.setEnabled(true);
        }
        if (Utils.board.blackMachine.getCoinCount() != 0) {
            Utils.board.blackMachine.setEnabled(true);
        }

    }
}
