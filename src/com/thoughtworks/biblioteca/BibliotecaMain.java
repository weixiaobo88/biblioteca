package com.thoughtworks.biblioteca;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaMain{

    public static void main(String[] args) throws IOException {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.startMessage();
        biblioteca.bookInitial();

        String selectedOption;
        String selectedBookId;

        while (true){

            biblioteca.startMenuOption();
            selectedOption = Util.bufferedReader.readLine();

            if(selectedOption != null)
            {
                if(selectedOption.equals("a") || selectedOption.equals("b"))
                {
                    biblioteca.bookView();
                    selectedBookId = Util.bufferedReader.readLine();
                    biblioteca.bookReserve(selectedBookId);
                }
                else if(selectedOption.equals("c"))
                {
                    biblioteca.checkLibraryNumber();
                }
                else if(selectedOption.equals("d"))
                {
                    Util.bufferedReader.close();
                    break;
                }
            }
        }
        System.out.println();

    }

}
