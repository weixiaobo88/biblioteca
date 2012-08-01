package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/31/12
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewBookTest {
    private ViewBook viewBook = new ViewBook();
    Bookshelf bookshelf = new Bookshelf();


    @Test
    public void should_be_able_to_view_books(){
        bookshelf.addBook(new Book(1, "Test Driven Development"));
        String output = viewBook.execute();

        assertThat(output, is("1: Test Driven Development"));
    }


}
