import controller.GameController;
import game.Board;

public class Main {

    public static void main(String[] args) {
        GameController gameC = new GameController();
        gameC.startGame();
        gameC.play();
    }
}