<%-- 
    Document   : product.jsp
    Created on : Jun 21, 2024, 9:14:57 AM
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dtos.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <h1>Products</h1>
        <%
            List<ProductDTO> productList = (List<ProductDTO>) request.getAttribute("PRODUCT_LIST");
            if (productList != null && !productList.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (ProductDTO product : productList) {
                %>
                <tr>
                    <td><%= product.getProductID() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            } else {
        %>
        <p>No products found.</p>
        <%
            }
        %>
        <a href="shopping.html">Back to Shopping</a>
        <a href="MainController?action=View_Products">View Products</a>
    </body>
</html>
