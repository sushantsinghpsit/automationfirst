package testpages;


import base.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Testdbconnection {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  name FROM employee;");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            DBConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
}}}