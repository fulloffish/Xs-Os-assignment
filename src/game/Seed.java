package game;

public enum Seed {
    EMPTY (" "),
    CROSS ("X"),
    NOUGHT ("O");

    private final String symbol;

    Seed(String symbol){
        this.symbol = symbol;
    }

    private String symbol(){
        return symbol;
    }
}
