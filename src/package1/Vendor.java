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
public class Vendor {
    private String vendorid;
    private String vname;
    private String vaddress;
    
    public Vendor(){
        
    }
    
    public Vendor(String vid){
        this.vendorid=vid;
        
    }
    
    public Vendor(String vid, String name, String address){
    this.vendorid=vid;
    this.vname=name;
    this.vaddress=address;
    
    }
    
    
    public String getid(){
        return this.vendorid;
    }
    public String getname(){
        return this.vname;
    }
    public String getaddress(){
        return this.vaddress;
    }
    
    public void setid(String id){
        this.vendorid=id;
    }
     public void setname(String name){
        this.vname=name;
    }
      public void setaddress(String address){
        this.vaddress=address;
    }
}
