package assignment1.Q5;

public class Acc{
	private double balance;
	private String name;
	private String dob;
	private String phone;
	private String email;
	private String password;
	private String uid;
	public Acc(String name, String dob, String phone, String email, String password){
		this.balance = 0.1;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public void setUID(String uid){
		this.uid = uid;
	}
	public String getUID(){
		return this.uid;
	}
	public String getPass(){
		return this.password;
	}
	public String getName(){
		return this.name;
	}
	public String getDOB(){
		return this.dob;
	}
	public String getPhone(){
		return this.phone;
	}
	public String getEmail(){
		return this.email;
	}
	public void setBalance(double amount){
		this.balance = amount;
	}
	public double getBalance(){
		return this.balance;
	}
}
