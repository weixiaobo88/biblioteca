package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testWhile {

	/**
	 * @param args
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String menuOption = "1.aaa\\n2.bbb\\n3.ccc\\n4.exit";
		boolean flag = true;
		
		System.out.println("welcome ~");
		System.out.println(menuOption);
		
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String getInput;
        
		while(flag)
		{
			getInput = bufferedReader.readLine().toString();
			if("exit".equals(getInput))
				System.exit(0);
			else if("aaa".equals(getInput))
			{
				System.out.println("welcome ~   all menu");
				System.out.println(menuOption);
			}
			else if("bbb".equals(getInput))
			{
				System.out.println("welcome ~   bbb");
			}
			else if("ccc".equals(getInput))
			{
				System.out.println("welcome ~   ccc");
			}
		}
		
	}

}
