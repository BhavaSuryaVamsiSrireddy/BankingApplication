package classes;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SURYA
 */
public class ConnectionManager {
    static Connection con;
    static String url;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/bankingapplication";
            con = DriverManager.getConnection(url,"root","");
            System.out.println("success");
        }
        catch(Exception e){
            System.out.println("sql error");
        }
        return con;
    }
}
