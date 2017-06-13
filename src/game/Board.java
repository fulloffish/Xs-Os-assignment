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

    public boolean hasWon(){
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

}
