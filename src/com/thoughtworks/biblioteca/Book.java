package com.thoughtworks.biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {

    int bookId;
    String bookName;
    boolean bookAvailableReserve = true;

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public boolean getBookAvailableReserve(){
        return bookAvailableReserve;
    }


}
