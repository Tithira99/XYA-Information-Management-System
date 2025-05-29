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
public class EmployeeDepartment {
    private int employeeid;
    private String departmentname;
    
    public EmployeeDepartment(){
        
    }
    
    public EmployeeDepartment(int eid){
       this.employeeid=eid;
     
    }
    
    public EmployeeDepartment(int eid, String dname){
       this.employeeid=eid;
       this.departmentname=dname;
    }
    
    public int getid(){
        return this.employeeid;
    }
    
    public String getdname(){
        return this.departmentname;
    }
    
    public void setid(int eid){
        this.employeeid=eid;
    }
    public void setid(String dname){
       this.departmentname=dname;
    }
    
}
