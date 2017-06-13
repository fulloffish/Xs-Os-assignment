package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.init();
    }

    @Test
    @DisplayName("Init fill cells list with Cells objects")
    public void testIfInitSetsCellsInProperPlaces() {

        assertAll("Every place is filled",
                () -> assertNotNull(board.getCell(0, 0)),
                () -> assertNotNull(board.getCell(0, 1)),
                () -> assertNotNull(board.getCell(0, 2)),
                () -> assertNotNull(board.getCell(1, 0)),
                () -> assertNotNull(board.getCell(1, 1)),
                () -> assertNotNull(board.getCell(1, 2)),
                () -> assertNotNull(board.getCell(2, 0)),
                () -> assertNotNull(board.getCell(2, 1)),
                () -> assertNotNull(board.getCell(2, 2))
        );
    }

    @Test
    @DisplayName("hasWon() method returns true if three Cells in a row are crosses")
    public void testHasWonReturnTrueIfGameIsWon(){

        board.getCell(0,0).setContent(Seed.CROSS);
        board.getCell(0,1).setContent(Seed.CROSS);
        board.getCell(0,2).setContent(Seed.CROSS);

        assertTrue(board.hasWon());

    }

    @Test
    @DisplayName("hasWon() method returns false if three Cells in a row are empty")
    public void testHasWonReturnFalseIfThreeCellsAreEmpty(){

        board.getCell(0,0).setContent(Seed.EMPTY);
        board.getCell(0,1).setContent(Seed.EMPTY);
        board.getCell(0,2).setContent(Seed.EMPTY);

        assertFalse(board.hasWon());

    }
}