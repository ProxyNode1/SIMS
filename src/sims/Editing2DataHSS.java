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
public class Editing2DataHSS 
{
    
    private int passYearVal;
           
    private String rNoVal, boardVal, mediumVal, schoolVal, cityVal;
    
    private float percentVal, physicsVal, chemistryVal, mathVal;
    
    private static volatile Editing2DataHSS instance = null;
    
    
    Editing2DataHSS()
    {}
    
    
    public static Editing2DataHSS getInstance() 
    {
        if(instance == null)
        {
            instance = new Editing2DataHSS();
        }
        
        return instance;
    }

    
    public int getPassYearVal() 
    {
        return passYearVal;
    }

    public void setPassYearVal(int passYearVal) 
    {
        this.passYearVal = passYearVal;
        System.out.println(passYearVal);
    }

        
    public String getRNoVal() 
    {
        return rNoVal;
    }

    public void setRNoVal(String rNoVal) 
    {
        this.rNoVal = rNoVal;
        System.out.println(rNoVal);
    }

    
    public String getBoardVal() 
    {
        return boardVal;
    }

    public void setBoardVal(String boardVal) 
    {
        this.boardVal = boardVal;
        System.out.println(boardVal);
    }

    
    public String getMediumVal() 
    {
        return mediumVal;
    }

    public void setMediumVal(String mediumVal) 
    {
        this.mediumVal = mediumVal;
        System.out.println(mediumVal);
    }

    
    public String getSchoolVal() 
    {
        return schoolVal;
    }

    public void setSchoolVal(String schoolVal) 
    {
        this.schoolVal = schoolVal;
        System.out.println(schoolVal);
    }

    
    public String getCityVal() 
    {
        return cityVal;
    }

    public void setCityVal(String cityVal) 
    {
        this.cityVal = cityVal;
        System.out.println(cityVal);
    }
    
    
    public float getPercentVal() 
    {
        return percentVal;
    }

    public void setPercentVal(float percentVal) 
    {
        this.percentVal = percentVal;
        System.out.println(percentVal);
    }

    
    public float getPhysicsVal() 
    {
        return physicsVal;
    }

    public void setPhysicsVal(float physicsVal) 
    {
        this.physicsVal = physicsVal;
        System.out.println(physicsVal);
    }

    
    public float getChemistryVal() 
    {
        return chemistryVal;
    }

    public void setChemistryVal(float chemistryVal) 
    {
        this.chemistryVal = chemistryVal;
        System.out.println(chemistryVal);
    }

    
    public float getMathVal() 
    {
        return mathVal;
    }

    public void setMathVal(float mathVal) 
    {
        this.mathVal = mathVal;
        System.out.println(mathVal);
    }
}