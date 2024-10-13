<%-- 
    Document   : viewCart
    Created on : Jun 14, 2024, 8:33:59 AM
    Author     : ADMIN
--%>

<%@page import="sample.shopping.Cart"%>
<%@page import="sample.shopping.Clothes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diep Store</title>
    </head>
    <body>
        <h1>Your shopping cart</h1>
        <%
            Cart cart = (Cart)session.getAttribute("CART");
            if(cart!= null){
                
         %>
         <table border="1">
             <thead>
                 <tr>
                     <th>No</th>
                     <th>ID</th>
                     <th>Name</th>
                     <th>Quantity</th>
                     <th>Price</th>
                     <th>Total</th>
                     <th>Edit</th>
                    <th>Remove</th>
                 </tr>
             </thead>
             <tbody>
                 <%
                     int count = 1;
                     double total =0;
                     for(Clothes clothes : cart.getCart().values()){
                         total+=clothes.getPrice()*clothes.getQuantity();
                 %>        
                 <tr>
                     <td><%= count++ %></td>
                     <td><%= clothes.getId()%></td>
                     <td><%= clothes.getName()%></td>
                     <td>
                        <form action="MainController" method="post">
                            <input type="hidden" name="action" value="Edit">
                            <input type="hidden" name="id" value="<%= clothes.getId() %>">
                            <input type="number" name="quantity" value="<%= clothes.getQuantity() %>" min="1">                                                   
                    </td>
                    <td><%= clothes.getPrice() %></td>
                    <td><%= clothes.getQuantity() * clothes.getPrice() %></td>
                    <td>
                            <button type="submit">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="MainController" method="post">
                            <input type="hidden" name="action" value="Remove">
                            <input type="hidden" name="id" value="<%= clothes.getId() %>">
                            <button type="submit">Remove</button>
                        </form>
                    </td>
                 </tr>    
             <%
                 }
             %>
             </tbody>
         </table>
                     <h1>Total: <%= total%>$</h1>
         <%
             }
         %>
         <a href="shopping.html">add more!s</a>
    </body>
</html>
