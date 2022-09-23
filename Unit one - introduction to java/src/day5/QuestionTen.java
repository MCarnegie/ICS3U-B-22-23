package day5;

import java.util.Scanner;


public class QuestionTen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input your length in meters: ");
        double length = in.nextDouble();

        System.out.println();
        System.out.print("Input your width in meters: ");
        double width = in.nextDouble();

        double perimeter = (length*2) + (width*2);
        double area = length*width;

        System.out.println("your perimeter is: " + perimeter );
        System.out.println("your area is: " + area);

        in.close();
    }
}
