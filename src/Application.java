import controller.GameController;

public class Application {
    private GameController gameController;
    boolean playAgain;



    public void run() {
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
