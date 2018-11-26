/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalbus;

import java.sql.*;

/**
 *
 * @author Sylvia Putri
 */
public class KoneksiDB {
    public static void main(String[] args) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String user = "root";
        String pass = "";
        
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus",user,pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from kasir");
            while(myRs.next())
                System.out.println(myRs.getString("id_kasir")+" "+myRs.getString("nama_kasir"));
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            if(myRs!=null){
                myRs.close();
            }
            if(myStmt!=null){
                myStmt.close();
            }
            if(myConn!=null){
                myConn.close();
            }
        }
    }
        
}
