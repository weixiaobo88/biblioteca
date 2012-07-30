package com.thoughtworks.biblioteca;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/21/12
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookShelfTest {
    private Bookshelf bookshelf = new Bookshelf();

    private Mockery context = new JUnit4Mockery(){
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };
    private PrintStream mockPrintStream = context.mock(PrintStream.class);

    private void addBook() {
        bookshelf.addBook(new Book(1, "Test Driven Development"));
    }

    @Test
    public void should_return_the_size_of_the_bookshelf(){
        addBook();
        assertThat("The number of books is not correct", bookshelf.bookListSize(), is(1));
    }



    @Test
    public void should_print_books_when_given_the_bookshelf(){
        addBook();
        System.setOut(mockPrintStream);
        context.checking(new Expectations(){{
            oneOf(mockPrintStream).print("1:Test Driven Development");
        }});

        bookshelf.printBookList();
    }


    @Test
    public void should_reserve_successfully_when_book_is_available(){
        assertThat(bookshelf.reserve(1), is(true));
    }

    @Test
    public void should_reserve_unsuccessfully_when_book_is_unavailable(){
        bookshelf.reserve(1);
        assertThat(bookshelf.reserve(1), is(false));
    }

}
