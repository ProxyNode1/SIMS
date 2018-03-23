
package sims;

import javafx.beans.property.SimpleStringProperty;

public class InputClass 
{   
    private SimpleStringProperty name,branch, currentEdu, contect ;
    private int clgId, Csem ;

    public InputClass(int clgId, String name, String branch, int Csem, String currentEdu, String contect)
    {
        this.name = new SimpleStringProperty(name);
        this.branch = new SimpleStringProperty(branch);
        this.currentEdu = new SimpleStringProperty(currentEdu);
        this.contect = new SimpleStringProperty(contect);
        this.clgId = clgId;
        this.Csem = Csem;
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public String getBranch() {
        return branch.get();
    }

    public void setBranch(SimpleStringProperty branch) {
        this.branch = branch;
    }

    public String getCurrentEdu() {
        return currentEdu.get();
    }

    public void setCurrentEdu(SimpleStringProperty currentEdu) {
        this.currentEdu = currentEdu;
    }

    public String getContect() {
        return contect.get();
    }

    public void setContect(SimpleStringProperty contect) {
        this.contect = contect; 
    }

    public int getClgId() {
        return clgId;
    }

    public void setClgId(int clgId) {
        this.clgId = clgId;
    }

    public int getCsem() {
        return Csem;
    }

    public void setCsem(int Csem) {
        this.Csem = Csem;
    }
    
    
    

}