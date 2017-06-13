package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Integer sampleNumber1 = 0;
    private Integer sampleNumber2 = 0;
    private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = new Cell(sampleNumber1, sampleNumber2);
    }

    @Test
    @DisplayName("Cell row and col are set by constructor")
    public void testConstructorSetsRowAndColNumber() {
        Cell cell = new Cell(1, 2);

        assertAll("Row and col number",
                () -> assertEquals(1, cell.getRow()),
                () -> assertEquals(2, cell.getCol())
        );
    }

    @Test
    @DisplayName("Clear method sets cell's content to 'EMPTY' ")
    public void testIfClearMethodRemovesCellsContent() {
        Cell cell = new Cell(sampleNumber1, sampleNumber2);

        assertEquals("EMPTY", cell.clear());
    }

    @Test
    @DisplayName("Seed is set by Setter")
    public void testIsSeedIsSetBySetter() {
        Cell cell = new Cell(1,1);
        cell.setSeed(Seed.CROSS);
        assertSame("CROSS", cell.getSeed().toString());
    }


    @Test
    @DisplayName("Seed is get by Getter")
    public void testIsSeedIsGetByGetter() {
        Cell cell = new Cell(1,1);
        cell.setSeed(Seed.NOUGHT);
        assertEquals("NOUGHT", cell.getSeed().toString());
    }

    @Test
    @DisplayName("Init fill cells list with Cells objects")
    public void testIfInitSetsCellsInProperPlaces() {
        cell.init();

        assertAll("Every place filled",
                () -> assertNotNull(cell.getCell(1, 1)),
                () -> assertNotNull(cell.getCell(1, 1)),
                () -> assertNotNull(cell.getCell(1, 1)),
                () -> assertNotNull(cell.getCell(2, 2)),
                () -> assertNotNull(cell.getCell(2, 2)),
                () -> assertNotNull(cell.getCell(2, 2)),
                () -> assertNotNull(cell.getCell(3, 3)),
                () -> assertNotNull(cell.getCell(3, 3)),
                () -> assertNotNull(cell.getCell(3, 3))
        );
    }

}