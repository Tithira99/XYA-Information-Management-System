/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tithira
 */
public class LoginRegistrationDao {
    
    
    public LoginRegistrationDao(){
          try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
    }
    
    public LoginRegistration searchbyid(String un){
        Connection dbcon;
        LoginRegistration lr=new LoginRegistration();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from LoginRegistration where Username='"+un+"'");
            while(rslt.next()){
                lr= new LoginRegistration(rslt.getString("UserName"),rslt.getString("Password"), rslt.getString("Role"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return lr;
    }
    
    public boolean deletebyid(String un){
       Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from LoginRegistration where UserName = ?");
            ps.setString(1, un);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    public boolean insert(LoginRegistration lr){
        Connection dbcon;
        String un= lr.getun();
        String pd=lr.getpd();
        String role=lr.getrole();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into LoginRegistration values(?,?,?)");
            ps.setString(1, un);
            ps.setString(2, pd);
            ps.setString(3, role);
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
     public boolean update(LoginRegistration lr){
        Connection dbcon;
        String un= lr.getun();
        String pd=lr.getpd();
        String role=lr.getrole();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update LoginRegistration set Password=?, Role=? where UserName=?");
            ps.setString(1, pd);
            ps.setString(2, role);
            ps.setString(3, un);
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            
            System.out.println(ex);
            return false;  
        }
    }
}
 
    

