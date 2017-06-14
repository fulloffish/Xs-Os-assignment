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
                    game.updateBoard(Seed.CROSS, row-1, col-1);
                } else {
                    game.updateBoard(Seed.NOUGHT, row-1, col-1);
                }
                game.switchPlayer();
            } catch (InputMismatchException e) {
                System.out.println("This is not a number, try again.");
            }
//        game.getBoard().getCell(0,0).setContent(Seed.CROSS);
//        game.getBoard().getCell(0,1).setContent(Seed.NOUGHT);
//        game.getBoard().getCell(0,2).setContent(Seed.EMPTY);
//        game.getBoard().getCell(1,0).setContent(Seed.NOUGHT);
//        game.getBoard().getCell(1,1).setContent(Seed.CROSS);
//        game.getBoard().getCell(1,2).setContent(Seed.NOUGHT);
//        game.getBoard().getCell(2,0).setContent(Seed.NOUGHT);
//        game.getBoard().getCell(2,1).setContent(Seed.NOUGHT);
//        game.getBoard().getCell(2,2).setContent(Seed.EMPTY);
            output.showBoard(game.getBoard());
            if (game.getBoard().hasWon()) {

                game.updateGameState(GameState.CROSS_WON);
            }
        }
    }


    public boolean wantToPlayAgain() {
        // scaner input y n, ify
        return false;

    }


}
