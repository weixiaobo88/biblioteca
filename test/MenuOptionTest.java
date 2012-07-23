import com.thoughtworks.biblioteca.MenuOption;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/20/12
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuOptionTest {

    private MenuOption menuOption = new MenuOption();

    private Mockery context = new JUnit4Mockery(){
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };
    private PrintStream mockPrintStream = context.mock(PrintStream.class);
    private InputStream mockInputStream = context.mock(InputStream.class);



    @Test
    public void should_show_menu_option_when_start_up(){

        System.setOut(mockPrintStream);

        context.checking(new Expectations(){{
            oneOf(mockPrintStream).println();
        }});

        menuOption.print();
    }

    @Test
    public void should_return_true_when_input_option_is_valid(){
        assertThat(menuOption.ifSelectedOptionIsValid(3), is(true));
    }

    @Test
    public void should_return_false_when_input_option_is_invalid(){
        assertThat(menuOption.ifSelectedOptionIsValid(5), is(false));
    }


//    @Test
//    public void should_show_book_list_when_select_the_menu_of_view_books(){
//        String optionOfViewBook = "a";
//        assertThat(menuOption.optionProcess(optionOfViewBook),is("viewBook"));
//    }
//
//
//    @Test
//    public void should_exit_when_select_the_menu_of_exit(){
//        String optionOfExit = "exit";
//        assertThat(menuOption.optionProcess(optionOfExit),is("exit"));
//    }

    @Test
    public void should_show_sorry_when_selected_book_is_unavailable(){

        System.setOut(mockPrintStream);
        System.setIn(mockInputStream);
        context.checking(new Expectations(){{
            oneOf(mockPrintStream).println("Sorry we don't have that book yet.");
        }});

        menuOption.reserveBook();
    }

}
