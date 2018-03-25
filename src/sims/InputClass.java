
package sims;



public class InputClass 
{   
    private String name,branch, currentEdu, contact;
    private int sno, Csem ;
    private long collegeId;

    public InputClass(int sno, long collegeId, String name, String branch, int Csem, String currentEdu, String contact)
    {
       
        this.name = name;
        this.branch = branch;
        this.currentEdu = currentEdu;
        this.contact = contact;
        this.sno = sno;
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

    public void setContect(String contact) {
        this.contact = contact;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public int getCsem() {
        return Csem;
    }

    public void setCsem(int Csem) {
        this.Csem = Csem;
    }
    
    
    
}
