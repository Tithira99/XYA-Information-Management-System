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
public class Skill {
    
    private String SkillID;
    private String  Skilldes;
    
    public Skill(){
    }
    
    public Skill(String sid){
        this.SkillID=sid;
    }
    
    public Skill(String sid, String sdes){
        this.SkillID=sid;
        this.Skilldes=sdes;
    }
    
    public String getID(){
        return this.SkillID;
    }
    public String getsdes(){
        return this.Skilldes;
    }
    
    public void setsid(String sid){
        this.SkillID=sid;
    }
    
    public void setsdes(String sdes){
        this.Skilldes=sdes;
    }
    
    
    
    
}
