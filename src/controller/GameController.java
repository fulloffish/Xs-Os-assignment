package controller;

import exception.NotValidMove;
import game.*;
import io.InputAsker;
import io.UserInput;
import io.UserOutput;

import java.util.InputMismatchException;

public class GameController {
    private Game game;
    private UserOutput output = new UserOutput();
    private UserInput input = new UserInput();

    public void startGame() {
        game = new Game();
        game.initGame();
    }

    public void play() {
        Integer row;
        Integer col;
        output.printWhoStarts(game.getCurrentPlayer());
        while (game.getCurrentState().equals(GameState.PLAYING)) {
            output.showBoard(game.getBoard());
            output.printCurrentPlayer(game.getCurrentPlayer(), game.getBoard().ROWS, game.getBoard().COLS);
            try {
                row = input.getCoordinate(new InputAsker(System.in, System.out), game.getBoard().ROWS);
                col = input.getCoordinate(new InputAsker(System.in, System.out), game.getBoard().COLS);
                if (game.getCurrentPlayer() == Player.X) {
                    game.updateBoard(Seed.CROSS, row-1, col-1);
                } else {
                    game.updateBoard(Seed.NOUGHT, row-1, col-1);
                }
                game.switchPlayer();

            } catch (InputMismatchException e) {
                System.out.println("This is not a number, try again.");
            } catch (NotValidMove ex) {
                ex.getMessage();
            }

        this.checkForWinner();
        }
    }

    private void setUpdateGameState() {
        if (game.getCurrentPlayer() == Player.X) {
            game.updateGameState(GameState.CROSS_WON);
        } else {
            game.updateGameState(GameState.NOUGHT_WON);
        }
    }

    public boolean wantToPlayAgain() {

        Character response = input.getInputYesOrNo(new InputAsker(System.in, System.out));
        if(response.toString().equals("Y")) {
            startNewGame();
            return true;
        }
        return false;
    }

    private void startNewGame() {
        game.updateGameState(GameState.PLAYING);
        game.getBoard().clearAllCells();
    }

    private void checkForWinner() {
        if (!game.getBoard().hasWon()) {
            if (game.getBoard().isDraw()) {
                output.printThereIsADraw();
                game.updateGameState(GameState.DRAW);
            }
        } else {
            game.switchPlayer();
            output.printWhoWon(game.getCurrentPlayer());
            this.setUpdateGameState();
        }

    }

}
