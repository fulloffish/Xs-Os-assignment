package game;

public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[3][3];
    }

    public void init() {
        for(int rowIndex =0; rowIndex <this.cells.length; rowIndex++){
            for(int columnIndex =0; columnIndex< this.cells[rowIndex].length; columnIndex++) {
                this.cells[rowIndex][columnIndex] = new Cell(rowIndex, columnIndex);
            }
        }
    }

    public boolean isDraw() {
        return true;
    }

    public boolean hasWon(Seed seed, int row, int col){
        return false;
    }


}
