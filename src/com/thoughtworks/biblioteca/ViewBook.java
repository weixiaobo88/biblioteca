package com.thoughtworks.biblioteca;

public class ViewBook {
    private Bookshelf bookshelf = new Bookshelf();
    private ReserveBook reserveBook = new ReserveBook();
    private InputStream inputStream = new InputStream();
    public static final String RESERVE_COMMAND = "reserve";
    public static final String EXIT_COMMAND = "exit";
    public static final String BACK_COMMAND = "back";


    public void viewBook() {
        System.out.println("--All books are:---------------------------");
        bookshelf.printBookList();
        printViewExtraDirective();
        afterView();
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


    private void afterView() {
        boolean flag = true;
        String viewDirective = inputStream.inputString();
        while(flag)
        {
            if(viewDirective.equalsIgnoreCase(RESERVE_COMMAND)){
                flag = false;
                reserveBook.reserveBook();
            }
            else if(viewDirective.equalsIgnoreCase(BACK_COMMAND))
                break;
            else if(viewDirective.equalsIgnoreCase(EXIT_COMMAND)){
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
}