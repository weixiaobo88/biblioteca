package com.thoughtworks.biblioteca;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuOption {
    private ArrayList<String> menuOptionList = new ArrayList<String>();
    private Bookshelf bookshelf = new Bookshelf();
    private InputStream inputStream = new InputStream();

    public MenuOption(){
        menuOptionList.add("a, View book list.");
        menuOptionList.add("b, Reserve a book.");
        menuOptionList.add("c, Check the library number.");
        menuOptionList.add("d, Exit.");
    }

    public void print() {

        for(int menuIndex = 0; menuIndex < menuOptionList.size(); menuIndex++) {
            System.out.println(menuOptionList.get(menuIndex));
        }

    }

    public void optionProcessor(){
        optionProcess(inputStream.inputString());
    }
    

    public void optionProcess(String option) {
        
        if(option.equalsIgnoreCase("a")){
            viewBook();
        }
        else if(option.equalsIgnoreCase("b")){        	
            reserveBook();            
            }
        else if(option.equalsIgnoreCase("c")){
            checkLibraryNumber();           
        }
        else if(option.equalsIgnoreCase("d")){ 
        	System.out.println("ByeBye~!");
            System.exit(1);
        }
        else {
            System.out.println("Please input correct order!");
        }
        
    }
    
    public void viewBook() {
        System.out.println("--All books are:---------------------------");
        bookshelf.printBookList();
        printViewExtraDirective();
        afterView();
    }

    private void afterView() {
        boolean flag = true;
        String viewDirective = inputStream.inputString();
        while(flag)
        {
            if("reserve".equals(viewDirective)){
            	flag = false;
            	reserveBook();
            }
            else if("back".equals(viewDirective))
                break;
            else if("exit".equals(viewDirective)){
            	flag = false;
            	inputStream = null;
            	System.out.println("ByeBye~!");
            	System.exit(1);
            }
            else{
            	System.out.println("Please input the correct order!");
            	printViewExtraDirective();
            	viewDirective = inputStream.inputString();
            }

        }
    }

    public void checkLibraryNumber() {
        System.out.println("Please talk to Librarian. Thank you.");
    }

    public void reserveBook() {
        boolean flag = true;
        bookshelf.printBookList();
        printReserveExtraDirective();
        
        String reserveBookId = inputStream.inputString();
        while(flag)
        {
            if("back".equals(reserveBookId))
                break;
            else if("exit".equals(reserveBookId)){
            	inputStream = null;
            	System.out.println("ByeBye~!");
            	System.exit(1);
            }           	
            else if(!isNum(reserveBookId))
            	System.out.println("Please input the correct order or the book id"); 
            else if(!ifSelectedOptionIsValid(Integer.valueOf(reserveBookId))){
                System.out.println("Please input the correct id .");
            }
            else if(bookshelf.reserve(Integer.valueOf(reserveBookId)))
                System.out.println("Thank You! Enjoy the book.");
            else {
                System.out.println("Sorry we don't have that book yet.");
            }

            printReserveExtraDirective();  
            reserveBookId = inputStream.inputString();
        }
    }


    public boolean ifSelectedOptionIsValid(int inputBookId)
    {
        boolean inputIsValid = false;

        for(int bookNum = 1; bookNum <= bookshelf.bookListSize(); bookNum++){
            if (inputBookId == bookNum){
                inputIsValid = true;
            }
        }

        return inputIsValid;
    }

    public void printReserveExtraDirective()
    {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    	System.out.println("back-> back to the main menu");
    	System.out.println("exit-> exit the system");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    	System.out.println("--Please input the id of the book to reserve, or 'back',or 'exit'");
    }

    public void printViewExtraDirective()
    {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    	System.out.println("reserve-> go to the reserve menu");
    	System.out.println("back-> back to the main menu");
    	System.out.println("exit-> exit the system");
        System.out.println("-------------------------------------------");
        System.out.println("--Please input the option like: reserve----");
    }
    
    public boolean isNum(String str)
    {
        boolean isNum;

        if(null==str||"".equals(str))
            isNum = false;
        else
            isNum = str.matches("[0-9]+");
        return isNum;
    }
    
}

