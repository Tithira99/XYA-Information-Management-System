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
public class Employee {
    
   private int EmpID;
   private String EmpName;
   private  String JobTitle;
   private String DateofBirth;
   private String Type;
   private int Salary;


    public Employee(){
        
    }
    
    public Employee(int id){
    this.EmpID=id;
    }
    
    public Employee(int id, String name, String JobT, String DOB, String Type, int salary){
        this.EmpID=id;
        this.EmpName=name;
        this.JobTitle=JobT;
        this.DateofBirth=DOB;
        this.Type=Type;
        this.Salary=salary;
        
        
    }

  
    
    public int getID(){
        return this.EmpID;
    }
    
    public String getname(){
        return this.EmpName;
    }
    
    public String getJobT(){
        return this.JobTitle;
    }
    
    public String getDOB(){
        return this.DateofBirth;
    }
    public String gettype(){
        return this.Type;
    }
    public int getsalary(){
        return this.Salary;
    }
    
    public void setID( int id){
        this.EmpID=id;
       
        
    }
    public void setname(String name){
        this.EmpName=name;
    }
    
    public void setJobT(String JobT){
        this.JobTitle=JobT;
    }
    public void setDOB(String DOB){
        
        this.DateofBirth=DOB;
    }
    public void setType(String type){
        
        this.Type=type;
    }
    public void setDOB(int salary){
        
        this.Salary=salary;
    }
    
       
    
}
