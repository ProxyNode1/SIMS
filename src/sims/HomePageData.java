package sims;

public class HomePageData 
{   
    private String name, course, contact, collegeId;
    private int currSem;
     
    
    public HomePageData(String collegeId, String name, String course, int currSem, String contact)
    {
       
        this.name = name;
        this.course = course;
        this.contact = contact;
        this.collegeId = collegeId;
        this.currSem = currSem;
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

    
    public String getContact() 
    {
        return contact;
    }

    
    public void setContact(String contact) 
    {
        this.contact = contact;
    }
    
    
    public int getCurrSem() 
    {
        return currSem;
    }

    
    public void setCsem(int currSem) 
    {
        this.currSem = currSem;
    }
        
}