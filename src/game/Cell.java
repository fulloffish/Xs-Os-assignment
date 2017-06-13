package game;

public class Cell {
    private int row;
    private int col;
    Seed seed;


    public Cell(int row, int col){
      this.setRow(row);
      this.setCol(col);
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void clear() {
    }
}
