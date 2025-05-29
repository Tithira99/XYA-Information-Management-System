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
public class SkillDao {
    
    public SkillDao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
            
    }
    
    
    
    public Skill searchbyid(String id){
        Connection dbcon;
        Skill skl=new Skill();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from Skills where SkillID='"+id+"'");
            while(rslt.next()){
                skl= new Skill(rslt.getString("SkillID"),rslt.getString("Skill_des"));
                
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return skl;
    }
    
    
    public boolean insert (Skill skl){
        Connection dbcon;
        
        String SklID=skl.getID();
        String sdes=skl.getsdes();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into Skills values(?,?)");
           
            ps.setString(1, SklID);
            ps.setString(2, sdes);
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    public boolean update(Skill skl){
        Connection dbcon;
        
        String SklID=skl.getID();
        String sdes=skl.getsdes();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("Update Skills Set Skill_des=? where skillID=?");
            ps.setString(1, sdes);
            ps.setString(2, SklID);
            
            
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
            PreparedStatement ps = dbcon.prepareStatement("delete from Skills where SkillID = ?");
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
