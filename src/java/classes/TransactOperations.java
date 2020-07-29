package classes;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class TransactOperations {
    public static ArrayList<Tdata> displayTransation(){
        //query to retrieve last five transactions.
        String baquery = "select * from transaction order by tid desc limit 5";
        ArrayList<Tdata> list = new ArrayList<Tdata>();
        //setting the database connection using getConnection method in ConnectionManager class.
        try(Connection currentcon = ConnectionManager.getConnection();
            Statement st = currentcon.createStatement();
            ResultSet rs =  st.executeQuery(baquery)){
            //the values of resultset is stored as separate objects and these objects are added in list and finally the list is returned.
            while(rs.next()){
                Tdata d = new Tdata();
                d.setTid(rs.getInt("tid"));
                d.setUid(rs.getInt("uid"));
                d.setTransfer_amount(rs.getInt("transfer_amount"));
                d.setDeposit_amount(rs.getInt("deposit_amount"));
                d.setAccount_balance(rs.getInt("account_balance"));
                list.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
