/*
Comments is referring to which question of assignment/task are and
Comments also indicates what are the task being done for
 */

public class Accountant extends BusinessEmployee {
    //this to inherit class Employee.
    public TechnicalLead teamSupported;
    //to call teamSupported from TechnicalLead class.

    public Accountant(String name){
        super(name);
        bonusBudget=0;
        //Should start with a bonus budget of 0 and no team they are officially supporting.
    }

    public TechnicalLead getTeamSupported(){
        return teamSupported;
        //Should return a reference to the TechnicalLead that this Accountant is currently supporting. If they have not been assigned a TechnicalLead null should be returned.
    }

    public void supportTeam(TechnicalLead lead){
        this.teamSupported=lead;
        for (int i=0; i<lead.team.size(); i++){
            this.bonusBudget+=lead.team.get(i).getBaseSalary()*1.1;
        }
        //Should allow a reference to a TechnicalLead to be passed in and saved.Once this happens the Accountant's bonus budget should be updated to be the total of each SoftwareEngineer's base salary that reports to that TechnicalLead plus 10%.
        //For example, if the TechnicalLead supports 2 SoftwareEngineers, each with a salary of 75000, the Accountant's budget should be 150000 + 15000 for a total of 165000.
    }

    public boolean canApproveBonus(double bonus){
        double requestedBonus=bonus;
        if (requestedBonus<=getBonusBudget()){
            return true;
        } else {
            System.out.print(" Rejected because Budget not sufficient. ");
            return false;
        }
        //Should take in a suggested bonus amount and check if there is still enough room in the budget.If the bonus is greater than the remaining budget, false should be returned, otherwise true.
        //If the accountant is not supporting any team false should be returned.

    }

    public String employeeStatus(){
        return this +" with a budget of "+ getBonusBudget()+" is supporting "+ this.getTeamSupported();
        //Should return a String representation of this Accountant that includes their ID, name, the size of their currently managed budget and the name of the TechnicalLead they are currently supporting.
        //Example: "1 Kasey with a budget of 22500.0 is supporting Satya Nadella"
    }

}
