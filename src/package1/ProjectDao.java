/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.sql.*;/**
 *
 * @author Tithira
 */
public class ProjectDao {
    
    public ProjectDao(){
          try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
    }
    
    public Project searchbyid(String id){
        Connection dbcon;
        Project pobj=new Project();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Project where ProjectNo='"+id+"'");
            while(rslt.next()){
                pobj= new Project(rslt.getString("ProjectNo"),rslt.getInt("EstimatedCost"), rslt.getString("BeginDate"), rslt.getString("ExpectedEndDate"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return pobj;
    }
    
    public boolean deletebyid(String id){
       Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from Project where ProjectNo = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
    
    public boolean insert(Project pobj){
        Connection dbcon;
        String id= pobj.getID();
        int name=pobj.getecost();
        String bdate=pobj.getbdate();
        String edate=pobj.getedate();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Project values(?,?,?,?)");
            ps.setString(1, id);
            ps.setInt(2, name);
            ps.setString(3, bdate);
            ps.setString(4, edate);
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    public boolean update(Project pobj){
        Connection dbcon;
        String id= pobj.getID();
        int ecost=pobj.getecost();
        String bdate=pobj.getbdate();
        String edate=pobj.getedate();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update Project set EstimatedCost=?, BeginDate=?, ExpectedEndDate=? where ProjectNo=?");
            ps.setInt(1, ecost);
            ps.setString(2, bdate);
            ps.setString(3, edate);
            ps.setString(4, id);
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
