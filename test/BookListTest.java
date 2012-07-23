import com.thoughtworks.biblioteca.BookList;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/21/12
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookListTest {
    private BookList bookList = new BookList();

    @Test
    public void should_reserve_successfully_when_book_is_available(){
        assertThat(bookList.reserve(1), is(true));
    }

    @Test
    public void should_reserve_unsuccessfully_when_book_is_unavailable(){
        bookList.reserve(1);
        assertThat(bookList.reserve(1), is(false));
    }

}
