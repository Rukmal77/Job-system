/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DashboardUtils extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    String token = (String) session.getAttribute("token");

    if (token != null) {
        TokenUtils tokenUtils = new TokenUtils();
        Token tokenObject = tokenUtils.validateToken(token);

        if (tokenObject != null) {
            // User is authenticated, serve the dashboard
            Login login = tokenObject.getLogin();
            // Your code to render the dashboard content goes here
            response.getWriter().println("Welcome, " + login.getEmail() + "! This is your dashboard.");
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login page if token is invalid
        }
    } else {
        response.sendRedirect("login.jsp"); // Redirect to login page if no token is present
    }
}
}
