package game;

public class Board {
    private Cell[][] cells;
    public final Integer ROWS = 3;
    public final Integer COLS = 3;

    public Board() {
        cells = new Cell[ROWS][COLS];
    }

    public void init() {
        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < this.COLS; columnIndex++) {
                this.cells[rowIndex][columnIndex] = new Cell(rowIndex, columnIndex);
            }
        }
    }

    public boolean hasWon() {
        cells[0][0].setContent(Seed.CROSS);
        cells[0][1].setContent(Seed.CROSS);
        cells[0][2].setContent(Seed.CROSS);
        if (cells[0][0].getContent().equals(cells[0][1].getContent())
                && cells[0][1].getContent().equals(cells[0][2].getContent())) {
            System.out.println("true");
            return true;
        }
        return false;
    }

    public Cell getCell(Integer row, Integer col) {
        return cells[row][col];
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

}
