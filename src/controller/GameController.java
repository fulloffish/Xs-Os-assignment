package controller;

import game.Game;
import game.GameState;
import game.Seed;

/**
 * Created by krzysiek on 6/14/17.
 */
public class GameController {
    private Game game;

    private void startGame() {
        game = new Game();
        game.initGame();
    }

    private void play() {
        this.startGame();
        // print kto zaczyna
        while(game.getCurrentState().equals(GameState.PLAYING)) {
            // zacznij

        }
    }

    private void


}
