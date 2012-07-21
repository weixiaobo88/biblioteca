package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/14/12
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputStream {

    public static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    public static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

}

