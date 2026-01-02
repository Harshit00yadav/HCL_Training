package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class JDBC_demo{
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/JDBC_Demo";
	private static final String USER = "root";
	private static final String PASS = "radheradhe";
	private static final String insert_query = "insert into Student (name, email) values (?, ?)";
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
			PreparedStatement pstmt = conn.prepareStatement(insert_query);
			System.out.println("Connection successfull!!!");
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			System.out.print("Enter email: ");
			String email = sc.nextLine();
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			int res = pstmt.executeUpdate();
			System.out.println(res + " row(s) inserted");
			
			PreparedStatement ps = conn.prepareStatement("select roll_no, name, email from Student");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.printf("roll_no: %d, name: %s, email: %s\n", rs.getInt("roll_no"), rs.getString("name"), rs.getString("email"));
			}
			conn.close();
		} catch (SQLException e){
			System.err.println("Database connection failed: ");
			e.printStackTrace();
		}	finally {
			sc.close();
		}
	}
}
