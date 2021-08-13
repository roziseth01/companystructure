/*
Comments is referring to which question of assignment/task are and
Comments also indicates what are the task being done for
 */

public class SoftwareEngineer extends TechnicalEmployee{
    //this to inherit class Employee
    public boolean CodeAccess;
    //to get value of access

    public SoftwareEngineer(String name){
        super(name);
        setCodeAccess(true);
        //setup the default value for boolean of CodeAccess.
    }

    public boolean getCodeAccess(){
        return CodeAccess;
        //Should return whether or not this SoftwareEngineer has access to make changes to the code base.
    }

    public void setCodeAccess(boolean access){
        this.CodeAccess=access;
        //Should allow an external piece of code to update the SoftwareEngineer's code privileges to either true or false.
    }

    public int getSuccessfulCheckIns(){
        return checkins;
        //checkins was called from TechnicalEmployee class
        //Should return the current count of how many times this SoftwareEngineer has successfully checked in code
    }

    public boolean checkInCode(){
        //Should check if this SoftwareEngineer's manager approves of their check in. If the check in is approved their successful checkin count should be increased and the method should return "true".
        // If the manager does not approve the check in the SoftwareEngineer's code access should be changed to false and the method should return "false".
        TechnicalLead manager=(TechnicalLead) this.getManager();
        if (manager.approveCheckIn(this)){
            this.checkins++;
            return true;
        } else {
            CodeAccess=false;
            return false;
        }
    }

}
