/*
Comments is referring to which question of assignment/task are and
Comments also indicates what are the task being done for
 */

public abstract class Employee {

    public String name;//to declare data type of name.
    private static int counter; //to used in static, counter to count the employeeID.
    public int employeeID;//to declare data type on employeeID.
    public double baseSalary;//to declare data type of baseSalary.
    public double bonus;//to declare data type of bonus.
    public Employee manager;
    public Accountant accountantSupport;
    public int headcount=0;
    public double bonusBudget;

    public Employee(String name, double baseSalary){
        //Should construct a new employee object and take in two parameters,one for the name of the user and one for their base salary.
        this.name=name;
        this.baseSalary=baseSalary;
        counter++;
        this.employeeID=counter;
        // The first ever employee should have an ID of "1", the second "2" and so on. This counter will do the required.
    }

    public double getBaseSalary(){
        return this.baseSalary;
        //Should return the employee's current salary
    }

    public String getName(){
        return this.name;
        //Should return the employee's current name
    }

    public int getEmployeeID(){
        return this.employeeID;
        //Should return the employee's ID. The ID should be issued on behalf of the employee at the time they are constructed.
    }

    public Employee getManager(){
        return manager;
        //Should return a reference to the Employee object that represents this employee's manager.
    }

    public Accountant getAccountantSupport() {
        return accountantSupport;
    }

    public void setManager(Employee manager){
        this.manager=manager;
    }

    public boolean equals(Employee other){
        return this.getEmployeeID()==other.getEmployeeID();
        //Should return true if the two employee IDs are the same, false otherwise
    }

    public String toString(){
        return getEmployeeID()+" "+getName();
        //Should return a String representation of the employee that is a combination of their id followed by their name.Example: "1 Kasey".
    }

    public abstract String employeeStatus();
        //Should return a String representation of that Employee's current status. This will be different for every subclass of Employee
    public void getBonus(){

    }

}
