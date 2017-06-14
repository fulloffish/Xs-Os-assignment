package controller;

import game.Game;
import game.GameState;
import game.Seed;

/**
 * Created by krzysiek on 6/14/17.
 */
public class GameController {
    private Game game;

    public void startGame() {
        game = new Game();
        game.initGame();
    }

    public void play() {
        // print kto zaczyna
        while(game.getCurrentState().equals(GameState.PLAYING)) {
            // zacznij

        }
    }

    public boolean wantToPlayAgain() {
        // scaner input y n, ify
        return false;

    }


}
