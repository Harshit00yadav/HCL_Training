package assignment1.Q5;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import assignment1.Q5.*;

public class Main{
	private static String logins[] = {"Login", "Sign-Up", "EXIT"};
	private static String menu[] = logins;
	private static Map<String, Acc> DB = new HashMap<>();
	private static long ID = 0L;
	public static String banner = "Welcome to Insecure Bank!";
	public static void main(String[] args){
		DB.put("USR"+(ID++), new Acc("TestUser", "09-04-2003", "+91 2934812938", "testmail@email.com", "Default"));
		DB.get("USR0").setUID("USR0");
		Scanner sc = new Scanner(System.in);
		System.out.println("Question >> Design a console-based Bank Management Program in Java that allows a user to create a bank account and perform basic banking operations such as deposit, withdrawal, balance enquiry, and account details display. The program should handle exceptions as required");
		boolean EXIT = false;
		System.out.println();
		while(!EXIT){
			System.out.printf("\n%s\n", banner);
			for (int i=0; i<menu.length; i++){
				System.out.printf("\t%d: %s\n", i+1, menu[i]);
			}
			System.out.print(">>> ");
			int choice=0;
			try{
				choice = Integer.parseInt(sc.nextLine());
				choice--;
				if (choice <0 || choice >= menu.length){
					throw new Exception();
				}
				cursorup(menu.length + 3);
			} catch (Exception e){
				cursorup(menu.length + 3);
				try{
					System.out.println("Invalid Input!");
					Thread.sleep(1000);
					cursorup(1);
				} catch (Exception e1){
					System.out.println("Can't sleep");
				}
				continue;
			}
			switch(menu[choice]){
				case "Login":
					String res = Login.displayPage(DB);
					cursorup(4);
					if (!res.equals("")){
						Dashboard dashboard = new Dashboard(DB.get(res));
						dashboard.start();
					} else {
						System.out.println("Failed!");
						try{Thread.sleep(1000);}catch(Exception e){System.out.println("Can't sleep");}
						cursorup(1);
					}
					break;
				case "Sign-Up":
					String uid = "USR"+(ID++);
					DB.put(uid, Signup.displayPage());
					DB.get(uid).setUID(uid);
					cursorup(7);
					System.out.printf("User created: %s\n[press ENTER to continue]\n", uid);
					sc.nextLine();
					cursorup(3);
					break;
				case "EXIT":
					EXIT = true;
					break;
				default:
					try{
						System.out.println("Invalid index!");
						Thread.sleep(1000);
						cursorup(1);
					} catch (Exception e){
						System.out.println("Can't sleep");
					}
			}
		}
	}
	private static void cursorup(int n){
		// moves cursor up and clear the current line
		for (int i=0; i<n; i++){
			System.out.print("\033[A\033[2K\r");
		}
	}
}
