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
        }
    }

    public boolean wantToPlayAgain() {
        output.printDoYouWantToPlayAgain();
        Character response = input.getInputYesOrNo();
        if(response.toString().equals("Y")) {
            return true;
        }
        return false;
    }

}
