package assignment1.Q5;

import java.util.Scanner;
import assignment1.Q5.Acc;

final public class Signup{
	private Signup(){}
	public static Acc displayPage(){
		Scanner signupsc = new Scanner(System.in);
		System.out.printf("┌──────────────────BANK─────────────────┐\n");
		System.out.printf("│Name       :                           │\n");
		System.out.printf("│DOB        :                           │\n");
		System.out.printf("│Phone no.  :                           │\n");
		System.out.printf("│email id   :                           │\n");
		System.out.printf("│Password   :                           │\n");
		System.out.printf("└───────────────────────────────────────┘\n");
		System.out.printf("\033[6A\033[14C"); // move cursor infront of Name:
		String name = signupsc.nextLine();
		System.out.printf("\033[14C"); // move cursor infront of DOB		
		String dob = signupsc.nextLine();
		System.out.printf("\033[14C"); // move cursor infront of phone no		
		String phone = signupsc.nextLine();
		System.out.printf("\033[14C"); // move cursor infront of email id
		String email = signupsc.nextLine();
		System.out.printf("\033[14C"); // move cursor infront of password
		String password = signupsc.nextLine();
		System.out.println();
		return new Acc(name, dob, phone, email, password);
	}
}
