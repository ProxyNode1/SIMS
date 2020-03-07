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
public class Editing2DataUG 
{
    
    private int passYearVal;
    
    private String schoolVal, cityVal;
    
    private float percent1Val, percent2Val, percent3Val, percent4Val, 
          percent5Val, percent6Val, percent7Val, percent8Val;
       
    private static volatile Editing2DataUG instance = null;
   
    
    Editing2DataUG()
    {}
    
    public static Editing2DataUG getInstance()
    {
        if(instance == null)
        {
            instance = new Editing2DataUG();
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

    
    public float getPercent1Val() 
    {
        return percent1Val;
    }

    public void setPercent1Val(float percent1Val) 
    {
        this.percent1Val = percent1Val;
        System.out.println(percent1Val);
    }

    
    public float getPercent2Val() 
    {
        return percent2Val;
    }
    
    public void setPercent2Val(float percent2Val) 
    {
        this.percent2Val = percent2Val;
        System.out.println(percent2Val);
    }

    
    public float getPercent3Val() 
    {
        return percent3Val;
    }

    public void setPercent3Val(float percent3Val) 
    {
        this.percent3Val = percent3Val;
        System.out.println(percent3Val);
    }

    
    public float getPercent4Val() 
    {
        return percent4Val;
    }

    public void setPercent4Val(float percent4Val) 
    {
        this.percent4Val = percent4Val;
        System.out.println(percent4Val);
    }

    
    public float getPercent5Val() 
    {
        return percent5Val;
    }

    public void setPercent5Val(float percent5Val) 
    {
        this.percent5Val = percent5Val;
        System.out.println(percent5Val);
    }

    
    public float getPercent6Val() 
    {
        return percent6Val;
    }

    public void setPercent6Val(float percent6Val) 
    {
        this.percent6Val = percent6Val;
        System.out.println(percent6Val);
    }

    
    public float getPercent7Val() 
    {
        return percent7Val;
    }

    public void setPercent7Val(float percent7Val) 
    {
        this.percent7Val = percent7Val;
        System.out.println(percent7Val);
    }

    
    public float getPercent8Val() 
    {
        return percent8Val;
    }

    public void setPercent8Val(float percent8Val) 
    {
        this.percent8Val = percent8Val;
        System.out.println(percent8Val);
    }   
}
