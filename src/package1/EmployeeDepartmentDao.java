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
public class EmployeeDepartmentDao {
    
    public EmployeeDepartmentDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
            
    }
    
    public EmployeeDepartment searchbyid(int id){
        Connection dbcon;
        EmployeeDepartment ed=new EmployeeDepartment();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Employee_Department where EmpID="+id+"");
            while(rslt.next()){
                ed= new EmployeeDepartment(rslt.getInt("EmpID"),rslt.getString("DepartmentName"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return ed;
    }
    
    
    public boolean insert (EmployeeDepartment ed){
        Connection dbcon;
        
        int eid=ed.getid();
        String pid=ed.getdname();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Employee_Department values(?,?)");
           
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
    
    public boolean deleteById(int id) {
        Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from Employee_Department where EmpID = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
}
