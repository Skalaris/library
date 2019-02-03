package pl.sda.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaperBookBuilderTest {

    @Test public void shouldBuildPaperBookWhenPaperBookDetailsAreDefined() {
        // given
        String authorFirstName = "Henryk";
        String authorLastName = "Sienkiewicz";
        String title = "W pustyni i w puszczy";
        CoverKind coverKind = CoverKind.SOFT;
        // when
        PaperBook book = new PaperBookBuilder()//
                .authorFirstName(authorFirstName)//
                .authorLastName(authorLastName)//
                .title(title)//
                .cover(coverKind)//
                .build();
        // then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertEquals(authorFirstName, book.getAuthor().getFirstName());
        assertEquals(authorLastName, book.getAuthor().getLastName());
        assertEquals(title, book.getTitle());
        assertEquals(coverKind, book.getCoverKind());
    }

}