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
public class MarriageDao {
    
    public MarriageDao(){
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
        }catch(Exception ex){
            System.out.println("Error Loading driver:"+ ex.toString());
        }
    }
    
    
    public MarriageDetails searchbyid(int hb, int wf){
        Connection dbcon;
        MarriageDetails mdt=new MarriageDetails();
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            Statement stmt =dbcon.createStatement();
            ResultSet rslt=stmt.executeQuery("Select * from MarriageDetails where Husband="+hb+" AND Wife="+wf+"");
            while(rslt.next()){
                mdt= new MarriageDetails(rslt.getInt("Husband"),rslt.getInt("Wife"), rslt.getString("MarriageDate"));
            }
            
            dbcon.close();
            
            
                    
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return mdt;
    }
         
    public boolean insert (MarriageDetails mdt){
        Connection dbcon;
        
        int hb=mdt.gethb();
        int wf=mdt.getwf();
        String md=mdt.getmd();
        
        try{
            dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps=dbcon.prepareStatement("insert into MarriageDetails values(?,?,?)");
           
            ps.setInt(1, hb);
            ps.setInt(2, wf);
            ps.setString(3, md);
            
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
    }
    
    
    public boolean update(MarriageDetails mdt){
        
        Connection dbcon;
        
        int hb=mdt.gethb();
        int wf=mdt.getwf();
        String md=mdt.getmd();
        
        try{
           dbcon=DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
           PreparedStatement ps=dbcon.prepareStatement("Update MarriageDetails Set MarriageDate=? where Husband=? AND Wife=?");
           
            
            ps.setString(1,md);
            ps.setInt(2, hb);
            ps.setInt(3, wf);
            
            ps.executeUpdate();
            dbcon.close();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;  
        }
        
    }
    
    
    public boolean deleteById(int hb, int wf) {
        Connection dbcon;
        try {
            dbcon = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZE;create=true", "tithi1", "TITHI1");
            PreparedStatement ps = dbcon.prepareStatement("delete from MarriageDetails where Husband= ? AND Wife=? ");
            ps.setInt(1, hb);
            ps.setInt(2, wf);

            ps.executeUpdate();
            dbcon.close();
            return true;
        } catch (SQLException ex) {
            
            System.out.println(ex);
            return false;
        }

    }

    
    
}
