package assignment1.Q1;

import java.util.Scanner;
import java.util.InputMismatchException;

public final class Square{
	private Square(){
	}

	public static double sqr(double a){
		return Math.pow(a, 2);
	}

	public static void input_handle(Scanner sc){
		try{
			System.out.println();
			System.out.print("\033[1A\r\033[2K");
			System.out.print("num: ");
			Double n = sc.nextDouble();
			System.out.print("\033[1A\r\033[2K");
			System.out.println("[ result ]: "+n+"² = "+sqr(n));
		} catch (InputMismatchException e){
			System.out.println("Invalid Input!");
		}
	}
}
