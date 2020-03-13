/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

/**
 *
 * @author Vic's
 */
public class Editing3Data 
{
    private String personMailVal = null, universityMailVal = null, dadContactVal = null, famContactVal = null, addInfoVal = null;
    
    static volatile Editing3Data instance = null;

    
    Editing3Data()
    {}
    
    
    public static Editing3Data getInstance()
    {
        if(instance == null)
        {
            instance = new Editing3Data();
        }
        
        return instance;
    }
    
    
    public String getPersonMailVal() 
    {
        return personMailVal;
    }

    public void setPersonMailVal(String personMailVal) 
    {
        this.personMailVal = personMailVal;
        System.out.println(personMailVal);
    }

    
    public String getUniversityMailVal() 
    {
        return universityMailVal;
    }

    public void setUniversityMailVal(String universityMailVal) 
    {
        this.universityMailVal = universityMailVal;
        System.out.println(universityMailVal);
    }

    
    public String getDadContactVal() 
    {
        return dadContactVal;
    }

    public void setDadContactVal(String dadContactVal) 
    {
        this.dadContactVal = dadContactVal;
        System.out.println(dadContactVal);
    }

    
    public String getFamContactVal() 
    {
        return famContactVal;
    }

    public void setFamContactVal(String famContactVal) 
    {
        this.famContactVal = famContactVal;
        System.out.println(famContactVal);
    }

    
    public String getAddInfoVal() 
    {
        return addInfoVal;
    }

    public void setAddInfoVal(String addInfoVal) 
    {
        this.addInfoVal = addInfoVal;
        System.out.println(addInfoVal);        
    }   
}
