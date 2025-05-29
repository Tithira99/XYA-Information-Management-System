/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * @author Tithira
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class EmployeeDao {
    
    
    public EmployeeDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
            
    }
    
    public Employee searchbyid(int id){
        Connection dbcon;
        Employee employee=new Employee();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Employee where EmpID="+id+"");
            while(rslt.next()){
                employee= new Employee(rslt.getInt("EmpID"),rslt.getString("EmpName"), rslt.getString("JobTitle"), rslt.getString("DateofBirth"),rslt.getString("EmpType"),rslt.getInt("Salary"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return employee;
    }
    
    public boolean insert (Employee eobj){
        Connection dbcon;
        int id= eobj.getID();
        String name=eobj.getname();
        String Job=eobj.getJobT();
        String DOB=eobj.getDOB();
        String type=eobj.gettype();
        int salary=eobj.getsalary();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, Job);
            ps.setString(4, DOB);
            ps.setString(5, type);
            ps.setInt(6, salary);
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
     /*public void insert (Employee eobj){
        Connection dbcon;
        int id= eobj.getID();
        String name=eobj.getname();
        String Job=eobj.getJobT();
        String DOB=eobj.getDOB();
        String type=eobj.gettype();
        int salary=eobj.getsalary();
        String status;
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, Job);
            ps.setString(4, DOB);
            ps.setString(5, type);
            ps.setInt(6, salary);
            ps.executeUpdate();
            dbcon.close();
    
            System.out.println("Inserted Successfully");
        }
        catch(SQLException ex){
            
            System.out.println(ex);
             
        }
        
        
    }*/
    
    
        
    public boolean update(Employee eobj){
        Connection dbcon;
        int id= eobj.getID();
        String name=eobj.getname();
        String Job=eobj.getJobT();
        String DOB=eobj.getDOB();
        String type=eobj.gettype();
        int salary=eobj.getsalary();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update Employee set EmpName=?, JobTitle=?, DateofBirth=?, EmpType=?, Salary=? where EmpID=?");
            ps.setString(1, name);
            ps.setString(2, Job);
            ps.setString(3, DOB);
            ps.setString(4, type);
            ps.setInt(5, salary);
            ps.setInt(6, id);
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
            PreparedStatement ps = dbcon.prepareStatement("delete from Employee where EmpID = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    
    
    
    public DefaultTableModel searchbyname(String name){
        
        Connection dbcon;
        Employee employee=new Employee();
        DefaultTableModel dt=new DefaultTableModel(new String[]{"EmpID","EmpName", "JobTitle", "DateofBirth" , "EmpType", "Salary"},0);
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Employee where EmpName LIKE '%"+name+"%'");
            while(rslt.next()){
                employee= new Employee(rslt.getInt("EmpID"),rslt.getString("EmpName"), rslt.getString("JobTitle"), rslt.getString("DateofBirth"),rslt.getString("Type"),rslt.getInt("Salary"));
                dt.addRow(new Object[]{employee});
            }
            
            dbcon.close();
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return dt;
    }

    
    
        
    
}
