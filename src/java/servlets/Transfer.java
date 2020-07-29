package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.*;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //getting the value from index.jsp and storing it in transfer_amount varible.
        int transfer_amount = Integer.parseInt(request.getParameter("transfer_amount"));
        //checking whether the transfer_amount is greater than 0.
        if(transfer_amount > 0){
            //updating the account balance in database and getting it by sending transfer_amount through the static method transferOperation in TransferOperations class in classes package. 
            int account_balance = TransferOperations.transferOperation(transfer_amount);
            if(account_balance!=-1){
                //setting the attributes transfer_amount and account_balance to print it in DisplayTransfer.jsp
                request.setAttribute("transfer_amount", transfer_amount);
                request.setAttribute("ab", account_balance);
                request.getRequestDispatcher("DisplayTransfer.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.println("INSUFFICIENT FUNDS IN THE ACCOUNT");
            }
        }
        else{
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.println("PLEASE ENTER A VALID AMOUNT");
        }
        out.close();
    }
}
