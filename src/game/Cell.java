package game;

public class Cell {
    private Seed content;
    private Integer row;
    private Integer col;

    public Cell(){
      this.setContent(Seed.EMPTY);
    }

    public Cell(Integer row, Integer col, Seed seed) {
        this.row = row;
        this.col = col;
        this.content = seed;
    }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) {
        this.content = content;
    }

    public Integer getRow() {
        return this.row;
    }

    public Integer getCol() {
        return this.col;
    }


    public void clear() {
        this.setContent(Seed.EMPTY);
    }

}
