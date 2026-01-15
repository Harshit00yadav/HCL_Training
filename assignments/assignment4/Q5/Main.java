package assignment4.Q5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/JDBC_Demo", "root", "radheradhe");

        st = conn.createStatement();

        // 🔹 Select students whose semester is 7 and branch is EC
        rs = st.executeQuery("SELECT * FROM Student WHERE semester=7 AND branch='EC'");

        // 🔹 Display records
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("stu_name"));
            System.out.println("Roll No: " + rs.getInt("roll_no"));
            System.out.println("Branch: " + rs.getString("branch"));
            System.out.println("Semester: " + rs.getInt("semester"));
            System.out.println("Percentage: " + rs.getDouble("percentage"));
            System.out.println("-------------------");
        }

        conn.close();
    }
}
