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
public class Equipment {
    
    private String EquipmentID;
    private String Equip_Name;
    
    
    public Equipment(){
        
    }
    
    public Equipment(String eid){
        this.EquipmentID=eid;
        
    }
    
    public Equipment(String eid, String name){
        this.EquipmentID=eid;
        this.Equip_Name=name;
    }
    
    public String getid(){
        return this.EquipmentID;
    }
    
    public String getname(){
        return this.Equip_Name;
    }
    
    public void setid(String eid){
        this.EquipmentID=eid;
    }
    
    public void setname(String name){
        this.Equip_Name=name;
    }
        
    
}
