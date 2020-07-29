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
public class TransferOperations {
    public static int transferOperation(int transfer_amount){
        //query to retrieve account_balance.
        String baquery = "select account_balance from user where uid=1";
        //setting the database connection using getConnection method in ConnectionManager class.
        try (Connection currentcon = ConnectionManager.getConnection();
            Statement st = currentcon.createStatement();
            ResultSet rs = st.executeQuery(baquery)){
            int account_balance=0;
            while(rs.next()){
            //getting the account_balance from database and storing it in account_balance variable.
                account_balance = rs.getInt("account_balance");
            }
            //checking the transfer_amount is lessthan than or equal to the account_balance.
            if(transfer_amount <= account_balance){
                //if transfer_amount is less than account_balance means it is updated. 
                account_balance = account_balance - transfer_amount;
                //inserting transfer_amount and account_balance in transaction table.
                st.executeUpdate("insert into transaction (uid,transfer_amount,account_balance) values(1,"+transfer_amount+","+account_balance+")");
                //updating the account_balance in user table.
                st.executeUpdate("update user set account_balance = "+account_balance+" where uid = 1");
                return account_balance;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransferOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
