package assignment1.Q5;

import assignment1.Q5.Acc;
import java.util.Scanner;

/*
		┌─┬─┐
		│ │ │
		└─┴─┘
*/
public class Dashboard{
	private Acc account;
	private String menu[] = {"View Balance", "Deposit", "Withdraw", "Account Details", "Logout"};
	public Dashboard(Acc acc){
		this.account = acc;
	}
	public void start(){
		Scanner sc = new Scanner(System.in);
		boolean LOGOUT = false;
		while(!LOGOUT){
			System.out.println("__________DASHBOARD_________\n");
			System.out.printf("welcome %s\n", this.account.getName());
			for (int i=0; i<menu.length; i++){
				System.out.printf("\t%d: %s\n", i+1, menu[i]);
			}
			System.out.print(">>> ");
			String inp = sc.nextLine();
			cursorup(4 + menu.length);
			int choice = 0;
			try{
				choice = Integer.parseInt(inp);
				choice--;
				if (choice<0 || choice >= menu.length){
					throw new Exception();
				}
			} catch (Exception e){
				System.out.println("Invalid Input");
				try{Thread.sleep(1000);}catch(Exception e1){System.out.println("Can't sleep");}
				continue;
			}
			switch(menu[choice]){
				case "View Balance":
					this.vbalance(sc);
					break;
				case "Deposit":
					this.deposit(sc);
					break;
				case "Logout":
					LOGOUT = true;
					break;
				case "Withdraw":
					this.withdraw(sc);
					break;
				case "Account Details":
					this.accdet(sc);
					break;
			}
		}
	}

	private void accdet(Scanner sc){
		System.out.printf("User ID  : %s\n", this.account.getUID());
		System.out.printf("Name     : %s\n", this.account.getName());
		System.out.printf("DOB      : %s\n", this.account.getDOB());
		System.out.printf("Phone No.: %s\n", this.account.getPhone());
		System.out.printf("Email ID : %s\n", this.account.getEmail());
		System.out.print("[Press ENTER]");
		sc.nextLine();
		cursorup(6);
	}

	private void vbalance(Scanner sc){
		System.out.printf("Balance: %f $\n", this.account.getBalance());
		System.out.print("[Press ENTER]");
		sc.nextLine();
		cursorup(2);
	}

	private void deposit(Scanner sc){
		System.out.print("Deposit Amount: ");
		try{
			double amount = Double.parseDouble(sc.nextLine());
			this.account.setBalance(this.account.getBalance() + amount);
			System.out.println("Deposit Successful!!");
		} catch (Exception e){
			System.out.println("Invalid amount!");
		}
		try{Thread.sleep(1000);}catch(Exception e){System.out.println("Can't sleep");}
		cursorup(2);
	}

	private void withdraw(Scanner sc){
		System.out.print("Withdraw Amount: ");
		try{
			double amount = Double.parseDouble(sc.nextLine());
			amount = this.account.getBalance() - amount;
			if (amount < 0){
				System.out.println("Insufficient Funds");
			} else {
				this.account.setBalance(amount);
				System.out.println("Withdraw Successful!!");
			}
		} catch (Exception e){
			System.out.println("Invalid amount!");
		}
		try{Thread.sleep(1000);}catch(Exception e){System.out.println("Can't sleep");}
		cursorup(2);
	}

	private void cursorup(int n){
		for (int i=0; i<n; i++){
			System.out.print("\033[A\033[2K\r");
		}
	}
}
