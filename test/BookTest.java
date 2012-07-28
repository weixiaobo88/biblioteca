import com.thoughtworks.biblioteca.Book;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/28/12
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class BookTest {

    private Book book = new Book(1,"Test Driven Development");

    @Test
    public void should_return_book_info_when_given_a_book(){
        assertThat("The info of the book is not correct", book.bookInfo(), is("1:Test Driven Development"));
    }

    @Test
    public void should_return_true_when_given_book_id_which_is_available_for_reserve(){
        assertThat("The book is unavailable",  book.reserve(1), is(true));
    }


}
