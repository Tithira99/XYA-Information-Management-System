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
public class DepartmentVendor {
    private String depID;
    private String VendorID;
    private String LastMeeting;
    
    
    
    public DepartmentVendor(){
        
    }
    
     public DepartmentVendor(String did, String vid){
        this.depID=did;
        this.VendorID=vid;
    }
     
     public DepartmentVendor(String did, String vid, String lm){
         this.depID=did;
         this.VendorID=vid;
         this.LastMeeting=lm;
     }
    
     
     public String getdid(){
         return this.depID;
     }
     public String getvid(){
         return this.VendorID;
     }
     public String getlm(){
         return this.LastMeeting;
     }
     
     public void setdid(String did){
         this.depID=did;
         
     }
     public void setvid(String vid){
         this.VendorID=vid;
         
     }
    
      public void setlm(String lm){
         this.LastMeeting=lm;
         
     }
    
}
