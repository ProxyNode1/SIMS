/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;


public class BasicInfoData 
{
    private String oldNameVal = null;
    private String nameVal = null, clgIDVal = null, courseVal = null, contactVal = null;
    private int yearVal = 0, monthVal = 0, dayVal = 0, currSemVal = 0;
      
    
    private static volatile BasicInfoData instance = null;
    
    
    private BasicInfoData()
    {   }
    
            
    public static BasicInfoData getInstance()
    {
        if(instance == null)
        {
            instance = new BasicInfoData();
        }
        
        return instance;
    }
    
    
    public String getOldNameVal() 
    {
        return oldNameVal;
    }
    
    public void setOldNameVal(String oldNameVal) 
    {
        this.oldNameVal = oldNameVal;
        System.out.println("Old Name:" + this.oldNameVal);
    }
    
        
    public String getNameVal() 
    {
        return nameVal;
    }
    
    public void setNameVal(String nameVal) 
    {
        this.nameVal = nameVal;
        System.out.println(this.nameVal);
    }
    
        
    public String getClgIDVal() 
    {
        return clgIDVal;
    }

    public void setClgIDVal(String clgIDVal) 
    {
        this.clgIDVal = clgIDVal;
        System.out.println(this.clgIDVal);
    }
    
    
    public int getYearVal() 
    {
        return yearVal;
    }

    public void setYearVal(int yearVal) 
    {
        this.yearVal = yearVal;
        System.out.println(this.yearVal);
    }
    
    
    public int getMonthVal() 
    {
        return monthVal;
    } 
    
    public void setMonthVal(int monthVal) 
    {
        this.monthVal = monthVal;
        System.out.println(this.monthVal);
    }
    
    
    public int getDayVal() 
    {
        return dayVal;
    }
    
    public void setDayVal(int dayVal) 
    {
        this.dayVal = dayVal;
        System.out.println(this.dayVal);
    }

    
    public String getCourseVal() 
    {
        return courseVal;
    }

    public void setCourseVal(String courseVal) 
    {
        this.courseVal = courseVal;
        System.out.println(this.courseVal);
    }
    
    
    public int getCurrSemVal() 
    {
        return currSemVal;
    }
    
    
    public void setCurrSemVal(int currSemVal) 
    {
        this.currSemVal = currSemVal;
        System.out.println(this.currSemVal);
    }
    
    
    public String getContactVal() 
    {
        return contactVal;
    }
    
    public void setContactVal(String contactVal) 
    {
        this.contactVal = contactVal;
        System.out.println(this.contactVal);
    }
}