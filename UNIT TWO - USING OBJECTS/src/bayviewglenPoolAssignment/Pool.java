package bayviewglenPoolAssignment;

import java.util.Scanner;

public class Pool {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //prompts
        System.out.println("Please enter the length of pool in meters: ");
        double length = in.nextDouble();

        System.out.println("Please enter the width in meters: ");
        double width = in.nextDouble();

        System.out.println("Please enter the depth of shallow end in meters: ");
        double heightOfShallowEnd = in.nextDouble();

        System.out.println("Please enter the depth of the deep end in meters: ");
        double heightOfDeepEnd = in.nextDouble();

        System.out.println("Please enter the length of the transition in meters: ");
        double transitionSlope = in.nextDouble();

        System.out.println("Please enter the length of shallow end in meters: ");
        double lengthOfShallowEnd = in.nextDouble();

        System.out.println("Please enter the price of liner per m^2: ");
        double price = in.nextDouble();
        
        //Volume of pool
        double lengthOfDeepEnd = length - transitionSlope - lengthOfShallowEnd;
        double heightOfTransition = heightOfDeepEnd-heightOfShallowEnd;

        double lengthOfTransition = Math.pow(transitionSlope,2) - Math.pow(heightOfTransition, 2);

        double volume = (lengthOfDeepEnd* heightOfDeepEnd*width) + (lengthOfShallowEnd*heightOfShallowEnd*width) 
        + (heightOfShallowEnd*width*lengthOfTransition) + (0.5*heightOfTransition*lengthOfTransition*width);

        double klNeeded = (0.9*volume);

        System.out.println("The amount of water you need to keep the pool at 90% is: " + klNeeded + "Kl");

        //Surface area
        
        double SurfaceArea = ((heightOfDeepEnd*width) + (2*(lengthOfDeepEnd*heightOfDeepEnd)) + (lengthOfDeepEnd*width)) 
        + ((heightOfShallowEnd*width) + (2*(lengthOfShallowEnd*heightOfShallowEnd)) + (lengthOfShallowEnd*width)) + 
        ((transitionSlope*width) + (2*(heightOfTransition*lengthOfTransition)) + (2*(lengthOfTransition*heightOfShallowEnd))); 

        System.out.println("the amount of lining needed is: " + SurfaceArea + "m^2");

        //Cost of liner

        double liner = SurfaceArea*price;

        System.out.println("the price of lining is: " + liner + "$");

        in.close();

    }
}
