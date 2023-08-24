/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import static db.TokenUtils.DB_URL;
import static db.TokenUtils.PASS;
import static db.TokenUtils.USER;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidateToken extends HttpServlet {
    
     static final String DB_URL = "jdbc:mysql://localhost:3306/appointmentscheduling?useSSL=false";
    static final String USER = "root";
    static final String PASS = "#rukmal1114#";
    
    
        public static Token validateTokenAndGetEmail(String token) {
        Token tokenObject = null;
       
    // Assuming you have a database connection setup
    try  {
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement statement = conn.prepareStatement(
                 "SELECT email, userid FROM login WHERE token = ?");
        statement.setString(1, token);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String email = resultSet.getString("email");
            int userid = resultSet.getInt("userid");
            tokenObject = new Token(email, userid);
            System.out.println("Retrieved email and id from database: " + email + " | " + userid); // Debugging statement
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tokenObject;
    }
}
