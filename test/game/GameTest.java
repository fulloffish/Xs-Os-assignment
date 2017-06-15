package game;

import exception.NotValidMoveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private int sampleRow = 1;
    private int sampleCol = 1;
    private Cell sampleCell;

    @BeforeEach
    public void setup() {
        this.game = new Game();
        this.game.initGame();
        this.sampleCell = this.game.getBoard().getCell(sampleRow, sampleCol);
    }

    @Test
    @DisplayName("CurrentPlayer is set by constructor")
    public void testConstructorSetsCurrentPlayerInstanceVariable() {
        Player currentPlayer = Player.O;
        this.game.setCurrentPlayer(currentPlayer);
        assertEquals(currentPlayer, this.game.getCurrentPlayer() );
    }

    @Test
    @DisplayName("InitGame() sets all instance variables")
    public void testInitGameSetsAllInstanceVariables() {
        assertAll("Every variable is set",
                () -> assertNotNull(this.game.getCurrentPlayer()),
                () -> assertNotNull(this.game.getCurrentState()),
                () -> assertNotNull(this.game.getBoard()),
                () -> assertNotNull(this.game.getBoard().getCell(1,1)));
    }

    @Test
    @DisplayName("UpdateBoard() changes cell content")
    public void testUpdateBoardSetsCellsInstanceVariable() {
        Seed oldContent = this.sampleCell.getContent();
        Seed newContent = Seed.CROSS;
        this.game.updateBoard(newContent, sampleRow, sampleCol);
        assertNotEquals(oldContent, newContent);
    }

    @Test
    @DisplayName("UpdateBoard() does not change cell content when cell is not empty")
    public void testDoesNotUpdateBoardWhenCellIsNotEmpty() {
        this.sampleCell.setContent(Seed.CROSS);
        Seed newContent = Seed.NOUGHT;
        assertThrows(NotValidMoveException.class, () -> {
            this.game.updateBoard(newContent, sampleRow, sampleCol);
                }
        );
    }

    @Test
    @DisplayName("UpdateGameState() changes currentState instance variable")
    public void testUpdateGameStateSetsCurrentStateInstanceVariable() {
        GameState oldState = this.game.getCurrentState();
        GameState newState = GameState.CROSS_WON;
        this.game.updateGameState(newState);
        assertNotEquals(oldState, newState);
    }

    @Test
    @DisplayName("Current player is switched")
    public void testCurrentPlayerIsSwitched() {
        Player playerBeforeSwitch = Player.O;
        this.game.setCurrentPlayer(playerBeforeSwitch);
        this.game.switchPlayer();
        assertNotEquals(playerBeforeSwitch, this.game.getCurrentPlayer());
    }

}