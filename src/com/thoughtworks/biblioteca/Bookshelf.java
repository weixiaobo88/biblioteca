package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Bookshelf {
    private ArrayList<Book> bookArrayList = new ArrayList<Book>();

    public void addBook(Book book){
        bookArrayList.add(book);
    }

    public int bookListSize(){
        return bookArrayList.size();
    }

    public String bookListString() {
        String bookListString = "";
        for(int bookIndex = 0; bookIndex < bookArrayList.size(); bookIndex++){
            System.out.print(bookArrayList.get(bookIndex).bookInfo());
            bookListString += bookArrayList.get(bookIndex).bookInfo();
        }
        return bookListString;
    }

    public boolean reserve(Integer reserveBookId) {
        return bookArrayList.get(reserveBookId).reserve();
    }
}

