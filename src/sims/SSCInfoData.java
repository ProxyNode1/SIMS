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
public class SSCInfoData
{
    private int passYearVal = 0;
       
    private String rNoVal = null, boardVal = null, mediumVal = null, schoolVal = null, cityVal = null;

    private float percentVal = 0.f;
    
    private static volatile SSCInfoData instance = null;
    
    
    private SSCInfoData()
    {}
    
        
    public static SSCInfoData getInstance()
    {
        if(instance == null)
        {
            instance = new SSCInfoData();
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
    
}