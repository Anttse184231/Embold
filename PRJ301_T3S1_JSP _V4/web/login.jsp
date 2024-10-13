<%-- 
    Document   : login
    Created on : Jan 24, 2024, 5:13:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Login Page</title>
    </head>
    <body>
        <div id="container">
            <h1>Login Information</h1>
            <div>
                <form action="MainController" method="POST">
                    User ID<input type="text" name="userID"/></br>
                    Password<input type="password" name="password"/></br>
                    <input type="submit" name="action" value="Login"/>
                    <input type="reset" name="Reset" value="Reset"/>
                </form>
            </div>
            <a href="MainController?action=Create_Page">create account</a>
            <a href="MainController?action=Shopping_Page">Shopping</a>
        </div>

        </br>
        ${requestScope.ERROR}  
    </body>
</html>
