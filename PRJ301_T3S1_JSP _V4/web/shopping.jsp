<%-- 
    Document   : shopping
    Created on : Jun 14, 2024, 8:26:30 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Diep Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Welcome to Diep's Store</div>
        <form action="MainController " method="POST">
            Select your clothes:
            <select name="cmbClothes">
                <option value="c01-TShirt-25">TShirt-25$</option>
                <option value="c02-Long Shirt-40">Long Shirt-40$</option>
                <option value="c03-Short pant-30">Quan Ngan-30$</option>
                <option value="c04-Blue Cowboy Jean-55">Blue Cowboy Jean-55$</option>
        </select>
            <select name ="cmbQuantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="50">50</option>
                <option value="100">100</option>
                
            </select>
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
        </form
        ${requestScope.MESSAGE}
    </body>
</html>
