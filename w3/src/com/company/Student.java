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
     * @param fName set first name of a student
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * @param gradeAP will be changed for the student
     * @param gradeMath will be changed for the student
     */
    public void setGrade(double gradeAP, double gradeMath){
        this.gradeAP = gradeAP;
        this.gradeMath = gradeMath;
        average = (gradeMath + gradeAP) / 2;
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