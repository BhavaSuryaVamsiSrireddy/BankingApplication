<%-- 
    Document   : index
    Created on : Jul 28, 2020, 2:06:17 PM
    Author     : SURYA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
    </head>
    <body>
        <h1>BANKING APPLICATION</h1>
        <form method="post" action="Transfer">
            <input placeholder="Enter the amount to transfer" name="transfer_amount">
            <input type="submit" value="TRANSFER"><br>
        </form>
        <br>
        <form method="post" action="Deposit">
            <input placeholder="Enter the amount to Deposit" name="deposit_amount">
            <input type="submit" value="DEPOSIT"><br>
        </form>
        <br>
        <a href="Transaction">VIEW TRANSACTIONS</a>
        
        <a href="AccountBalance">ACCOUNT BALANCE</a><br>
        <br>
    </body>
</html>
