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
        cell.clear();
        assertEquals("EMPTY", cell.getContent().toString());
    }

    @Test
    @DisplayName("Content is set by Setter")
    public void testIsSeedIsSetBySetter() {
        cell.setContent(Seed.CROSS);
        assertSame("CROSS", cell.getContent().toString());
    }

    @Test
    @DisplayName("Content is get by Getter")
    public void testIsSeedIsGetByGetter() {
        cell.setContent(Seed.NOUGHT);
        assertEquals("NOUGHT", cell.getContent().toString());
    }

}