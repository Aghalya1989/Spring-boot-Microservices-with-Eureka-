package com.javainterview.questions;

import java.io.IOException;

//Compile time error ClassDefFoundNotError
//Run time Exception ClassNotFoundException
//Exception :Handle the exception to make the program to run normally
//Checked Exception to be handled by TryCatch or Throws
//We can manually throw error
public class ExceptionDemo {

	public static void main(String[] args) {
		ExceptionDemo e = new ExceptionDemo();
		try {
			System.out.println("I am handled");
			
		    int	i=10/0;
			System.out.println("I am handled");
			
		} catch (ArithmeticException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.send();
		
	}

	public void send() {
		 //throw new Error();
	System.out.println("I am in send");
	}

}
