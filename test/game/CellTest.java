package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = new Cell();
    }

    @Test
    @DisplayName("Clear method sets cell's content to 'EMPTY' ")
    public void testIfClearMethodRemovesCellsContent() {
        Seed expected = Seed.EMPTY;
        this.cell.clear();
        assertEquals(expected, cell.getContent());
    }

    @Test
    @DisplayName("Content is set by Setter")
    public void testIsSeedIsSetBySetter() {
        Seed seedToBeSet = Seed.CROSS;
        this.cell.setContent(seedToBeSet);
        assertSame(seedToBeSet, cell.getContent());
    }

    @Test
    @DisplayName("Content is get by Getter")
    public void testIsSeedIsGetByGetter() {
        Seed seedToBeGotten = Seed.NOUGHT;
        this.cell.setContent(seedToBeGotten);
        assertEquals(seedToBeGotten, cell.getContent());
    }

}