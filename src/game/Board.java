package game;

public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[3][3];
    }

    public void init() {
        for(int rowIndex = 0; rowIndex < this.cells.length; rowIndex++){
            for(int columnIndex = 0; columnIndex< this.cells[rowIndex].length; columnIndex++) {
                this.cells[rowIndex][columnIndex] = new Cell(rowIndex, columnIndex);
            }
        }
    }

    public boolean isDraw() {
        return true;
    }

    public boolean hasWon(){

        if (cells[0][0].getContent().equals(cells[0][1].getContent())
                && cells[0][1].getContent().equals(cells[0][2].getContent())) {
            System.out.println("ROW1");
            return true;
        }
        if (cells[1][0].getContent().equals(cells[1][1].getContent())
            && cells[1][1].getContent().equals(cells[1][2].getContent())) {
            System.out.println("ROW2");
            return true;
        }
        if (cells[2][0].getContent().equals(cells[2][1].getContent())
            && cells[2][1].getContent().equals(cells[2][2].getContent())) {
            System.out.println("ROW3");
            return true;
        }
        if (cells[0][0].getContent().equals(cells[1][0].getContent())
            && cells[1][0].getContent().equals(cells[2][0].getContent())) {
            System.out.println("COL1");
            return true;
        }
        if (cells[0][1].getContent().equals(cells[1][1].getContent())
            && cells[1][1].getContent().equals(cells[2][1].getContent())) {
            System.out.println("COL2");
            return true;
        }
        if (cells[0][2].getContent().equals(cells[1][2].getContent())
            && cells[1][2].getContent().equals(cells[2][2].getContent())) {
            System.out.println("COL3");
        }
        return false;
    }

    public Cell getCell(Integer row, Integer col) {
        return cells[row][col];
    }

}
