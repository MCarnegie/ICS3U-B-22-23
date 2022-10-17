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
        
        //volume of pool
        double heightOfTransition = (double) heightOfDeepEnd-heightOfShallowEnd;
        double lengthOfTransition = Math.sqrt((double) Math.pow(transitionSlope,2) - (double) Math.pow(heightOfTransition, 2));
        double lengthOfDeepEnd = (double)length - lengthOfTransition - lengthOfShallowEnd;

        double volume = (lengthOfDeepEnd*heightOfDeepEnd*width) + (lengthOfShallowEnd*heightOfShallowEnd*width) 
        + (heightOfShallowEnd*width*lengthOfTransition) + (0.5*heightOfTransition*lengthOfTransition*width);
        /*
         * calculates the volume of the pool by getting the volume of the deep end, 
         * the shallow end, the square area above the transition, and the transition.
         */

        double lNeeded = 1000*(volume*0.9);
        double lNeededRounded = Math.round(lNeeded*100)/100.0;
        //rounds the volume to two decimal points

        System.out.println("The amount of water you need to keep the pool at 90% is: " + lNeededRounded + "L");

        //Surface area  
        double SurfaceArea = ((heightOfDeepEnd*width) + (2*(lengthOfDeepEnd*heightOfDeepEnd)) + (lengthOfDeepEnd*width)) 
        + ((heightOfShallowEnd*width) + (2*(lengthOfShallowEnd*heightOfShallowEnd)) + (lengthOfShallowEnd*width)) + 
        ((transitionSlope*width) + (2*(heightOfTransition*lengthOfTransition)/2) + (2*(lengthOfTransition*heightOfShallowEnd))); 

        /*
         * calculates the surface area by getting the surface area of the deep end, transition, and shallow end.
         */

        double SurfaceAreaRounded = Math.round(SurfaceArea*100)/100.0;
        //rounds the surface area to two decimal points

        System.out.println("the amount of lining needed is: " + SurfaceAreaRounded + "m^2");

        //Cost of liner
        double liner = SurfaceAreaRounded*price;
        //calculates the price of liner by getting the surface area rounded multiplied by the price of lienr per m^2
        
        System.out.println("the price of lining is: " + liner + "$");

        in.close();

    }
}
