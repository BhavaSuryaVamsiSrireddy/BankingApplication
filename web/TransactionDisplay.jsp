<%-- 
    Document   : TransactionDisplay
    Created on : Jul 29, 2020, 8:59:44 AM
    Author     : SURYA
--%>

<%@page import="classes.Tdata"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANSACTIONS</title>
        <style>
         table, th, td {
            border: 1px solid black;
         }
      </style>
    </head>
    <body>
        <nav><a href="index.jsp">HOME</a></nav>
        <h1>TRANSACTIONS</h1><br>
        <% ArrayList<Tdata> list = (ArrayList) request.getAttribute("list");%>
        <table>
            <tr>
                <th>Transaction Id</th>
                <th>User Id</th>
                <th>Transfer Amount</th>
                <th>Deposit Amount</th>
                <th>Account Balance</th>
            </tr>
            <%
            for(int i = list.size()-1;i>=0;i--){
            %>
                <tr>
                    <td><%=(list.get(i)).getTid()%></td>
                    <td><%=(list.get(i)).getUid()%></td>
                    <td><%=(list.get(i)).getTransfer_amount()%></td>
                    <td><%=(list.get(i)).getDeposit_amount()%></td>
                    <td><%=(list.get(i)).getAccount_balance()%></td>
                </tr>
           <% }%>
        </table>
    </body>
</html>
