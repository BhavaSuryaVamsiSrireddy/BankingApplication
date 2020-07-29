package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.*;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //getting the value from index.jsp and storing it in deposit_amount varible.
        int deposit_amount = Integer.parseInt(request.getParameter("deposit_amount"));
        //checking whether the deposit_amount is greater than 0.
        if(deposit_amount > 0){
            //updating the account balance in database and getting it by sending deposit_amount through the method depositOperation.
            int ab = DepositOperations.depositOperation(deposit_amount);
            //setting the attributes deposit_amount and account_balance to print it in DisplayDeposit.jsp
            request.setAttribute("deposit_amount", deposit_amount);
            request.setAttribute("ab", ab);
            request.getRequestDispatcher("DisplayDeposit.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.println("PLEASE ENTER A VALID AMOUNT");
        }
        out.close();
    }
}