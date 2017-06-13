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
    @DisplayName("IsDraw method checks if there is a draw")
    public void testFailsIfMethodReturnFalseAndAllContentsAreCrossOrNaughtAndHasWonIsTrue() {
        BoardTest boardTest = new BoardTest();
        boardTest.fillCellsWithAnySeed();

        assertEquals(true, board.isDraw());
    }

    private void fillCellsWithAnySeed() {
        for(int rowIndex = 0; rowIndex < board.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < board.COLS; columnIndex++) {
                board.getCell(rowIndex, columnIndex).setContent(Seed.CROSS);
            }
        }
    }

}