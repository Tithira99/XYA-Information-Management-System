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
public class AssignProject {
    
    private int EmpID;
    private String ProjectID;
    
    
    
    public AssignProject(){
        
    }
    
    public AssignProject(int eid){
        this.EmpID=eid;
    }
    
    public AssignProject(int eid, String pid){
       
        this.EmpID=eid;
        this.ProjectID=pid;
    }
    
    public int getid(){
        return this.EmpID;
    }
    
    public String getpid(){
        return this.ProjectID;
    }
    
    public void setid(int id){
        this.EmpID=id;
        
    }
    
    
    public void setpid(String pid){
        this.ProjectID=pid;
    }
    
    
    
    
}
