import controller.GameController;

public class Application {
    private GameController gameController;
    boolean playAgain;

    private void setup() {
        this.playAgain = true;
        this.gameController = new GameController();
    }

    public void run() {

        this.setup();
        this.gameController.startGame();
        do {
            this.gameController.play();
            playAgain = gameController.wantToPlayAgain();
        }
        while(playAgain);
    }

}
