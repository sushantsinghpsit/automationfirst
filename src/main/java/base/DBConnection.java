package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DBConnection {
    
    private static Connection connection;
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        try {
            // Change these according to your setup
            String url = "jdbc:mysql://localhost:3306/testdb"; 
            String username = "root"; 
            String password = "Moonlight?2";
            // Initialize connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
 // Fetch Product From Database
    

    	public static List<String> getProducts() {

            List<String> products =
                    new ArrayList<>();

        try {

            Connection con = getConnection();

            Statement stmt =
            con.createStatement();

            ResultSet rs =
            stmt.executeQuery(
            "SELECT productname FROM product;");


            while (rs.next()) {

                String product =
                        rs.getString("productname");

                products.add(product);

                System.out.println(product);
            }
                   //rs.close();
        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return products;
    }
    	

    public static void closeConnection() {
        try {
            if (connection != null) {
            	
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
