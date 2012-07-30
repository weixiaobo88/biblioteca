package com.thoughtworks.biblioteca;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/20/12
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuOptionTest {

    private MenuOption menuOption = new MenuOption();


    @Test
    public void should_return_menu_option_when_given_the_menu_id(){
        assertThat("The menu is not correct", menuOption.optionIs(0), is("a, View book list."));
    }




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
    public void test(){
        PrintStream mockPrintStream = mock(PrintStream.class);
        when(mockPrintStream.checkError()).thenReturn(false);
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
//    public void should_show_sorry_when_selected_book_is_unavailable(){
//
//        System.setOut(mockPrintStream);
//        System.setIn(mockInputStream);
//        context.checking(new Expectations(){{
//            oneOf(mockPrintStream).println("Sorry we don't have that book yet.");
//        }});
//
//        menuOption.reserveBook();
//    }


    @Test
    public void should_return_false_when_input_is_not_a_number(){
        assertThat("input is a number!", menuOption.isNum("z"), is(false));
    }
    @Test
    public void should_return_true_when_input_is_a_number(){
        assertThat("input is not a number!", menuOption.isNum("9"), is(true));
    }

}
