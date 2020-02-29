package sims;

public class HomePageData 
{   
    private String collegeId, name, course;
    private int currSem;
    private String contact;
     
    
    public HomePageData(String collegeId, String name, String course, int currSem, String contact)
    {
        this.collegeId = collegeId;        
        this.name = name;
        this.course = course;        
        this.currSem = currSem;
        this.contact = contact;        
    }

    
    public String getCollegeId() 
    {
        return collegeId;
    }
    
    public void setCollegeId(String collegeId) 
    {
        this.collegeId = collegeId;
    }
    
    
    public String getName() 
    {
        return name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    
    public String getCourse() 
    {
        return course;
    }
    
    public void setCourse(String course) 
    {
        this.course = course;
    }

    
    public int getCurrSem() 
    {
        return currSem;
    }
    
    public void setCurrSem(int currSem) 
    {
        this.currSem = currSem;
    }
    
    
    public String getContact() 
    {
        return contact;
    }
    
    public void setContact(String contact) 
    {
        this.contact = contact;
    }
            
}