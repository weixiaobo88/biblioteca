package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/20/12
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bookshelf {
    private ArrayList<Book> bookArrayList = new ArrayList<Book>();

    public void addBook(Book book){
        bookArrayList.add(book);
    }

    public int bookListSize(){
        return bookArrayList.size();
    }

    public void printBookList() {
        for(int bookIndex = 0; bookIndex < bookArrayList.size(); bookIndex++){
            System.out.println(bookArrayList.get(bookIndex).bookInfo());
        }
    }

    public boolean reserve(Integer reserveBookId) {
        boolean isReserveSuccessful = false;
        Book book = bookArrayList.get(reserveBookId);
        if(book.isBookAvailableReserve()){
            book.setBookState(false);
            isReserveSuccessful = true;
        }
        return isReserveSuccessful;
    }
}

