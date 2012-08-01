package com.thoughtworks.biblioteca;

public class CheckLibraryNumber implements Command{

    public static final String PLEASE_TALK_TO_LIBRARIAN_THANK_YOU = "Please talk to Librarian. Thank you.";

    public String execute() {
        return PLEASE_TALK_TO_LIBRARIAN_THANK_YOU;
    }
}