package assignment2.Q4;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Scanner;

interface stu{
	public void setDetails(String name, String email, String dob);
	public void getDetails();
}

class Main implements stu{
	private String name;
	private String email;
	private String dob;
	public Main(String name, String email, String dob){
		this.setDetails(name, email, dob);
	}
	public void setDetails(String name, String email, String dob){
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	public void getDetails(){
		System.out.printf("name: %s\n", this.name);
		System.out.printf("email: %s\n", this.email);
		System.out.printf("dob: %s\n", this.dob);
	}
	public static void main(String[] args){
		Map<Integer, Main> records = new HashMap<Integer, Main>();
		records.put(1, new Main("Harshit Yadav", "hash00usr@gmail.com", "09-04-2003"));
		records.put(2, new Main("Aviral andu", "anduaviral@facebook.com", "01-03-2005"));

		Vector<String> mmenu = new Vector<String>();
		mmenu.add("Add record");
		mmenu.add("Display all students");
		mmenu.add("Remove student");
		mmenu.add("Search student");
		mmenu.add("EXIT");
		Scanner sc = new Scanner(System.in);
		boolean EXIT = false;
		while (!EXIT){
			for (int i=0; i<mmenu.size(); i++){
				System.out.printf("\t%d. %s\n", i+1, mmenu.get(i));
			}
			System.out.print(">>>");
			String inp = sc.nextLine();
			if (inp.matches("[0-9]")){
				int indx = Integer.parseInt(inp) - 1;
				switch(mmenu.get(indx)){
					case "Display all students":
					for (Main m:records.values()){
						System.out.printf("%s\n", m.name);
					}
					break;

					case "Add record":
					System.out.print("Enter roll number: ");
					String temp = sc.nextLine();
					if (!temp.matches("[0-9]+")){
						System.out.println("Invalid rollnumber");
						break;
					}
					int roll = Integer.parseInt(temp);
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					if (!email.matches("[a-zA-Z0-9_.]+@[a-zA-Z0-9._]+[.][a-zA-Z0-9]+")){
						System.out.println("Invalid email format, use (example_21@email.com)");
						break;
					}
					System.out.print("Enter dob: ");
					String dob = sc.nextLine();
					if (!dob.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")){
						System.out.println("Invalid date format. use (dd-mm-yyyy). data not added");
						break;
					}
					records.put(roll, new Main(name, email, dob));
					System.out.println("Added successfully");
					break;

					case "Remove student":
					System.out.print("Enter roll number: ");
					String temp_ = sc.nextLine();
					if (!temp_.matches("[0-9]+")){
						System.out.println("Invalid rollnumber");
						break;
					}
					int roll_ = Integer.parseInt(temp_);
					if (records.containsKey(roll_)){
						records.remove(roll_);
						System.out.println("Record removed");
					} else {
						System.out.println("Record not found");
					}
					break;

					case "Search student":
					System.out.print("Enter roll number: ");
					String temp__ = sc.nextLine();
					if (!temp__.matches("[0-9]+")){
						System.out.println("Invalid rollnumber");
						break;
					}
					int roll__ = Integer.parseInt(temp__);
					if (records.containsKey(roll__)){
						records.get(roll__).getDetails();
					} else {
						System.out.println("Record not found");
					}
					break;

					case "EXIT":
					EXIT = true;
					break;

					default:
					System.out.println("Invalid input");
				}
			} else {
				System.out.println("Invalid input");
			}
		}
		sc.close();
	}
}
