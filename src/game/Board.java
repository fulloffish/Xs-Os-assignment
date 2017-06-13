package game;

public class Board {

    private Cell cells[][];


    public Board() {
    }

    public void init() {
    }

    public boolean isDraw() {
        return true;
    }

    public boolean hasWon(Seed seed, int row, int col){
        return false;
    }

    public Object getCell(Integer row, Integer col) {
        return cells[row][col];
    }

}
