package day5;

public class QuestionFour {
    public static void main(String[] args) {

        double secondsInYear = 525600*60;

        double a = 10;
        double b = 8;

        double meterInYear = secondsInYear*(3*Math.pow(a, b));

        System.out.println("the amount of meters light travels in a year is " + meterInYear);

       
    }
}
