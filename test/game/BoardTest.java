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
    @DisplayName("hasWon() method returns true if three Cells in a row are crosses")
    public void testHasWonReturnTrueIfGameIsWon(){
        Seed winningSeed = Seed.CROSS;
        this.setCellsContentToGetWantedEffect(winningSeed);
        assertTrue(this.board.hasWon());
    }

    @Test
    @DisplayName("hasWon() method returns false if three Cells in a row are empty")
    public void testHasWonReturnFalseIfThreeCellsAreEmpty(){
        Seed emptySeed = Seed.EMPTY;
        this.setCellsContentToGetWantedEffect(emptySeed);
        assertFalse(board.hasWon());
    }

    private void setCellsContentToGetWantedEffect(Seed seed) {
        this.board.getCell(0,0).setContent(seed);
        this.board.getCell(0,1).setContent(seed);
        this.board.getCell(0,2).setContent(seed);
    }

    @Test
    @DisplayName("hasWon() method returns false if three Cells in a row has different seed")
    public void testHasWonReturnFalseIfGameIsNotWon(){

        this.board.getCell(0,0).setContent(Seed.CROSS);
        this.board.getCell(0,1).setContent(Seed.NOUGHT);
        this.board.getCell(0,2).setContent(Seed.CROSS);

        assertFalse(board.hasWon());
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