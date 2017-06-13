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
                () -> assertEquals(1, cell.getRowNumber()),
                () -> assertEquals(2, cell.getColNumber())
        );
    }



    @Test
    @DisplayName("Title is set by constructor")
    void testConstructorSetsTitleInstanceVariable() {
        String title = "Mastering Microservices with Java";
        Book book = new Book(title, null);

        assertEquals(title, book.getTitle());
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