public class Main {
    public static void main(String[] args) throws Exception {
        Board board = Utils.board;
        Utils.arrangeCards();
        Utils.refreshBoard();

        System.out.println(board.getTitle());
    }
}
