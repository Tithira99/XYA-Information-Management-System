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
public class MarriageDetails {
    
    
     private int Husband;
    private int Wife;
    private String MarriageDate;
    
    
    public MarriageDetails(){
        
    }
            
    public MarriageDetails(int hb, int wf){
        this.Husband=hb;
        this.Wife=wf;
    }
    
    public MarriageDetails(int hb, int wf, String md){
        this.Husband=hb;
        this.Wife=wf;
        this.MarriageDate=md;
    }
    
    
    public int gethb(){
        return this.Husband;
    }
     
    public int getwf(){
        return this.Wife;
    }
     
    public String getmd(){
        return this.MarriageDate;
    }
    
    public void sethb(int hb){
       this.Husband=hb; 
    }
    
     
     
      public void setwf(int wf){
        this.Wife=wf;
    }
      
      public void setmd(String md){
         this.MarriageDate=md;
    }
}
