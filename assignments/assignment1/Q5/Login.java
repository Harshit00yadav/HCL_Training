package assignment1.Q5;

import java.util.Scanner;
import java.util.Map;
import assignment1.Q5.Acc;

final public class Login{
	private Login(){}
	public static String displayPage(Map<String, Acc> DB){
		Scanner loginsc = new Scanner(System.in);
		System.out.printf("┌──────────────────BANK─────────────────┐\n");
		System.out.printf("│Account No.:                           │\n");
		System.out.printf("│password   :                           │\n");
		System.out.printf("└───────────────────────────────────────┘\n");
		System.out.printf("\033[3A\033[14C"); // move cursor infront of Account no.:
		String accNo = loginsc.nextLine();
		System.out.printf("\033[14C"); // move cursor infront of password		
		String password = loginsc.nextLine();
		System.out.println();
		if (DB.containsKey(accNo) && DB.get(accNo).getPass().equals(password)){
			return accNo;
		}
		return "";
	}
}
