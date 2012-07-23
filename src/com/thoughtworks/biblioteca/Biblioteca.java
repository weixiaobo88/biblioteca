package com.thoughtworks.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */

public class Biblioteca {

    public void showMessage() {
        String welcomeMessage = "Welcome to use biblioteca!";
        System.out.println(welcomeMessage);
    }

   public static void main(String args[]){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.startUp();
   }

    private void startUp() {
        showMessage();
        MenuOption menuOption = new MenuOption();        

        while (true){
            System.out.println("-------------------------------------------");
        	menuOption.print();
            System.out.println("-----Please input the option like: a-------");
            menuOption.optionProcessor();
        }

    }


}
