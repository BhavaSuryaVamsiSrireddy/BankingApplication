package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.*;

@WebServlet("/AccountBalance")
public class AccountBalance extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        //getting the account_balance from database using the static method displayAccountBalance in AccountsOperation class in classes package.
        int rs = AccountOperations.displayAccountBalance();
        request.setAttribute("result", rs);
        request.getRequestDispatcher("DisplayBalance.jsp").forward(request, response);
    }
}
