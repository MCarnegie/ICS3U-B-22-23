package day5;

import java.util.Scanner;

public class QuestionNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please Enter the amount of sales: ");
        double sales = in.nextDouble();

        double pay = 0.27*sales;

        System.out.println("Your pay for the day is: " + pay + "$");
        in.close();
    }
}
