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
public class DepartmentVendorDao {
    
    
    
    public DepartmentVendorDao(){
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
    }
    
    public DepartmentVendor searchbyid(String dname, String vid){
        Connection dbcon;
        DepartmentVendor dv=new DepartmentVendor();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Department_Vendor where DepartmentName='"+dname+"' AND VendorID='"+vid+"'");
            while(rslt.next()){
            dv= new DepartmentVendor(rslt.getString("DepartmentName"),rslt.getString("VendorID"), rslt.getString("LastMeetingDate"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return dv;
    }
    
    
    public boolean insert (DepartmentVendor dv){
        Connection dbcon;
        
        String dname=dv.getdid();
        String vid=dv.getvid();
        String lm=dv.getlm();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Department_Vendor values(?,?,?)");
           
            ps.setString(1, dname);
            ps.setString(2, vid);
            ps.setString(3, lm);
            
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    public boolean update(DepartmentVendor dv){
        Connection dbcon;
        
        String dname=dv.getdid();
        String vid=dv.getvid();
        String lm=dv.getlm();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update Department_Vendor Set LastMeetingDate=? where DepartmentName=? AND VendorID=?");
            ps.setString(1, lm);
            ps.setString(2, dname);
            ps.setString(3, vid);
            
            
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    public boolean deleteById(String dname, String vid) {
        Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from Department_Vendor where DepartmentName= ? AND VendorID=? ");
            ps.setString(1, dname);
            ps.setString(2, vid);

            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
}
