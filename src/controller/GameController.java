package controller;

import game.*;
import io.IntegerAsker;
import io.UserInput;
import io.UserOutput;

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
                row = input.getCoordinate(new IntegerAsker(System.in, System.out), game.getBoard().ROWS);
                col = input.getCoordinate(new IntegerAsker(System.in, System.out), game.getBoard().COLS);
                if (game.getCurrentPlayer() == Player.X) {
                    game.updateBoard(Seed.CROSS, row, col);
                } else {
                    game.updateBoard(Seed.NOUGHT, row, col);
                }
                game.switchPlayer();
            } catch (InputMismatchException e) {
                System.out.println("This is not a number, try again.");
            }
        }
    }


    public boolean wantToPlayAgain() {
        // scaner input y n, ify
        return false;

    }


}
