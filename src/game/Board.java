package game;

public class Board {
    private Cell[][] cells;

    public Board() {
        this.cells = new Cell[3][3];
    }

    public void init() {
        for(int rowIndex = 0; rowIndex < this.cells.length; rowIndex++){
            for(int columnIndex = 0; columnIndex< this.cells[rowIndex].length; columnIndex++) {
                this.cells[rowIndex][columnIndex] = new Cell();
            }
        }
    }

    public boolean isDraw() {
        return true;
    }

    public boolean hasWon(){
//        this.cells[0][0].setContent(Seed.NOUGHT);
//        this.cells[0][1].setContent(Seed.CROSS);
//        this.cells[0][2].setContent(Seed.EMPTY);
//        this.cells[1][0].setContent(Seed.EMPTY);
//        this.cells[1][1].setContent(Seed.EMPTY);
//        this.cells[1][2].setContent(Seed.EMPTY);
//        this.cells[2][0].setContent(Seed.CROSS);
//        this.cells[2][1].setContent(Seed.CROSS);
//        this.cells[2][2].setContent(Seed.CROSS);


        // CHECK ROW 1
        if (this.cells[0][0].getContent().equals(this.cells[0][1].getContent())
                && this.cells[0][1].getContent().equals(this.cells[0][2].getContent())
                && this.cells[0][0].getContent() != Seed.EMPTY) {
            System.out.println("ROW1");
            return true;
        }
        // CHECK ROW 2
        if (this.cells[1][0].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[1][2].getContent())
            && this.cells[1][0].getContent() != Seed.EMPTY) {
            System.out.println("ROW2");
            return true;
        }
        // CHECK ROW 3
        if (this.cells[2][0].getContent().equals(this.cells[2][1].getContent())
            && this.cells[2][1].getContent().equals(this.cells[2][2].getContent())
            && this.cells[2][0].getContent() != Seed.EMPTY) {
            System.out.println("ROW3");
            return true;
        }
        // CHECK COLUMN 1
        if (this.cells[0][0].getContent().equals(this.cells[1][0].getContent())
            && this.cells[1][0].getContent().equals(this.cells[2][0].getContent())
            && this.cells[0][0].getContent() != Seed.EMPTY) {
            System.out.println("COL1");
            return true;
        }
        // CHECK COLUMN 2
        if (this.cells[0][1].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[2][1].getContent())
            && this.cells[0][1].getContent() != Seed.EMPTY) {
            System.out.println("COL2");
            return true;
        }
        // CHECK COLUMN 3
        if (this.cells[0][2].getContent().equals(this.cells[1][2].getContent())
            && this.cells[1][2].getContent().equals(this.cells[2][2].getContent())
            && this.cells[0][2].getContent() != Seed.EMPTY) {
            System.out.println("COL3");
            return true;
        }
        // CHECK CANT LEFT
        if (this.cells[0][0].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[2][2].getContent())
            && this.cells[0][0].getContent() != Seed.EMPTY) {
            System.out.println("CANT_LEFT");
            return true;
        }
        // CHECK CANT RIGHT
        if (this.cells[0][2].getContent().equals(this.cells[1][1].getContent())
            && this.cells[1][1].getContent().equals(this.cells[2][0].getContent())
            && this.cells[0][2].getContent() != Seed.EMPTY) {
            System.out.println("CANT_RIGHT");
            return true;
        }
        return false;
    }

    public Cell getCell(Integer row, Integer col) {
        return this.cells[row][col];
    }

}
