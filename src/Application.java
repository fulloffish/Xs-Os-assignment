import controller.GameController;

public class Application {
    private GameController gameController;
    boolean isGameOngoing;

    private void setup() {
        this.isGameOngoing = true;
        this.gameController = new GameController();
    }

    public void run() {
        this.setup();
        this.gameController.setUpGame();
        do {
            this.gameController.play();
            this.isGameOngoing = gameController.wantToPlayAgain();
        }
        while(isGameOngoing);
    }

}
