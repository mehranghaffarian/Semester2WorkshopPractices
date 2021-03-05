package com.company;

public class Main {

    public static void main(String[] args) {
        int num1 = 11, num2 = 26, counter = 2;

        while(counter <= num1){
            if(num1 % counter == 0 && num2 % counter == 0){
                System.out.println("false");
                return;
                }

            counter++;
        }

            System.out.println("true");
    }
}
