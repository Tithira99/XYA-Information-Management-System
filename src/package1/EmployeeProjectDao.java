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
public class EmployeeProjectDao {
    public EmployeeProjectDao(){
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
    }
    
   
    
    public boolean insert (EmployeeProject ep){
        Connection dbcon;
        
        int eid=ep.geteid();
        String pid= ep.getpid();
        String sid=ep.getsid();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into EmployeeInProjects values(?,?,?)");
           
            ps.setInt(1, eid);
            ps.setString(2, pid);
            ps.setString(3, sid);
            
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    
    
    public boolean deleteById(int  eid, String pid, String sid) {
        Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from EmployeeinProjects where EmpID= ? AND ProjectNo=? AND SkillID=?");
            ps.setInt(1, eid);
            ps.setString(2, pid);
            ps.setString(3, sid);

            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            
            System.out.println(ex);
            return false;
        }

    }
    
}
