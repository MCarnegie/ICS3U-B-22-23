package day5;

import java.util.Scanner;

public class exampleTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("please enter a decimal number ");

        double number = in.nextDouble();

        number = Math.round(number * 100)/100.0;
        System.out.println(number);

        System.out.println("please enter a number greater than 100 ");
        int inumber = in.nextInt();
        inumber = (int) Math.round(inumber/100.0) * 100;

        System.out.println("rounded" + inumber);
    }
}
