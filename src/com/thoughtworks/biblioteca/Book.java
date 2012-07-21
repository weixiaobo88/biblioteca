package com.thoughtworks.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {

    private int bookId;
    private String bookName;
    private boolean bookAvailableReserve = true;


    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }


    public String bookInfo() {
        String bookInfo = this.bookId + "->" + this.bookName;
        return bookInfo;  //To change body of created methods use File | Settings | File Templates.
    }
}
