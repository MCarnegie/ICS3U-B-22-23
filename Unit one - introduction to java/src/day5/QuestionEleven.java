package day5;

import java.util.Scanner;

public class QuestionEleven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input the mass of your object in kg: ");
        double mass = in.nextDouble();
        
        System.out.println();
        
        System.out.print("Input the speed in m/s: ");
        double speed = in.nextDouble();

        double keneticEnergy = (1.0/2)*mass*(Math.pow(speed, 2));

        System.out.println("the kenetic energy of your object is: " + keneticEnergy + "J");
        
        in.close();

    }
}
