<%-- 
    Document   : admin
    Created on : May 28, 2024, 9:05:17 AM
    Author     : KuroZabulus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="sample.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER== null || sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <h1>Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>
        <c:url value="LogoutLink" var="MainController">
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        <a href="${LogoutLink}">Logout JSTL</a>
        <form action="MainController" method="POST">
            Search:<input type="text" name="search" value="${param.search}"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <c:if test="${requestScope.LIST_USER != null}">
            <c:if test="${not empty requestScope. LIST_USER}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>User ID</th>
                            <th>Full Name</th>
                            <th>Role ID</th>
                            <th>Password</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${requestScope.LIST_USER}" varStatus="counter">
                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td><input type="text" name="userID" value="${user.userID}"/></td>
                                <td><input type="text" name="fullName" value="${user.fullName}" required=""/></td>
                                <td><input type="text" name="roleID" value="${user.roleID}" required=""/></td>
                                <td>${user.password}</td>
                                <td>
                                    <input type="submit" name="action" value="Update"/>
                                    <input type="hidden" name="search" value="${param.search}"/>
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="Delete"></c:param>
                                        <c:param name="userID" value="${user.userID}"></c:param>
                                        <c:param name="search" value="${param.search}"></c:param>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        ${requestScope.ERROR}
    </c:if>
</c:if>
</body>
</html>
