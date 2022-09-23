package day5;

public class QuestionOne {
    public static void main(String[] args) {
        double price = 985;
        double tax = 985*0.055;

        double total = price+tax;

        double total2 = Math.round(total*100)/100.0;

        System.out.println("your total is: " + total2 + "$");

    }
}
