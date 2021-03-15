package com.company;

public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private double gradeMath;
    private double gradeAP;
    private double average;

    /**
     * Create a new student with a given name and ID number.
     * @param fName first name of student
     * @param lname last name of student
     * @param sID student ID
     */
    public Student(String fName, String lname, String sID, double gradeAP, double gradeMath) {
        firstName = fName;
        lastName = lname;
        id = sID;
        this.gradeMath = gradeMath;
        this.gradeAP = gradeAP;
        average = (gradeAP + gradeMath) / 2;
    }

    /**
     * @return firstName field
     * get the first name of student
     */
    public String getFirstName() {
        System.out.println("dadash vared kon");
        return firstName;
    }

    /**
     * @param string set string of a student info
     */
    public void setString(int choice, String string) {
        if(choice == 1)
            firstName = string;

        else if (choice == 2)
            lastName = string;

        else
            id =  string;
    }

    /**
     * @param choice will would determine which grade should alter for the student
     * @param grade will be changed for the student base on the user decision
     */
    public void setGrade(int choice, double grade){
        if (choice == 1)
            gradeMath = grade;

        else
            gradeAP = grade;
    }

    /**
     * @return average of the student
     * */
    public double getAverage(){
        return average;
    }

    /**
     * Print the student’s last name and ID number to the output terminal.
     */
    public void print() {
        System.out.printf("%s %s student ID:%S, Math%.2f, AP:%.2f, average:%.2f\n\n", firstName, lastName, id, gradeMath, gradeAP, average);
    }
}