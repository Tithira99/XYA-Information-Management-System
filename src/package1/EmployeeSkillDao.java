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
public class EmployeeSkillDao {
    
     public EmployeeSkillDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
            
    }
     
    public EmployeeSkill searchbyid(int id, String sid){
        Connection dbcon;
        EmployeeSkill es=new EmployeeSkill();
        try{  
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Employeez_Skill where EmployeeID="+id+", SkillID="+sid+"");
            while(rslt.next()){
                es= new EmployeeSkill(rslt.getInt("EmpID"),rslt.getString("SkillID"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return es;
    }
    
    
    public boolean insert (EmployeeSkill es){
        Connection dbcon;
        
        int eid=es.geteid();
        String sid=es.getsid();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Employee_Skill values(?,?)");
           
            ps.setInt(1, eid);
            ps.setString(2, sid);
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    public boolean deleteById(int id, String sid) {
        Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from Employee_Skill where EmpID = ? AND SkillID =?");
            ps.setInt(1, id);
            ps.setString(2, sid);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    
    
    
}
