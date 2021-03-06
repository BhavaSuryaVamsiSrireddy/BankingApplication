package servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.*;
import java.util.ArrayList;

@WebServlet("/Transaction")
public class Transaction extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        ArrayList<Tdata> list = new ArrayList<>();
        //getting the transactions into a list through a static method displayTransaction in TransactOperations class in classes package.
        list = TransactOperations.displayTransation();
        //setting the list attribute to print it in the TransactionDisplay.jsp.
        request.setAttribute("list", list);
        request.getRequestDispatcher("TransactionDisplay.jsp").forward(request, response);
    }
}
