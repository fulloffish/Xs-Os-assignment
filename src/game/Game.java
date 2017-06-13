package game;

import exception.NotValidMove;

import java.util.Random;

public class Game {
    private Board board;
    private GameState currentState;
    private Seed currentPlayer;

    public Game(){
    }

    public void setCurrentPlayer(Seed currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public Board getBoard() {
        return board;
    }
    //    public void changeCurrentPlayer

    public void initGame(){
        this.board = new Board();
        this.currentState = GameState.PLAYING;
        this.board.init();
        this.currentPlayer = this.getFirstPlayer();
    }

    public void updateBoard(Seed seed, int row, int col) {
        if (this.board.getCell(row, col).getContent().equals(Seed.EMPTY)) {
            this.board.getCell(row, col).setContent(seed);
        }
        else {
            throw new NotValidMove();
        }
    }

    public void updateGameState(GameState currentState) {
        this.currentState = currentState;
    }

    private Seed getFirstPlayer() {
        Random generator = new Random();
        int i = generator.nextInt(1);

        if(i == 0) {
            return Seed.CROSS;
        }
        return Seed.NOUGHT;
    }
}
