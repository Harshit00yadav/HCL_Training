package assignment2.Q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Scanner;

interface stu{
	public void setDetails(int roll, String name, String email, String dob);
	public void getDetails();
}

class Main implements stu{
	private int roll;
	private String name;
	private String email;
	private String dob;
	public Main(int roll, String name, String email, String dob){
		this.setDetails(roll, name, email, dob);
	}
	public void setDetails(int roll, String name, String email, String dob){
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	public void getDetails(){
		System.out.printf("roll_no: %d\n", this.roll);
		System.out.printf("name: %s\n", this.name);
		System.out.printf("email: %s\n", this.email);
		System.out.printf("dob: %s\n", this.dob);
	}
	public static void main(String[] args){
		List<Main> records = new ArrayList<Main>();
		records.add(new Main(1, "Harshit Yadav", "hash00usr@gmail.com", "09-04-2003"));
		records.add(new Main(2, "Aviral Andu", "Aandviral@gmail.com", "01-02-2005"));

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
					for (Main m:records){
						System.out.printf("%d. %s\n", m.roll, m.name);
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
					records.add(new Main(roll, name, email, dob));
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
					boolean found = false;
					Main pointer = null;
					for(Main m:records){
						if (m.roll == roll_){
							found = true;
							pointer = m;
						}
					}
					if (found){
						records.remove(pointer);
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
					boolean found_ = false;
					Main pointer_ = null;
					for(Main m:records){
						if (m.roll == roll__){
							found_ = true;
							pointer_ = m;
						}
					}
					if (found_){
						pointer_.getDetails();
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
