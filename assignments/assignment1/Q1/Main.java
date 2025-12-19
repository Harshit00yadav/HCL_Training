package assignment1.Q1;

import java.util.Scanner;
import assignment1.Q1.*;

public class Main{
	public static void main(String[] args){
		System.out.println("Question>> class sixth student required to solve basic mathematics problems. For this he/she needs to perform operations such as addition, subtraction, multiplication, division, remainder, square, cube, and absolute. Write a program using methods to perform these basic operations");
		String[] options = {
			"Addition",
			"Subtraction",
			"Multiplicaiton",
			"division",
			"remainder",
			"square",
			"cube",
			"absolute"
		};
		System.out.println();
		for (int i=0; i<options.length; i++) {
			System.out.printf("\t%d) %s\n", i+1, options[i]);
		}
		System.out.println();
		System.out.printf("Choose[1-%d]: ", options.length);
		Scanner sc = new Scanner(System.in);
		int userinput = sc.nextInt();
		switch(userinput){
			case 1:
			Addition.input_handle(sc);
			break;
			case 2:
			Substraction.input_handle(sc);
			break;
			case 3:
			Multiplication.input_handle(sc);
			break;
			case 4:
			Division.input_handle(sc);
			break;
			case 5:
			Remainder.input_handle(sc);
			break;
			case 6:
			Square.input_handle(sc);
			break;
			case 7:
			Cube.input_handle(sc);
			break;
			case 8:
			Absolute.input_handle(sc);
			break;
			default:
			System.out.println("Invalid Input!");
		}
	}
}
