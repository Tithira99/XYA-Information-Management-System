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
public class EmployeeProject {
    
    private int EmpID;
    private String ProjectNo;
    private String SkillNo;
    
    
    public EmployeeProject(){
        
    }
    
    public EmployeeProject(int eid, String pid, String sid){
        this.EmpID=eid;
        this.ProjectNo=pid;
        this.SkillNo=sid;
    }
    
    public int geteid(){
       return this.EmpID;
        
        
    }
    public String getpid(){
       return this.ProjectNo;
        
        
    }
    public String getsid(){
       return this.SkillNo;
        
        
    }
    
    public void seteid(int eid){
        this.EmpID=eid;
    }
    
    public void setpid(String pid){
        this.ProjectNo=pid;
    }
    
    
    public void setsid(String sid){
        this.SkillNo=sid;
    }
    
    

    
    
}
