import controller.GameController;

/**
 * Created by krzysiek on 6/14/17.
 */
public class Application {
    private GameController gameController;
    boolean playAgain;

    private void mainGameLoop() {
        playAgain = true;
        gameController = new GameController();
        gameController.startGame();

        do {

            gameController.play();
            playAgain = gameController.wantToPlayAgain();
        }
        while(playAgain);
    }
}
