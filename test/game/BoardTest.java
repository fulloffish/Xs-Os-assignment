package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        this.board = new Board();
        this.board.init();
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
    @DisplayName("IsDraw() method checks if there is a draw")
    public void testFailsIfMethodReturnFalseAndAllContentsAreCrossOrNaughtAndHasWonIsTrue() {
        fillAllCellsWithContentToMakeADraw();
        assertTrue(this.board.isDraw());
    }

    private void fillAllCellsWithContentToMakeADraw() {
        for (int rowIndex = 0; rowIndex < board.ROWS; rowIndex++) {
            for (int columnIndex = 0; columnIndex < board.COLS; columnIndex++) {
                this.board.getCell(rowIndex, columnIndex).setContent(Seed.CROSS);
            }
        }
    }

    @Test
    @DisplayName("hasWon() method returns true if SIGNS_TO_WIN Cells in a row are crosses")
    public void testHasWonReturnTrueIfGameIsWon() {
        Seed sampleWinningSeed = Seed.NOUGHT;
        this.setSampleCellsContent();
        assertTrue(this.board.hasWon(new Cell(0, 2, sampleWinningSeed)));
    }


    @Test
    @DisplayName("hasWon() method returns false if there is no win")
    public void testHasWonReturnFalseIfThereIsNoWin() {
        Seed loosingSeed = Seed.CROSS;
        this.setSampleCellsContent();
        assertFalse(board.hasWon(new Cell(0, this.board.SIGNS_TO_WIN - 1, loosingSeed)));
    }

    private void setSampleCellsContent() {
        for (int i = 0; i < this.board.SIGNS_TO_WIN; i++) {
            this.board.getCell(0, i).setContent(Seed.NOUGHT);
        }
    }

    @Test
    @DisplayName("GetCell() returns proper cell")
    public void testGetCellReturnsProperValue() {
        Cell sampleCell = this.board.getCell(0,1);
        Seed sampleSeed = Seed.CROSS;
        sampleCell.setContent(sampleSeed);
        assertEquals(sampleSeed, sampleCell.getContent());
    }

    @Test
    @DisplayName("Clear all cells sets all Cells' content to EMPTY")
    public void testClearSetsAllCellsContentToEmpty() {
        Cell sampleCell = this.board.getCell(0,1);
        Seed contentToBeChangedByClearMethod = Seed.CROSS;
        Seed expectedContent = Seed.EMPTY;
        sampleCell.setContent(contentToBeChangedByClearMethod);
        this.board.clearAllCells();
        assertAll("Every Cell's content is empty",
                () -> assertEquals(expectedContent, this.board.getCell(0, 0).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(0, 1).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(0, 2).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(1, 0).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(1, 1).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(1, 2).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(2, 0).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(2, 1).getContent()),
                () -> assertEquals(expectedContent, this.board.getCell(2, 2).getContent())
        );
    }

}