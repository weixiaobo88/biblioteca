import com.thoughtworks.biblioteca.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Created with IntelliJ IDEA.
* User: twer
* Date: 7/12/12
* Time: 10:35 PM
* To change this template use File | Settings | File Templates.
*/
public class BibliotecaTest {
    private Biblioteca biblioteca = new Biblioteca();


    @Before
    public void setUp(){
        biblioteca.startMessage();
        biblioteca.startMenuOption();
        biblioteca.bookInitial();
    }

    @Test
    public void should_customer_see_welcome_when_start_application(){
        assertThat("No welcome message showed!", biblioteca.startMessage(), is("Welcome to use biblioteca!"));

    }

    @Test
    public void should_customer_see_menu_option_when_start_application(){
        assertThat("No menu option!", biblioteca.startMenuOption(), is(true));
    }

    @Test
    public void should_return_book_list_when_customer_select_menu_of_view_books(){
        assertThat("No books!", biblioteca.bookView(), is(true));
    }

    @Test
    public void should_return_true_when_input_book_id_is_correct(){
        String inputBookId = "2";
        assertThat(biblioteca.ifSelectedOptionIsLegal(inputBookId), is(true));
    }
    @Test
    public void should_return_false_when_input_book_id_is_incorrect(){
        String inputBookId = "m";
        assertThat(biblioteca.ifSelectedOptionIsLegal(inputBookId), is(false));
    }


    @Test
    public void should_book_be_available_before_customer_reserve_it(){
        int bookId = 1;
        assertThat(biblioteca.findBookByBookId(bookId).getBookAvailableReserve(), is(true));
    }

    @Test
    public void should_book_be_unavailable_when_customer_reserved_it(){
        int bookId = 1;
        biblioteca.dealBookReserve(bookId);
        assertThat(biblioteca.findBookByBookId(bookId).getBookAvailableReserve(), is(false));
    }



}

