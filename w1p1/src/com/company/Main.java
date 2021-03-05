package com.company;

public class Main {
    public static void main(String[] args) {
        int num1 = 1, num2 = 1;

        while(num1 < 11){
            System.out.printf("%2d ", num1 * num2);

            num2++;

            if(num2 == 11){
                num2 = 1;
                num1++;

                System.out.println();
            }
        }

    }
}
