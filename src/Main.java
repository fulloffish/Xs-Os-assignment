import game.Board;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.init();
        board.hasWon();
        System.out.println(board.getCell(1,1).getContent());
    }
}