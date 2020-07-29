package classes;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SURYA
 */
public class AccountOperations {
    public static int displayAccountBalance(){
        int account_balance=0;
        String baquery = "select account_balance from user where uid = 1";
        try(Connection currentcon = ConnectionManager.getConnection();
            Statement st = currentcon.createStatement();
            ResultSet rs = st.executeQuery(baquery)) {
            if(rs.next()){
                //getting the account_balance from database and returning it back to the AccountBalance servlet.
                account_balance = rs.getInt("account_balance");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
         return account_balance;
    }
}
