package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    private Map<String , Command> map = new HashMap<String, Command>();

    private Bookshelf bookshelf;
    private InputStream inputStream = new InputStream();

    public MenuOption(){
        bookshelf = BookFactory.createBookshelf();

        menuOptionList.add("a, View book list.");
        menuOptionList.add("b, Reserve a book.");
        menuOptionList.add("c, Check the library number.");
        menuOptionList.add("d, Exit.");

        map.put("a", new ViewBook(bookshelf));
        map.put("b", new ReserveBook());
        map.put("c", new CheckLibraryNumber());
    }

    public void print() {
        for (String menu : menuOptionList) {
            System.out.println(menu);
        }
    }


    public void optionProcessor(){
        optionProcess(inputStream.inputString());
    }
    

    public String optionProcess(String option) {
//
//        if(option.equalsIgnoreCase("a")){
//            viewBook.execute();
//        }
//        else if(option.equalsIgnoreCase("b")){
//            reserveBook.execute();
//            }
//        else if(option.equalsIgnoreCase("c")){
//            checkLibraryNumber.execute();
//        }
//        else if(option.equalsIgnoreCase("d")){
//        	System.out.println("ByeBye~!");
//            System.exit(1);
//        }
//        else {
//            System.out.println("Please input correct order!");
//        }

        String output = "";
        if (map .containsKey(option)){
            output = map.get(option).execute();
        }
        return output;
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

