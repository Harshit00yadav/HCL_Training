package assignment4.Q3;

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

        // 🔹 Update query (5% increase for CSE students)
        int affected = st.executeUpdate(
                "UPDATE Student SET percentage = percentage + (percentage * 0.05) WHERE branch='CSE'");

        System.out.println(affected + " records updated");

        // 🔹 Display updated records
        rs = st.executeQuery("SELECT * FROM Student");

        while (rs.next()) {
            System.out.print(" "+rs.getString("name"));
            System.out.print(" "+rs.getInt("roll_no"));
            System.out.print(" "+rs.getString("dob"));
            System.out.print(" "+rs.getDouble("email"));
            System.out.println();
        }

        conn.close();
    }
}
