public class Main {
    public static void main(String[] args) throws Exception {
        Board board = Utils.board;
        board.initializeMenu();

        System.out.println(board.getTitle());
    }
}
