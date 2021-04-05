package com.company;

import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        LocalDateTime realTime = LocalDateTime.now();

        ClockDisplay clock = new ClockDisplay();
        int choice;

        System.out.println("if you want to set a new clock enter 1 if you want to observe the real time enter 2");
        choice = scan.nextInt();

        if (choice == 1){
            System.out.println("please enter the hour, minute and second respectively");
            int hour = 1, minute = 1, second = 1;

            do{
                if(clock.setTime(hour, minute, second) == 0)
                    System.out.println("your input is not valid try again");

                hour = scan.nextInt();
                minute = scan.nextInt();
                second = scan.nextInt();
            }while(clock.setTime(hour, minute, second) == 0);

            clock.setTime(hour, minute, second);
        }
        else
            clock.setTime(realTime.getHour(), realTime.getMinute(), realTime.getSecond());

        for(int i = 1;i < 31;i++){
            Thread.sleep(1000);

            clock.timeTick();

            System.out.println(clock.getTime());
        }
    }
}















