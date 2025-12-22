package assignment2.Q1;

interface User {
	public boolean login(String username, String password);
	public boolean logout();
}

interface Count {
	int count = 0;
	default void usefunc(){
		func();
	}
	private void func(){
		System.out.println("This is func");
	}
}

class BankAccount implements User, Count{
	BankAccount(){
		System.out.println("Count: "+count);
	}
	public boolean login(String username, String password){
		System.out.println("Wellcome "+username);
		return true;
	}
	public boolean logout(){
		System.out.println("Logged out");
		return true;
	}
}

public class Main{
	public static void main(String[] args){
		System.out.println("Question >> Design a Java program where a bank account class implements multiple interfaces to perform banking and customer-related operations. The program should handle exceptions as required");
		BankAccount u1 = new BankAccount();
		BankAccount u2 = new BankAccount();
		u1.login("kalu", "don1");
		u2.logout();
		u1.usefunc();
	}
}
