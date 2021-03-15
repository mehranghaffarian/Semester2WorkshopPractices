package com.company;

public class Lab {
    private String name;
    private Student[] students = new Student[30];
    private double avg;
    private String day;
    private int capacity;
    private int currentSize;

    /**
     * it would save the
     * @param cap determines the capacity of the lab
     * @param d determines the day of the enrollment
     * */
    public Lab(String name, int cap, String d) {
        this.name = name;
        capacity = cap;
        currentSize = 0;
        day = d;
    }

    public String getName(){
        return name;
    }

    /**
     * it would save the students info
     * @param std is the info of the student to re
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        }
        else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * print the students info
     */
    public void print() {
        for (int i = 0;i < currentSize;i++) {
            System.out.printf("%d. ", i + 1);
            students[i].print();
        }
    }

    public void printLab(){
        System.out.printf("%s : average: %.2f", name, avg);
        System.out.println(", capacity:" + capacity + ", current size:" + currentSize + ", day:" + day);
    }

    /**
     * @return gives the access to the whole students info
     * */
    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        for(int i = 0;i < students.length;i++)
            this.students[i] = students[i];
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public double getAvg() {
        avg = 0;

        for (int i = 0;i < currentSize;i++)
            avg += students[i].getAverage();

        if (currentSize != 0)
            avg /= currentSize;

        return avg;
    }

    public void calculateAvg() {
        for (int i = 0;i < currentSize;i++)
            avg += students[i].getAverage();

        if (currentSize != 0)
            avg /= currentSize;

        System.out.println(avg);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCurrentSize(int curr){
        currentSize = curr;
    }
}
