package main;

import java.util.Scanner;

public class UI {

	public void start() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a url: ");
		
		Constants.url = input.nextLine();
		
		System.out.println("video loaded");
	}
	
	
}
