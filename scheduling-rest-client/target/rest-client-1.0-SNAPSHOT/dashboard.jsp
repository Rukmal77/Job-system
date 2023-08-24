<%-- 
    Document   : dashboard
    Created on : Aug 24, 2023, 6:59:25 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <script>
        
        // Retrieve the token from local storage
        const token = localStorage.getItem('token');
        
         console.log('Token:', token);  

        if (token) {
            // Send a request to validate the token and get user email
            fetch('http://localhost:8080/sessionhandling-rest-service/api/validateToken', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                }
            })
            .then(response => {
    if (response.ok) {
        return response.json(); // Parse the JSON response
    } else {
        throw new Error('Token validation failed');
    }
})
.then(data => {
    const welcomeMessage = document.getElementById('welcomeMessage');
     const email = data.email;
     const id = data.id; // Retrieve the ID from the response

     welcomeMessage.textContent = `Welcome, ${email} (ID: ${id})! This is your dashboard.`;
})
            .catch(error => {
                console.error('Error:', error);
                // Handle error or redirect to login page
            window.location.href = 'login.jsp';
            console.log('wrong token');  
            });
        } else {
            // Redirect to login page if token is not present
           window.location.href = 'login.jsp';
           console.log('token  is not present'); 
        }
    </script>
</head>
<body>
   <h1>User Dashboard</h1>
    <!-- Use an element with an ID to display the welcome message -->
    <p id="welcomeMessage">Welcome, this is your dashboard.</p>
    <!-- Your dashboard content goes here -->
    <a href="logout">Logout</a>
</body>
</html>

