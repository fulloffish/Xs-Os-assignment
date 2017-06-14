package controller;

import game.*;
import io.UserInput;
import io.UserOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 6/14/17.
 */
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
        while(game.getCurrentState().equals(GameState.PLAYING)) {
            output.printCurrentPlayer(game.getCurrentPlayer(), game.getBoard().ROWS, game.getBoard().COLS);
            row = input.getCoordinate(game.getBoard().ROWS);
            col = input.getCoordinate(game.getBoard().COLS);
            if (game.getCurrentPlayer() == Player.X) {
                game.updateBoard(Seed.CROSS, row, col);
            } else {
                game.updateBoard(Seed.NOUGHT, row, col);
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
            this.setUpdateGameState();
            if (!game.getBoard().hasWon()) {
                if (game.getBoard().isDraw()) {
                    output.printThereIsADraw();
                }
            }
        }
        output.printWhoWon(game.getCurrentPlayer());
    }

    private void setUpdateGameState() {
        if (game.getCurrentPlayer() == Player.X) {
            game.updateGameState(GameState.CROSS_WON);
        } else {
            game.updateGameState(GameState.NOUGHT_WON);
        }
    }

    public boolean wantToPlayAgain() {
        // scaner input y n, ify
        return false;

    }


}
