<%-- 
    Document   : user
    Created on : Jan 24, 2024, 5:09:05 PM
    Author     : Admin
--%>

<%@page import="sample.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        
    </head>
    <body>  
        <h1>User information:</h1>
        <c:if test= ${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        User ID:${sessionScope.LOGIN_USER.userID}
        </br>Password:<b class="red">${sessionScope.LOGIN_USER.password}</b>
        </br>Role ID:${sessionScope.LOGIN_USER.roleID}
        </br>Full name:${sessionScope.LOGIN_USER.fullName}
        </br></br>
        
        <a href="MainController?action=MainController">Go Back</a>
        
        </br></br>
    </body>
</html>
