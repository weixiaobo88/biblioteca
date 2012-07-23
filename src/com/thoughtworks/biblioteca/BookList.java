package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/20/12
 * Time: 11:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookList {
    private ArrayList<Book> bookArrayList = new ArrayList<Book>();

    public BookList(){
        Book book1 = new Book(1, "Clean Code");
        Book book2 = new Book(2, "Refactor");
        Book book3 = new Book(3, "Tdd");
        Book book4 = new Book(4, "Java");

        bookArrayList.add(book1);
        bookArrayList.add(book2);
        bookArrayList.add(book3);
        bookArrayList.add(book4);
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
        if(bookArrayList.get(reserveBookId).isBookAvailableReserve()){
            bookArrayList.get(reserveBookId).setBookState(false);
            isReserveSuccessful = true;
        }
        return isReserveSuccessful;
    }
}

