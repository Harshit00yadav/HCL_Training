package assignment4.Q4;

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

        // 🔹 Delete students whose branch is Civil and year_of_passing is 2024
        int affected = st.executeUpdate(
                "DELETE FROM Student WHERE branch='Civil' AND year_of_passing=2024");

        System.out.println(affected + " records deleted");

        // 🔹 Display remaining records
        rs = st.executeQuery("SELECT * FROM Student");

        while (rs.next()) {
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Roll No: " + rs.getInt("roll_no"));
            System.out.println("Branch: " + rs.getString("branch"));
            System.out.println("Year of Passing: " + rs.getInt("year_of_passing"));
            System.out.println(" ");
        }

        conn.close();
    }
}
