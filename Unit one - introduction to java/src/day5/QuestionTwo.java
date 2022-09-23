package day5;

public class QuestionTwo {
    public static void main(String[] args) {
        double width = 2.3;
        double length = 4.5;

        double area = width*length;
        double perimeter = (width*2) + (length*2);

        double areat = (double) Math.round(area*10)/10;
        double perimetert = (double) Math.round(perimeter*10)/10;

        System.out.println("your total area is " + areat + " your total perimeter is: " + perimetert);
    }
}
