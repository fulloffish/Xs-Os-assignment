package game;

public class Board {
    private Cell[][] cells;
    public final Integer ROWS = 3;
    public final Integer COLS = 3;

    public Board() {
        this.cells = new Cell[ROWS][COLS];
    }

    public void init() {
        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < this.COLS; columnIndex++) {
                this.cells[rowIndex][columnIndex] = new Cell();
            }
        }
    }

    public boolean isDraw() {
        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < this.COLS; columnIndex++) {
                if (this.getCell(rowIndex, columnIndex).getContent() == Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(){
        // CHECK ROW 1
        if (this.cells[0][0].getContent().equals(this.cells[0][1].getContent())
                && this.cells[0][1].getContent().equals(this.cells[0][2].getContent())
                && this.cells[0][0].getContent() != Seed.EMPTY) {
            return true;
        }
        // CHECK ROW 2
        if (this.cells[1][0].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[1][2].getContent())
            && this.cells[1][0].getContent() != Seed.EMPTY) {
            return true;
        }
        // CHECK ROW 3
        if (this.cells[2][0].getContent().equals(this.cells[2][1].getContent())
            && this.cells[2][1].getContent().equals(this.cells[2][2].getContent())
            && this.cells[2][0].getContent() != Seed.EMPTY) {
            return true;
        }
        // CHECK COLUMN 1
        if (this.cells[0][0].getContent().equals(this.cells[1][0].getContent())
            && this.cells[1][0].getContent().equals(this.cells[2][0].getContent())
            && this.cells[0][0].getContent() != Seed.EMPTY) {
            return true;
        }
        // CHECK COLUMN 2
        if (this.cells[0][1].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[2][1].getContent())
            && this.cells[0][1].getContent() != Seed.EMPTY) {
            return true;
        }
        // CHECK COLUMN 3
        if (this.cells[0][2].getContent().equals(this.cells[1][2].getContent())
            && this.cells[1][2].getContent().equals(this.cells[2][2].getContent())
            && this.cells[0][2].getContent() != Seed.EMPTY) {
            return true;
        }
        // CHECK CANT LEFT
        if (this.cells[0][0].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[2][2].getContent())
            && this.cells[0][0].getContent() != Seed.EMPTY) {
            return true;
        }
        // CHECK CANT RIGHT
        if (this.cells[0][2].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[2][0].getContent())
            && this.cells[0][2].getContent() != Seed.EMPTY) {
            return true;
        }
        return false;
    }

    public Cell getCell(Integer row, Integer col) {
        return this.cells[row][col];
    }

    public void clearAllCells() {
        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < this.COLS; columnIndex++) {
                this.cells[rowIndex][columnIndex].clear();
            }
        }

    }

}
