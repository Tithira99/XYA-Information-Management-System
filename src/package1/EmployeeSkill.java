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
public class EmployeeSkill {
    private int  EmplID;
    private String skillID;
    
    
    
    public EmployeeSkill(){
        
    }
    
    public EmployeeSkill(int eid, String sid){
       this.EmplID=eid;
       this.skillID=sid;
    }
    
    
    
    public int geteid(){
        return this.EmplID;
    }
    
    public String getsid(){
        return this.skillID;
    }
    public void seteid(int eid){
        this.EmplID=eid;
        
    }
    
     public void setsid(String sid){
        this.skillID=sid;
        
    }
    
   
}
