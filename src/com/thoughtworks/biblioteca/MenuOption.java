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
    public static final String EXIT_COMMAND = "exit";
    public static final String BACK_COMMAND = "back";
    private ArrayList<String> menuOptionList = new ArrayList<String>();
    private Bookshelf bookshelf = new Bookshelf();
    private InputStream inputStream = new InputStream();
    ViewBook viewBook = new ViewBook();
    private final ReserveBook reserveBook = new ReserveBook();
    private final CheckLibraryNumber checkLibraryNumber = new CheckLibraryNumber();

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
            viewBook.viewBook();
        }
        else if(option.equalsIgnoreCase("b")){
            reserveBook.reserveBook();
            }
        else if(option.equalsIgnoreCase("c")){
            checkLibraryNumber.checkLibraryNumber();
        }
        else if(option.equalsIgnoreCase("d")){ 
        	System.out.println("ByeBye~!");
            System.exit(1);
        }
        else {
            System.out.println("Please input correct order!");
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


    public boolean isNum(String str)
    {
        boolean isNum;

        if(null==str||"".equals(str))
            isNum = false;
        else
            isNum = str.matches("[0-9]+");
        return isNum;
    }

    public String optionIs(int optionId) {
        return menuOptionList.get(optionId).toString();  //To change body of created methods use File | Settings | File Templates.
    }
}

