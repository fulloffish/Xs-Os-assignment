package controller;

import exception.NotValidMoveException;
import game.*;
import io.InputAsker;
import io.UserInput;
import io.UserOutput;

import java.util.InputMismatchException;

public class GameController {
    private Game game;
    private UserOutput output;
    private UserInput input;

    public void setUpGame() {
        this.output  = new UserOutput();
        this.input  = new UserInput();
        this.game = new Game();
        this.game.initGame();
    }

    public void play() {

        this.output.printWhoStarts(game.getCurrentPlayer());
        while (game.getCurrentState().equals(GameState.PLAYING)) {
            this.handleBoardPrinting();
            try {
                this.gameAction();
                this.game.switchPlayer();

            } catch (InputMismatchException enteredLetter) {
                this.output.printErrorMessage("This is not a number, try again.");
            } catch (NotValidMoveException invalidMove) {
                this.output.printErrorMessage(invalidMove.getMessage());
            }
        this.checkForWinner();
        }
    }

    private void handleBoardPrinting() {
        this.output.showBoard(game.getBoard());
        this.output.printCurrentPlayer(game.getCurrentPlayer(), game.getBoard().ROWS, game.getBoard().COLS);
    }

    private void gameAction() {
        Integer row;
        Integer col;
        row = this.input.getCoordinate(new InputAsker(System.in, System.out), game.getBoard().ROWS);
        col = this.input.getCoordinate(new InputAsker(System.in, System.out), game.getBoard().COLS);
        if (this.game.getCurrentPlayer() == Player.X) {
            this.game.updateBoard(Seed.CROSS, row-1, col-1);
        } else {
            this.game.updateBoard(Seed.NOUGHT, row-1, col-1);
        }
    }

    private void checkForWinner() {
        if (!this.game.getBoard().hasWon()) {
            if (this.game.getBoard().isDraw()) {
                this.handleDraw();
            }
        } else {
            this.handleWinning();
        }
    }

    private void handleDraw() {
        this.output.printThereIsADraw();
        this.game.updateGameState(GameState.DRAW);
    }

    private void handleWinning() {
        this.game.switchPlayer();
        this.output.printWhoWon(game.getCurrentPlayer());
        this.setUpdateGameStateAfterWinning();
    }


    private void setUpdateGameStateAfterWinning() {
        if (this.game.getCurrentPlayer() == Player.X) {
            this.game.updateGameState(GameState.CROSS_WON);
        } else {
            this.game.updateGameState(GameState.NOUGHT_WON);
        }
    }

    public boolean wantToPlayAgain() {
        Character response = this.input.getInputYesOrNo(new InputAsker(System.in, System.out));
        if(response.toString().toUpperCase().equals("Y")) {
            this.startNewGame();
            return true;
        }
        return false;
    }

    private void startNewGame() {
        this.game.updateGameState(GameState.PLAYING);
        this.game.getBoard().clearAllCells();
    }

}
