package sims;

public class InputClass 
{   
    private String name,branch, currentEdu, contact, collegeId, Csem;
    
    

    public InputClass(String collegeId, String name, String branch, String Csem, String currentEdu, String contact)
    {
       
        this.name = name;
        this.branch = branch;
        this.currentEdu = currentEdu;
        this.contact = contact;
        this.collegeId = collegeId;
        this.Csem = Csem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCurrentEdu() {
        return currentEdu;
    }

    public void setCurrentEdu(String currentEdu) {
        this.currentEdu = currentEdu;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCsem() {
        return Csem;
    }

    public void setCsem(String Csem) {
        this.Csem = Csem;
    }
    
    
    
}