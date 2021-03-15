package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choiceFac = 1, choiceLab, choiceStudent, addFac;

        Faculty[] facs = new Faculty[10];
        int currentSize = 0;

        Student std1 = new Student("Ehsan", "Edalat", "9031066", 18, 15.12);
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806", 17.25, 16);
        Student std3 = new Student("Ahmad", "Asadi", "9031054", 13, 14.49);

        Lab lab1 = new Lab("AP", 10, "sunday");
        Lab lab2 = new Lab("Math", 15, "monday");
        Lab lab3 = new Lab("Physics", 20, "friday");

        lab1.enrollStudent(std1);
        lab2.enrollStudent(std2);
        lab3.enrollStudent(std3);

        Faculty  fac1 = new Faculty("Computer Engineering", 10);
        Faculty  fac2 = new Faculty("Mathematics", 10);
        Faculty  fac3 = new Faculty("Mechanic", 10);

        facs[0] = fac1;
        facs[1] = fac2;
        facs[2] = fac3;

        facs[0].labEnrollment(lab1);
        facs[1].labEnrollment(lab2);
        facs[2].labEnrollment(lab3);

        currentSize = 3;

        while(choiceFac != 0){
            System.out.println("if you want to exit enter 0.\nif you want to add a faculty enter 1, if not enter 2");
            addFac = scan.nextInt();

            if(addFac == 0)
                return;

            else if(addFac == 1){
                if(currentSize < 10){
                    System.out.println("please enter the faculty name");
                    scan.nextLine();
                    String addName = scan.nextLine();

                    System.out.println("\nplease enter the faculty capacity");
                    int cap = scan.nextInt();

                    Faculty fac = new Faculty(addName, cap);

                    facs[currentSize] = fac;

                    System.out.println("faculty added successfully");
                    currentSize++;
                }
                else
                    System.out.println("the university is full of faculties");
            }

            System.out.println("the faculties are as bellow");
            for (int i = 0;i < currentSize;i++) {
                System.out.printf("%d. ", i + 1);
                facs[i].printFac();
            }

            System.out.println("please choose a faculty:");
            choiceFac = scan.nextInt();

            if(choiceFac == 0)
                return;

            System.out.println("the labs are as bellow");
            for (int i = 0;i < facs[choiceFac - 1].getCurrentSize();i++){
                System.out.printf("%d. ", i + 1);
                facs[choiceFac - 1].getLabs(i).printLab();
            }

            System.out.println("if you wnt to add a lab enter 1, if not enter 2");
            int addLab = scan.nextInt();

            if(addLab == 0)
                return;

            else if (addLab == 1){
                if(facs[choiceFac - 1].getCurrentSize() < facs[choiceFac - 1].getCap())
                {
                    System.out.println("please enter the name of the lab:");
                    scan.nextLine();
                    String name = scan.nextLine();

                    System.out.println("please enter the capacity of the lab:");
                    int cap = scan.nextInt();

                    System.out.println("please enter the day of the lab:");
                    scan.nextLine();
                    String day = scan.nextLine();

                    Lab lab = new Lab(name, cap, day);

                    facs[choiceFac - 1].creatLab(lab);
                }
                else
                    System.out.println("the faculty is full of labs");
            }

            System.out.println("please choose a lab:");
            choiceLab = scan.nextInt();

            if(choiceLab == 0)
                return;

            System.out.println("choose from\n1. change the name of the lab\n2. change the day of the lab\n3. change the capacity of the lab\n4. adding a student\n5. printing the students list");
            int choice  = scan.nextInt();

            if (choice == 0)
                return;

            if(choice == 1){
                System.out.println("please enter the new name for the lab");
                scan.nextLine();

                facs[choiceFac - 1].getLabs(choiceLab - 1).setName(scan.nextLine());
            }
            else if(choice == 2){
                System.out.println("please enter the new day for the lab");
                scan.nextLine();

                facs[choiceFac - 1].getLabs(choiceLab - 1).setDay(scan.nextLine());
            }
            else if(choice == 3){
                System.out.println("please enter the new capacity for the lab");
                facs[choiceFac - 1].getLabs(choiceLab - 1).setCapacity(scan.nextInt());
            }

            else if (choice == 4){
                if(facs[choiceFac - 1].getLabsArray()[choiceLab - 1].getCurrentSize() < facs[choiceFac - 1].getLabsArray()[choiceLab - 1].getCapacity())
                {
                    System.out.println("please enter the:\nstudent first name\nstudent last name\nstudent ID\nstudent AP grade\nstudent math grade");
                    scan.nextLine();

                    Student std = new Student(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextDouble(), scan.nextDouble());

                    facs[choiceFac - 1].getLabsArray()[choiceLab - 1].getStudents()[facs[choiceFac - 1].getLabsArray()[choiceLab - 1].getCurrentSize()] = std;
                    facs[choiceFac - 1].getLabsArray()[choiceLab - 1].setCurrentSize(facs[choiceFac - 1].getLabsArray()[choiceLab - 1].getCurrentSize() + 1);

                    System.out.println("the student added successfully");
                }
                else
                    System.out.println("the lab is full of students");
            }

            else if(choice == 5){
                facs[choiceFac - 1].getLabs(choiceLab - 1).print();

                System.out.println("please choose a student if you want to change the student info if not enter 2");
                choiceStudent = scan.nextInt();

                if(choiceStudent == 0)
                    return;

                if(choiceStudent == 1) {
                    System.out.println("what do you want to change\n1. Math grade\n2. AP grade\n3. first name\n4. last name\n5. ID number");

                    choice = scan.nextInt();

                    if (choice == 0)
                        return;

                    else if (choice == 1){
                        System.out.println("please enter the new Math grade");
                        facs[choiceFac - 1].getLabs(choiceLab - 1).getStudents()[choiceStudent - 1].setGrade(1, scan.nextDouble());
                    }
                    else if (choice == 2){
                        System.out.println("please enter the new AP grade");
                        facs[choiceFac - 1].getLabs(choiceLab - 1).getStudents()[choiceStudent - 1].setGrade(2, scan.nextDouble());
                    }
                    else if (choice == 3){
                        System.out.println("please enter the new first name");
                        scan.nextLine();

                        facs[choiceFac - 1].getLabs(choiceLab - 1).getStudents()[choiceStudent - 1].setString(1, scan.nextLine());
                    }
                    else if (choice == 4){
                        System.out.println("please enter the new last name");
                        scan.nextLine();

                        facs[choiceFac - 1].getLabs(choiceLab - 1).getStudents()[choiceStudent - 1].setString(2, scan.nextLine());
                    }
                    else if (choice == 5){
                        System.out.println("please enter the new ID");
                        scan.nextLine();

                        facs[choiceFac - 1].getLabs(choiceLab - 1).getStudents()[choiceStudent - 1].setString(3, scan.nextLine());
                    }

                    System.out.println("the info changed successfully");
                }
            }
        }
    }
}