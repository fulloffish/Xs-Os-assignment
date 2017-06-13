package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Cell cell;
    private Board board;

    @BeforeEach
    private void setUp() {
        cell = new Cell(null, null);
        board = new Board();
    }

    @Test
    @DisplayName("Init fill cells list with Cells objects")
    public void testIfInitSetsCellsInProperPlaces() {
        board.init();

        assertAll("Every place is filled",
                () -> assertNotNull(board.getCell(1, 1)),
                () -> assertNotNull(board.getCell(1, 2)),
                () -> assertNotNull(board.getCell(1, 3)),
                () -> assertNotNull(board.getCell(2, 1)),
                () -> assertNotNull(board.getCell(2, 2)),
                () -> assertNotNull(board.getCell(2, 3)),
                () -> assertNotNull(board.getCell(3, 1)),
                () -> assertNotNull(board.getCell(3, 2)),
                () -> assertNotNull(board.getCell(3, 3))
        );
    }
}