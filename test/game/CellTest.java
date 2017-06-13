package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    @DisplayName("Cell row is set by constructor")
    public void testConstructorSetsRowAndColNumber() {
        Cell cell = new Cell(1, 2);

        assertAll("Row and col number",
                () -> assertEquals(1, cell.getRow()),
                () -> assertEquals(2, cell.getCol())
        );
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

}