package com.thoughtworks.biblioteca;

public class BookFactory {
    public static Bookshelf createBookshelf() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook(new Book(1, "Tdd"));
        bookshelf.addBook(new Book(2, "Refactoring"));
        bookshelf.addBook(new Book(3, "Clean code"));
        bookshelf.addBook(new Book(4, "Scrum"));
        return bookshelf;
    }
}
