/*
Comments is referring to which question of assignment/task are and
Comments also indicates what are the task being done for
 */

public class BusinessEmployee extends Employee {
    //this to inherit class Employee
    public BusinessEmployee(String name){
        super(name,50000.00);
        //Has a default salary of 50000
    }

    public double getBonusBudget(){
        return bonusBudget;
        //Should establish a running tally of the remaining bonusBudget for the team this employee supports.How that budget is determined will depend on which type of Business Employee it is.
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus(){
        //Should return a String representation of this BusinessEmployee that includes their ID, name and the size of their currently managed budget.Example: "1 Kasey with a budget of 22500.0"
        String convert= String.format("%.2f",bonusBudget);//reduce the double to 2 decimals
        return this +" with a budget of "+ convert;
    }
}
