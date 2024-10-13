<%-- 
    Document   : create
    Created on : Jun 11, 2024, 7:45:44 AM
    Author     : Admin
--%>

<%@page import="sample.users.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Create User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <div>Input user info</div>
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required="">${requestScope.USER_ERROR.userIDError}
            </br> Full Name <input type="text" name="fullname" required="">${requestScope.USER_ERROR.fullNameError}
            </br> Role ID <input type="text" name="roleID" value="US" readonly="">
            </br> Password <input type="password" name="password" required="">
            </br> Confirm <input type="password" name="confirm" required="">${requestScope.USER_ERROR.confirmError}
            </br> <input type="submit" name="action" value="Create">
            </br> <input type="reset" value="Reset">
        </form>
            ${requestScope.USER_ERROR.error}
    </body>
</html>
