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
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;   
    PreparedStatement preparedStmt = null;
    
    public void connect() throws SQLException{
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","");
            myStmt = myConn.createStatement();
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
    
    public void close() throws SQLException{
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
    
    public void createQuery(String query) throws SQLException{
        myRs = myStmt.executeQuery(query);
    }
    
    public void createInsert(String query) throws SQLException{
        myStmt.executeUpdate(query);
    }
    
    public void createUpdate(String query) throws SQLException{
        preparedStmt = myConn.prepareStatement(query);
        preparedStmt.executeUpdate();
    }
    /*
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
        */
}
