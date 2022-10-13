package bayviewglenPoolAssignment;

import java.util.Scanner;

public class Pool {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //prompts
        System.out.println("Please enter the length of pool in meters: ");
        double l = in.nextDouble();

        System.out.println("Please enter the width in meters: ");
        double w = in.nextDouble();

        System.out.println("Please enter the depth of shallow end in meters: ");
        double hSallow = in.nextDouble();

        System.out.println("Please enter the depth of the deep end in meters: ");
        double hDeep = in.nextDouble();

        System.out.println("Please enter the length of the transition in meters: ");
        double trans = in.nextDouble();

        System.out.println("Please enter the length of shallow end in meters: ");
        double lOfShallow = in.nextDouble();

        System.out.println("Please enter the price of liner per m^2: ");
        double price = in.nextDouble();
        
        //Volume of pool
        double lOfDeep = l - trans - lOfShallow;
        double hOfTrans = hDeep-hSallow;

        double lOfTrans = Math.pow(trans,2) - Math.pow(hOfTrans, 2);

        double volume = (lOfDeep* hDeep*w) + (lOfShallow*hSallow*w) + (hSallow*w*lOfTrans)
         + (0.5*hOfTrans*lOfTrans*w);

        double lNeeded = (0.9*volume);

        System.out.println("The amount of water you need to keep the pool at 90% is: " + lNeeded + "Kl");

        //Surface area
        
        double SurfaceArea = ((hDeep*w) + (2*(lOfDeep*hDeep)) + (lOfDeep*w)) 
        + ((hSallow*w) + (2*(lOfShallow*hSallow)) + (lOfShallow*w)) + 
        ((trans*w) + (2*(hOfTrans*lOfTrans)) + (2*(lOfTrans*hSallow))); 

        System.out.println("the amount of lining needed is: " + SurfaceArea + "m^2");

        //Cost of liner

        double liner = SurfaceArea*price;

        System.out.println("the price of lining is: " + liner + "$");

        in.close();

    }
}
