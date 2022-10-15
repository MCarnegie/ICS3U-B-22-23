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
        double heightOfTransition = (double) heightOfDeepEnd-heightOfShallowEnd;
        double aSquaredMinusBsquared = (double) Math.pow(transitionSlope,2) - (double) Math.pow(heightOfTransition, 2);
        double lengthOfTransition = Math.sqrt(aSquaredMinusBsquared);
        double lengthOfDeepEnd = (double)length - (double)lengthOfTransition - (double)lengthOfShallowEnd;
        

        

        double volume = (lengthOfDeepEnd* heightOfDeepEnd*width) + (lengthOfShallowEnd*heightOfShallowEnd*width) 
        + (heightOfShallowEnd*width*lengthOfTransition) + (0.5*heightOfTransition*lengthOfTransition*width);

        double lNeeded = 1000*(volume*0.9);
        double lNeededRounded = Math.round(lNeeded*100)/100.0;

        System.out.println("The amount of water you need to keep the pool at 90% is: " + lNeededRounded + "L");

        //Surface area
        
        double SurfaceArea = ((heightOfDeepEnd*width) + (2*(lengthOfDeepEnd*heightOfDeepEnd)) + (lengthOfDeepEnd*width)) 
        + ((heightOfShallowEnd*width) + (2*(lengthOfShallowEnd*heightOfShallowEnd*0.5)) + (lengthOfShallowEnd*width)) + 
        ((transitionSlope*width) + (2*(heightOfTransition*lengthOfTransition)) + (2*(lengthOfTransition*heightOfShallowEnd))); 

        double SurfaceAreaRounded = Math.round(SurfaceArea);

        System.out.println("the amount of lining needed is: " + SurfaceArea + "m^2");

        //Cost of liner

        double liner = SurfaceAreaRounded*price;

        System.out.println("the price of lining is: " + liner + "$");

        in.close();

    }
}
