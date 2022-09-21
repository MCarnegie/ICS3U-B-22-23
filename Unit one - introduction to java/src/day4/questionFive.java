package day4;

public class questionFive {
    public static void main(String[] args) {
        /*calculate users change */

        double totalpenny = 28;
        double totalnickel = 12;
        double totaldime = 7;
        double totalquarter = 8;
        double totalloonie = 4;
        double totaltoonie = 207;

        double total = (totalpenny*0.01) + (totalnickel*0.05) + (totaldime*0.10) + (totalquarter*0.25) + (totalloonie) + (totaltoonie*2);


        System.out.println("your total change is " + total);
    }
}
