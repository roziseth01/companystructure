/*
Comments is referring to which question of assignment/task are and
Comments also indicates what are the task being done for
 */

import java.util.ArrayList;// to load Arraylist class for user option
public class BusinessLead  extends BusinessEmployee{
    //this to inherit class BusinessEmployee
    public ArrayList<Accountant> team;
    //this to call array list from accountant

    public BusinessLead(String name){
        //Should create a new BusinessLead that is a Manager.
        super(name);
        this.baseSalary=getBaseSalary()*2;
        // The BusinessLead's base salary should be twice that of an Accountant.
        this.headcount=10;
        // They should start with a head count of 10.
        this.team=new ArrayList<Accountant>();
        //the team was called from arraylist of accountant class
    }

    public boolean hasHeadCount(){
        return this.team.size() < this.headcount;
        //Should return true if the number of direct reports this manager has is less than their headcount.
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (hasHeadCount()){
            team.add(e);
            e.setManager(this);
            this.bonusBudget+=e.baseSalary*1.1;
            // Each time a report is added the BusinessLead's bonus budget should be increased by 1.1 times that new employee's base salary.
            e.supportTeam(supportTeam);
            supportTeam.accountantSupport=e;
            // That employee's team they are supporting should be updated to reflect the reference to the TechnicalLead given.
            return true;
            // If the employee is successfully added true should be returned, false otherwise. If the employee is successfully added to the BusinessLead's direct reports true should be returned, false should be returned otherwise.
        } else {
            return false;
        }
        //Should accept the reference to an Accountant object, and if the BusinessLead has head count left should add this employee to their list of direct reports.
    }

    public boolean requestBonus(Employee e, double bonus){
        //Should check if the bonus amount requested would fit in current BusinessLead's budget.
        if (bonus<=getBonusBudget()){
            this.bonusBudget-=bonus;
            e.bonusBudget+=bonus;
            // If it is, that employee should get that bonus, the BusinessLeader's budget should be deducted and true should be returned. False should be returned otherwise
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus){
        for (int i=0;i<team.size();i++){
            if((team.get(i).getTeamSupported()).equals(e.manager) && team.get(i).canApproveBonus(bonus)) {
                e.bonus += bonus;
                team.get(i).bonusBudget -= bonus;
                return true;
            }
        }
        return  false;
        //This function should look through the Accountants the BusinessLead manages,and if any of them are supporting a the TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be consulted to see if the bonus could be afforded.
        //If the team can afford the bonus it should be rewarded and true returned, false otherwise.
    }

    public String getTeamStatus(){
        //this to be use and call during the company structure system test.
        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }
    }

}
