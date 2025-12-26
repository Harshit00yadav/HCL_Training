package assignment2.Q2;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String menu[] = {
			"Validate Mobile Number",
			"Validate Email ID",
			"Validate Username",
			"Validate Password",
		};
		for (int i=1; i<=menu.length; i++){
			System.out.printf("\t%d. %s\n", i, menu[i-1]);
		}
		try{
			System.out.print(">>>");
			int choise = Integer.parseInt(reader.readLine());
			switch(choise){
				case 1:
					System.out.print("Enter phone number: ");
					String number = reader.readLine();
					if (Pattern.matches("([+]?[0-9]{1,3}[- ]?)?[0-9]{10}", number)){
						System.out.println("Valid number");
					} else {
						System.out.println("Invalid number");
					}
					break;
				case 2:
					System.out.print("Enter email id: ");
					String id = reader.readLine();
					if (Pattern.matches("[0-9a-zA-Z.]+@[0-9a-zA-Z.]+[.][0-9a-zA-Z.]+", id)){
						System.out.println("Valid email");
					} else {
						System.out.println("Invalid email");
					}
					break;
				case 3:
					System.out.print("Enter Username: ");
					String username = reader.readLine();
					if (Pattern.matches("^[a-zA-Z0-9-_@#$%^&!*]{1,25}", username)){
						System.out.println("Valid Username");
					} else {
						System.out.println("Invalid Username");
					}
					break;
				case 4:
					System.out.print("Enter Password: ");
					String passwd = reader.readLine();
					if (Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{6,}", passwd)){
						System.out.println("Valid password");
					} else {
						System.out.println("Invalid password. Include uppercase, lowercase, numbers and specialcharacters with minimum length 6");
					}
					break;
				default:
				System.out.println("Invalid option selected");
			}
		} catch (IOException e){
			System.out.println(e);
		}
	}
}
