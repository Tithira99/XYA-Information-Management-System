/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;


import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Tithira
 */
public class AssignProjectDao {
    
    public AssignProjectDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
            
    }
    
     public AssignProject searchbyid(int  id){
        Connection dbcon;
        AssignProject ap=new AssignProject();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Assign_Project where EmpID="+id+"");
            while(rslt.next()){
                ap= new AssignProject(rslt.getInt("EmpID"),rslt.getString("ProjectNo"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return ap;
    }
     
     
     public boolean insert (AssignProject ap){
        Connection dbcon;
        
        int eid=ap.getid();
        String pid=ap.getpid();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Assign_Project values(?,?)");
           
            ps.setInt(1, eid);
            ps.setString(2, pid);
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
     
     public boolean update(AssignProject ap){
        Connection dbcon;
        
        int eid=ap.getid();
        String pid=ap.getpid();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update Assign_Project Set ProjectNo=? where EmpID=?");
            ps.setString(1, pid);
            ps.setInt(2, eid);
            
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
     
     public boolean deleteById(int id) {
        Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from Assign_Project where EmpID = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
     
     
    
}
