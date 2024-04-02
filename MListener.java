import java.awt.event.*;

public class MListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        if (Utils.board.contains(x, y)) {
            if (Utils.board.player1.isOn) {
                Utils.board.setCursor(Utils.board.player1.cursor);
            } else if (Utils.board.player2.isOn) {
                Utils.board.setCursor(Utils.board.player2.cursor);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        if (Utils.board.contains(x, y)) {
            if (Utils.board.player1.isOn) {
                Utils.board.setCursor(Utils.board.player1.cursor);
            } else if (Utils.board.player2.isOn) {
                Utils.board.setCursor(Utils.board.player2.cursor);
            }
        }
    }

}