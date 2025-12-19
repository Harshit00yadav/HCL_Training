package assignment1.Q2;

import java.util.Scanner;
import assignment1.Q2.*;


public class Main{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Question >> Write a menu driven program in Java to perform insertion, deletion, linear search, binary search, to find maximum value, to count even/odd and to perform insertion sort operation in one dimensional array.\n\n");
		Menu menu = new Menu();
		boolean EXIT = false;
		while (!EXIT){
			menu.display();
			EXIT = menu.choose(takeInput());
		}
	}
	private static int takeInput(){
		System.out.printf(">>> ");
		String inp = sc.nextLine();
		try{
			int choise = Integer.parseInt(inp);
			return choise;
		} catch (Exception e){
			return 0;
		}
	}
	private static void alert(String msg){
		System.out.println(msg);
	}
}
