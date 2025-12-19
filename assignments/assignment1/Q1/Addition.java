package assignment1.Q1;

import java.util.Scanner;
import java.util.InputMismatchException;

public final class Addition{
	private Addition(){
	}

	public static double add(double a, double b){
		return a+b;
	}

	public static void input_handle(Scanner sc){
		try{
			System.out.println();
			System.out.print("\033[1A\r\033[2K");
			System.out.print("num1: ");
			Double n1 = sc.nextDouble();
			System.out.print("\033[1A\r\033[2K");
			System.out.printf("num2: ");
			Double n2 = sc.nextDouble();
			System.out.print("\033[1A\r\033[2K");
			System.out.println("[ result ]: "+n1+" + "+n2+" = "+add(n1, n2));
		} catch (InputMismatchException e){
			System.out.println("Invalid Input!");
		}
	}
}
