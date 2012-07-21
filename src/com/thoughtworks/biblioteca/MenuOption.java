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
    private ArrayList<String> menuOptionList = new ArrayList();
    BookList bookList = new BookList();

    public MenuOption(){
        menuOptionList.add("a, View book list.");
        menuOptionList.add("b, Reserve a book.");
        menuOptionList.add("c, Check the library number.");
        menuOptionList.add("d, Exit.");
    }

    public void print() {
        ArrayList<String> menuOptionList1 = menuOptionList;
        String s = generateResult(menuOptionList1);
        System.out.println(s);
    }

    private String generateResult(ArrayList<String> menuOptionList1) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int menuIndex = 0; menuIndex < menuOptionList1.size(); menuIndex++) {
            stringBuffer.append(menuOptionList1.get(menuIndex));
        }
        return stringBuffer.toString();
    }


    public String optionProcessor(String option) {
        String optionProcessorResult = "no result";
        if(option.equalsIgnoreCase("a")){
            viewBook();
            optionProcessorResult = "viewBook";
        }
        return optionProcessorResult;  //To change body of created methods use File | Settings | File Templates.
    }


    public void viewBook() {
        bookList.printBookList();
    }
}

