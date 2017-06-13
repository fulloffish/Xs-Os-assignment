package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = new Cell(null, null);
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
        Cell cell = new Cell(null, null);
        cell.clear();

        assertEquals("EMPTY", cell.getContent());
    }

    @Test
    @DisplayName("Seed is set by Setter")
    public void testIsSeedIsSetBySetter() {
        Cell cell = new Cell(1,1);
        cell.setContent(Seed.CROSS);
        assertSame("CROSS", cell.getContent().toString());
    }


    @Test
    @DisplayName("Seed is get by Getter")
    public void testIsSeedIsGetByGetter() {
        Cell cell = new Cell(1,1);
        cell.setContent(Seed.NOUGHT);
        assertEquals("NOUGHT", cell.getContent().toString());
    }


}