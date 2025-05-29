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
public class VendorDao {
    
    public VendorDao(){
          try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
    }
    
    public Vendor searchbyid(String id){
        Connection dbcon;
        Vendor vobj=new Vendor();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Vendor where VendorID='"+id+"'");
            while(rslt.next()){
                vobj= new Vendor(rslt.getString("VendorID"),rslt.getString("VendorName"), rslt.getString("VendorAddress"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return vobj;
    }
    
    public boolean deletebyid(String id){
       Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from Vendor where ProjectNo = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    public boolean insert(Vendor vobj){
        Connection dbcon;
        String id= vobj.getid();
        String name=vobj.getname();
        String address=vobj.getaddress();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Vendor values(?,?,?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
     public boolean update(Vendor vobj){
        Connection dbcon;
        String id= vobj.getid();
        String name=vobj.getname();
        String address=vobj.getaddress();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update Vendor set VendorName=?, VendorAddress=? where VendorID=?");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, id);
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
 