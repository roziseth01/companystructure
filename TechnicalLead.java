/*
Comments is referring to which question of assignment/task are and
Comments also indicates what are the task being done for
 */

import java.util.ArrayList;// to load Arraylist class for user option
public class TechnicalLead extends TechnicalEmployee {
    //this to inherit class TechnicalEmployee
    public ArrayList<SoftwareEngineer> team;
    //to call arraylist from SoftwareEngineer


    public TechnicalLead(String name){
        super(name);
        //Should create a new TechnicalLead that is a Manager.
        this.baseSalary*=1.3;
        //The TechnicalLead's base salary should be 1.3 times that of a TechnicalEmployee.
        headcount=4;
        //TechnicalLeads should have a default head count of 4.
        this.team=new ArrayList<SoftwareEngineer>();
        //team was called from arraylist of SoftwareEngineer.
    }

    public boolean hasHeadCount(){
        //Should return true if the number of direct reports this manager has is less than their headcount.
        return team.size() < headcount;
        //this to check the teamsize vs the headcount
    }

    public boolean addReport(SoftwareEngineer e){
        //boolean to check on headcount value.
        if(hasHeadCount()){
            team.add(e);
            //to add this employee to their list of direct reports.
            e.setManager(this);
            //to set the Technical Lead as manager
            return true;
        } else {
            return false;
        }
        //Should accept the reference to a SoftwareEngineer object,and if the TechnicalLead has head count left should add this employee to their list of direct reports. If the employee is
        //successfully added to the TechnicalLead's direct reports true should be returned, false should be returned otherwise
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        //boolean to check on approveCheckIn
        return e.getManager().equals(this) && e.getCodeAccess();
        //Should see if the employee passed in does report to this manager and if their code access is currently set to "true". If both those things are true, true is returned, otherwise false is returned
    }

    public boolean requestBonus(Employee e, double bonus){
        BusinessLead businessLead= (BusinessLead)getAccountantSupport().getManager();
        //to call BusinessLead from BusinessLead class
        return businessLead.approveBonus(e, bonus);
        //Should check if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead. If it is, that employee should get that bonus and true should be returned. False should be returned otherwise
    }

    public String getTeamStatus(){
        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
            // If the TechnicalLead has no reports it should print their employee status followed by the text " and no direct reports yet ".Example: "10 Kasey has 5 successful check ins and no direct reports yet".
        } else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
            // If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins and is managing: /n 5 Niky has 2 successful check ins"
        }
        //Should return a String that gives insight into this Manager and all their direct reports. It should return a string that is a combination of the TechnicalLead's employee status followed by each of their direct employee's status on subsequent lines.
    }

}
