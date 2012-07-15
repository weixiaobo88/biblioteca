package com.thoughtworks.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/14/12
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */

public class Biblioteca {
    ArrayList<Book> bookList = new ArrayList<Book>();
    private static String promptMessageOfSuccessReserve = "Thank You! Enjoy the book.";
    private static String promptMessageOfUnsuccessReserve = "Sorry we don't have that book yet.";

    public String startMessage() {
        String welcomeMessage = "Welcome to use biblioteca!";
        System.out.println(welcomeMessage);
        return welcomeMessage;  //To change body of created methods use File | Settings | File Templates.
    }

    public Boolean startMenuOption() {
        MenuOption menuOption = new MenuOption();
        menuOption.printAllMenu();
        return true;
    }

    public void bookInitial(){
        Book book1 = new Book(1, "Clean Code");
        Book book2 = new Book(2, "Refactor");
        Book book3 = new Book(3, "Tdd");
        Book book4 = new Book(4, "Java");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
    }

    public ArrayList<Book> getBookList(){
        return this.bookList;
    }

    public Boolean bookView() {
        System.out.println("the books are :");
        for(int bookIndex = 0; bookIndex < bookList.size(); bookIndex++){
            System.out.println(bookList.get(bookIndex).bookId + ", " + bookList.get(bookIndex).bookName);
        }
        System.out.println("exit, back to the menu");
        System.out.println("Input the bookId like 2 to reserve book .");
        return true;
    }


    public void bookReserve(String inputBookId) 
    {
    	String getInputStr = inputBookId;
    	
    	while(true)
    	{
    		if("exit".equals(getInputStr))
    			break;    	
    		else if(!ifSelectedOptionIsLegal(getInputStr))
				System.out.println("please input the correct option .");				
    		else
    			dealBookReserve(Integer.valueOf(getInputStr));

    		bookView();
			try {
				getInputStr = Util.bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

   
    public boolean ifSelectedOptionIsLegal(String inputBookId)
    {
		boolean optionAvailableFlag = false;
		int bookId;

		if (Util.isNum(inputBookId)) 
		{
			bookId = Integer.valueOf(inputBookId);
			optionAvailableFlag = (findBookByBookId(bookId) != null);
		}

		return optionAvailableFlag;
    }


    public void dealBookReserve(int inputBookId)
    {
    	if(findBookByBookId(inputBookId) == null)
    	{
    		System.out.println("your input bookId is wrong" );
    	}
    	else
    	{
    		if(findBookByBookId(inputBookId).bookAvailableReserve)
    		{
    			System.out.println(promptMessageOfSuccessReserve);

    			findBookByBookId(inputBookId).bookAvailableReserve = false;
    		}
    		else
    			System.out.println(promptMessageOfUnsuccessReserve);
    	}
    }
       
    
    public Book findBookByBookId(int bookId)
    {
		Book book = null;
		for (int bookIdNum = 0; bookIdNum < bookList.size(); bookIdNum++) {
			if (bookList.get(bookIdNum).bookId == bookId) {
				book = bookList.get(bookIdNum);
				break;
			}
		}

		return book;
    }

    public Boolean checkLibraryNumber() {
        System.out.println("Please talk to Librarian. Thank you.");
        return true;
    }
}
