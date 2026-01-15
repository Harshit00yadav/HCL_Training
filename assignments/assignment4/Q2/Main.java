package assignment4.Q2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		ResultSet rs=null;
		Statement st=null;
		Class.forName("org.mariadb.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/JDBC_Demo","root","radheradhe");
		st=conn.createStatement();
		rs=st.executeQuery("Select * from Student");
		while(rs.next()) {
			System.out.print(" "+rs.getString("name"));
			System.out.print(" "+rs.getInt("roll_no"));
			System.out.println(" "+rs.getString("email"));
		}
		String query="Insert into Student (roll_no, name, email) values(5, 'Aniket','Annni@gmail.com')";
		int n=st.executeUpdate(query);
		rs=st.executeQuery("Select * from Student");
		while(rs.next()) {
			System.out.print(" "+rs.getString("name"));
			System.out.print(" "+rs.getInt("roll_no"));
			System.out.println(" "+rs.getString("email"));
		}

		System.out.println("after deletion");
		
		int affect=st.executeUpdate("Update Student set email='hidden@hide.email' where roll_no= 1");
		st.executeUpdate("Delete from Student where roll_no = 5 ");
		rs=st.executeQuery("Select * from Student");
		while(rs.next()) {
			System.out.print(" "+rs.getString("name"));
			System.out.print(" "+rs.getInt("roll_no"));
			System.out.println(" "+rs.getString("email"));
		}
     
	}

}
