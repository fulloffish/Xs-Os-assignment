package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Integer sampleNumber1 = 1;
    private Integer sampleNumber2 = 2;

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
    @DisplayName("Author is set by constructor")
    void testConstructorSetsAuthorInstanceVariable() {
        String authorName = "Sourabh Sharma";
        Author author = new Author(authorName);
        Book book = new Book(null, author);

        assertEquals(author, book.getAuthor());
    }

    @Test
    @DisplayName("Summary is set by constructor")
    void testConstructorSetsSummary() {
        String summary = "This is book's summary";
        Book book = new Book(null, null, summary);

        assertEquals(summary, book.getSummary());
    }
}