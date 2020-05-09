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
public class PGInfoData 
{   
    public static PGInfoData getInstance()
    {
        if(instance == null)
        {
            instance = new PGInfoData();
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
    
    
    public void setDefaultValue()
    {
        passYearVal = 0;
        schoolVal = null; 
        cityVal = null;
        percentVal = 0.0f;
    }
       
        
    private int passYearVal;    
    
    private String schoolVal, cityVal;
        
    private float percentVal;
    
    private static volatile PGInfoData instance = null;
    
    
    private PGInfoData()
    {}
}
