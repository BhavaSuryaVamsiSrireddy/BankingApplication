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
public class DepositOperations {
    public static int depositOperation(int deposit_amount){
        int account_balance = 0;
        String baquery = "select account_balance from user where uid = 1";
        //setting the database connection using getConnection method in ConnectionManager class.
        try(Connection currentcon = ConnectionManager.getConnection();
            Statement st = currentcon.createStatement();
            ResultSet rs = st.executeQuery(baquery)) {
            while(rs.next()){
                //getting the account balance from database.
                account_balance = rs.getInt("account_balance");
            }
            //adding the deposit_amount to account_balance.
            account_balance = account_balance + deposit_amount;
            //inserting the deposit_amount and account_balance in transaction table
            st.executeUpdate("insert into transaction (uid,deposit_amount,account_balance) values(1,"+deposit_amount+","+account_balance+")");
            //updating the account_balance in user table.
            st.executeUpdate("update user set account_balance = "+account_balance+" where uid = 1");
        } catch (SQLException ex) {
            Logger.getLogger(DepositOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
         return account_balance;
    }
}
