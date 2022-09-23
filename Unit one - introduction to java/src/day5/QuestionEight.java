package day5;

import java.util.Scanner;

public class QuestionEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the positive number ");
        double number = in.nextDouble();

        double sqaure = number*number;
        double squareRoot = Math.sqrt(number);

        double round = Math.round(sqaure*10)/10.0;
        double round2 = Math.round(squareRoot*10)/10.0;

        System.out.println("the sqaure of your number is: " + round);
        System.out.println("the sqaure root of your number is: " + round2);

        in.close();
    }
}
