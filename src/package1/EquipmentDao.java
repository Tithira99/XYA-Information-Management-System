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
public class EquipmentDao {
    
    public EquipmentDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
            
    }
    
    
    public Equipment searchbyid(String id){
        Connection dbcon;
        Equipment eqp=new Equipment();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Equipment where EquipmentID='"+id+"'");
            while(rslt.next()){
                 eqp= new Equipment(rslt.getString("EquipmentID"),rslt.getString("EquipmentName"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return eqp;
    }
    
    
    
    public boolean insert (Equipment eqp){
        Connection dbcon;
        
        String eid=eqp.getid();
        String name=eqp.getname();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Equipment values(?,?)");
           
            ps.setString(1, eid);
            ps.setString(2, name);
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    
    
    
    public boolean update(Equipment eqp){
        Connection dbcon;
        
        String eid=eqp.getid();
        String name=eqp.getname();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update Equipment Set EquipmentName=? where EquipmentID=?");
            ps.setString(1, name);
            ps.setString(2, eid);
            
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    public boolean deleteById(String id) {
        Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from Equipment where EquipmentID = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
}
