package game;

public class Cell {
    private Seed content;

    public Cell(){
      this.setContent(Seed.EMPTY);
    }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) {
        this.content = content;
    }

    public void clear() {
        this.setContent(Seed.EMPTY);
    }

}
