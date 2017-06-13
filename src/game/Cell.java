package game;

public class Cell {
    private int row;
    private int col;
    private Seed content;


    public Cell(Integer row, Integer col){
      this.setRow(row);
      this.setCol(col);
    }

    public Seed getSeed() {
        return content;
    }

    public void setSeed(Seed seed) {
        this.content = seed;
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
        this.content = Seed.EMPTY;
    }

}
