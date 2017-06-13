package game;

public class Game {
    private Board board;
    private GameState currentState;
    private Seed currentPlayer;

    public Game(){

    }

    public void initGame(){
        this.board = new Board();
        this.currentState = GameState.PLAYING;

    }

    public void updateBoard(Seed seed, int row, int col){
        this.board.getCell(row, col).setContent(seed);
    }

    public void updateGameState(GameState currentState) {
        this.currentState = currentState;

    }
}
