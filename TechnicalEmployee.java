/*
Comments is referring to which question of assignment/task are and
Comments also indicates what are the task being done for
 */

public class TechnicalEmployee extends Employee {
    //this to inherit class Employee
    public int checkins;// to declare the data type for check ins counter

    public TechnicalEmployee(String name){
        super(name,75000.00);
        //Has a default base salary of 75000
        checkins=0;
        //to zerorise the checkins value
    }

    public String employeeStatus(){
        return super.toString()+" has "+checkins+" successful check ins";
        //Should return a String representation of this TechnicalEmployee that includes their ID, name and how many successful check ins they have had. Example: "1 Kasey has 10 successful check ins".
    }

    public void setCheckin(){
        checkins++;
        //counter for check ins
    }

}
