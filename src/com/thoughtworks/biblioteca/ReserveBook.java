package com.thoughtworks.biblioteca;

public class ReserveBook implements Command{
    private MenuOption menuOption;
    private InputStream inputStream = new InputStream();
    Bookshelf bookshelf = new Bookshelf();


    public String execute() {
        boolean flag = true;
        bookshelf.bookListString();
        printReserveExtraDirective();

        String reserveBookId = inputStream.inputString();
        while (flag) {
            if (MenuOption.BACK_COMMAND.equals(reserveBookId))
                break;
            else if (MenuOption.EXIT_COMMAND.equals(reserveBookId)) {
                inputStream = null;
                System.out.println("ByeBye~!");
                System.exit(1);
            } else if (!menuOption.isNum(reserveBookId))
                System.out.println("Please input the correct order or the book id");
            else if (!menuOption.ifSelectedOptionIsValid(Integer.valueOf(reserveBookId))) {
                System.out.println("Please input the correct id .");
            } else if (bookshelf.reserve(Integer.valueOf(reserveBookId)))
                System.out.println("Thank You! Enjoy the book.");
            else {
                System.out.println("Sorry we don't have that book yet.");
            }

            printReserveExtraDirective();
            reserveBookId = inputStream.inputString();
        }
        return "";
    }


    public void printReserveExtraDirective()
    {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("back-> back to the main menu");
        System.out.println("exit-> exit the system");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("--Please input the id of the book to reserve, or 'back',or 'exit'");
    }

}