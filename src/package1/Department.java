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
public class Department {
    
    String DepartmentName;
    String TelNo;
    
    public Department(){
        
    }
    
    public Department(String Dname){
        
        this.DepartmentName=Dname;
    }
    
    
    public Department(String dname, String tno){
        this.DepartmentName=dname;
        this.TelNo=tno;
    }
    
    
    public String getdname(){
        return this.DepartmentName;
    }
    public String gettno(){
        return this.TelNo;
    }
    
    public void setname(String name){
        this.DepartmentName=name;
    }
    
    public void settno(String tno){
        this.TelNo=tno;
    }
    
    
}
