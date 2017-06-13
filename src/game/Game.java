package game;

public class Game {
    private Board board;
    private GameState currentState;
    private Seed currentPlayer;

    public Game(){

    }

    public void initGame(){
        board = new Board();
        currentState = GameState.PLAYING;

    }

    public void updateGameState(Seed seed, int row, int col){

    }
}
