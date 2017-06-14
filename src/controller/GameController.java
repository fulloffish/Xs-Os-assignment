package controller;

import exception.NotValidMove;
import game.*;
import io.UserInput;
import io.UserOutput;
import io.InputAsker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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
            output.printCurrentPlayer(game.getCurrentPlayer(), game.getBoard().ROWS, game.getBoard().COLS);

            try {
                row = input.getCoordinate(new InputAsker(System.in, System.out), game.getBoard().ROWS);
                col = input.getCoordinate(new InputAsker(System.in, System.out), game.getBoard().COLS);
                if (game.getCurrentPlayer() == Player.X) {
                    game.updateBoard(Seed.CROSS, row-1, col-1);
                } else {
                    game.updateBoard(Seed.NOUGHT, row-1, col-1);
                }

            } catch (InputMismatchException e) {
                System.out.println("This is not a number, try again.");
            } catch (NotValidMove ex) {
                ex.getMessage();
            }
            output.showBoard(game.getBoard());

            if (!game.getBoard().hasWon()) {
                if (game.getBoard().isDraw()) {
                    output.printThereIsADraw();
                    game.updateGameState(GameState.DRAW);
                }
            } else {
                output.printWhoWon(game.getCurrentPlayer());
                this.setUpdateGameState();
            }
            game.switchPlayer();
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
        output.printDoYouWantToPlayAgain();
        Character response = input.getInputYesOrNo(new InputAsker(System.in, System.out));
        if(response.toString().equals("Y")) {
            return true;
        }
        return false;
    }

}
