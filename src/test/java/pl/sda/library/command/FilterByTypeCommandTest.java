package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class FilterByTypeCommandTest {

    private InputStream inputStream;

    @Before
    public void setUp()  {
        inputStream = System.in;
        System.setIn(new ByteArrayInputStream("Movie\n".getBytes()));
    }

    @After
    public void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    public void shouldDisplayMoviesWhenFilterByMovie(){
        //given
        PaperBook book = new PaperBookBuilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("W pustyni i w puszczy")
                .cover(Cover.HARD)
                .pageCount(300)
                .build();

        Movie movie1 = new MovieBuilder()
                .directorFirstName("Władysław")
                .directorLastName("ślesicki")
                .title("W pustyni i w puszczy")
                .duration(100)
                .build();

        Movie movie2 = new MovieBuilder()
                .directorFirstName("Władysław")
                .directorLastName("pasikowski")
                .title("słodko gorzki")
                .duration(120)
                .build();
        Library<Multimedia> library = new Library<>();
        library.addMedia(book);
        library.addMedia(movie1);
        library.addMedia(movie2);

        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new FilterByTypeCommand(library, printStreamMock);

        //when
        command.execute();
        //then
        verify(printStreamMock,times(1)).println("Type:");
        verify(printStreamMock, times(1)).println(movie1);
        verify(printStreamMock, times(1)).println(movie2);
        verify(printStreamMock,never()).println(book);
    }
}