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
public class Project {
    private String ProjectNo;
    private int EstimatedCost;
    private String BeginDate;
    private String ExpectedEndDate;
    
    
    public Project(){
        
    }
     public Project(String pno){
        this.ProjectNo=pno;
    }
    
    public Project(String pno, int ecost, String bdate, String edate){
        this.ProjectNo=pno;
        this.EstimatedCost=ecost;
        this.BeginDate=bdate;
        this.ExpectedEndDate=edate;
    }
    
    public String getID(){
        return this.ProjectNo;
    }
    public int getecost(){
        return this.EstimatedCost;
    }
    public String getbdate(){
        return this.BeginDate;
    }
    public String getedate(){
        return this.ExpectedEndDate; 
    }
    
    public void setpno(String pno){
        this.ProjectNo=pno;
    }
    
    public void setecost(int ecost){
        this.EstimatedCost=ecost;
    }
    public void setbdate(String bdate){
        this.BeginDate=bdate;
    }
    public void setedate(String edate){
        this.ExpectedEndDate=edate;
    }
    
    
    
    
    
    
}
