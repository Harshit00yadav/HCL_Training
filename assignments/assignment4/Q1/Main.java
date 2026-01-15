package assignment4.Q1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {

        // Database credentials
        String url = "jdbc:mariadb://localhost:3306/JDBC_Demo";
        String username = "root";
        String password = "radheradhe";

        Connection con = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Step 2: Establish connection
            con = DriverManager.getConnection(url, username, password);

            // Step 3: Check connection
            if (con != null) {
                System.out.println("Connection Successful");
            }

        } catch (Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}
