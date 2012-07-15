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

    private ArrayList<String> menuOptionList = new ArrayList();

    public MenuOption(){
        String promptMessage = "Please input option character like: a";
        menuOptionList.add("a. View book list.");
        menuOptionList.add("b. Reserve a book.");
        menuOptionList.add("c. Check the library number.");
        menuOptionList.add("d. Exit.");
        System.out.println(promptMessage);
    }

    public void printAllMenu() {
        System.out.println("the menu is :");
        for(int menuIndex = 0; menuIndex < menuOptionList.size(); menuIndex++){
            System.out.println(menuOptionList.get(menuIndex));
        }
    }
}

