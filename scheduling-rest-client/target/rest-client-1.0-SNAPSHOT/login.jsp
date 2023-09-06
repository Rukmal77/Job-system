<%-- 
    Document   : login
    Created on : Aug 23, 2023, 8:26:15 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <script>
        function login() {
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const credentials = {
                email: email,
                password: password
            };

           
            fetch('http://localhost:8080/scheduling-rest-service/api/login/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(credentials)
            })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error('Login failed');
                }
            })
            .then(token => {
    const parsedToken = token.split('|');
    const receivedToken = parsedToken[0];
    const userType = parsedToken[1];

    localStorage.setItem('token', receivedToken);

    if (userType === 'job_seekers') {
        window.location.href = `jobseekerdashboard.html?token=${receivedToken}`;
    } else if (userType === 'consultant') {
        window.location.href = `consultantdashboard.html?token=${receivedToken}`;
    } else if (userType === 'admin') {
        window.location.href = `admindashboard.html?token=${receivedToken}`;
    } else {
        console.error('Unknown user type:', userType);
    }
})
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('message').innerHTML = 'Invalid credentials.';
            });
        }
    </script>
    <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <style>
  body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-color: black;
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
  }

  .container {
    text-align: center;
    padding: 100px;
    background-color: #fff;
    border-radius: 30px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    
  }

  h2 {
    font-size: 1.8rem;
    margin-bottom: 20px;
  }

  form {
    text-align: left;
  }

  label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
  }

  input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }

  button {
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  button:hover {
    background-color: #0056b3;
  }
</style>


</head>
<body>
  <div class="container">
    <h2>Login</h2>
    <form id="loginForm">
      <label for="email">Email</label>
      <input type="text" id="email" name="email"><br><br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password"><br><br>
      <button type="button" onclick="login()">Login</button>
      <a href="Home.html" onclick="goBack()">Back</a>
    </form>
    
  </div>

  
</body>
</html>

