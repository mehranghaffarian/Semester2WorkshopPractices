package com.company;

public class Faculty {
    private String name;
    private Lab[] labs = new Lab[15];
    private double average;
    private int capacity;
    private int currentSize;

    public Faculty(String name, int cap){
        this.name = name;
        capacity = cap;
        currentSize = 0;
    }

    public void labEnrollment(Lab lab){
        if(currentSize < capacity){
            labs[currentSize] = lab;
            currentSize++;
        }
        else
            System.out.println("the faculty is full??!!");
    }

    public Lab getLabs(int labIndex){
        return labs[labIndex];
    }

    public void creatLab(Lab lab){
        if(currentSize < capacity) {
            labs[currentSize] = lab;
            currentSize++;
        }
        else
            System.out.println("the " + name + " faculty is full");
    }

    public double getAverage(){
        average = 0;

        for(int i = 0;i < currentSize;i++)
            average += labs[i].getAvg();

        if(currentSize != 0)
        average /= currentSize;

        return average;
    }

    public Lab[] getLabsArray(){
        return labs;
    }

    public int getCap(){
        return capacity;
    }

    public void printFac(){
        System.out.printf("%s: average:%.2f", name, getAverage());
        System.out.println(", capacity:" + capacity + ", current size:" + currentSize);
    }

    public void printLabs(){
        for(int i = 0;i < currentSize;i++)
            System.out.println(labs[i].getName());
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public void setCurrentSize(int curr){
        currentSize = curr;
    }
}
