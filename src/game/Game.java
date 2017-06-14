package game;

import exception.NotValidMove;

import java.util.Random;

public class Game {
    private Board board;
    private GameState currentState;
    private Player currentPlayer;

    public Game(){
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void switchPlayer() {
        if (currentPlayer == Player.X) {
            currentPlayer = Player.O;
        } else {
            currentPlayer = Player.X;
        }
    }

    public Player getCurrentPlayer() {
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

    private Player getFirstPlayer() {
        if(new Random().nextInt(2) == 0) {
            return Player.X;
        }
        return Player.O;
    }
}
