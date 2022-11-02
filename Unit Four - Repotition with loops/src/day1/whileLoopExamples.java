package day1;

import java.util.Scanner;

public class whileLoopExamples {
   public static void main(String[] args) {
        //exampleOne();
        //exampleTwo();
        //exampleThree();
        //exampleFour();
        exampleFive();
    }

    

    /*
    * Introduction to While Loops - Keep asking for a number until the number is
    * even.
    */
    private static void exampleOne() {
    /*
        // Syntax of while loop
        while (condition){
            //do this code
        }

        // Syntax of if statement
        if(condition){
            //do this code
        }
    */


        Scanner in = new Scanner(System.in);

        System.out.println("Please input a number (even to quit): ");
        int number = in.nextInt();
        
        while(number%2!=0){
            System.out.println("Please input a number (even to quit): ");
            number = in.nextInt();
        }


    }

    /* Sum the numbers from 1 to 1000 using a while loop */
    private static void exampleTwo() {
        int currNum = 0;
        int sum = 0;

        while (currNum <= 1000){
            sum += currNum;
            currNum += 1;
        }

        System.out.println(sum);
    }

    /*
    * Prompt the user for a number and add it to a sum. Continue as long as the
    * number is positive
    */
    private static void exampleThree() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please input a number (negative to quit): ");
        int number = in.nextInt();
        int sum = 0;

        while(number > 0){
        sum += number;
        System.out.println("Please input a number (negative to quit): ");
        number = in.nextInt();
        }
    }

    /* Prompt the user for a String and count the number of vowels in the String. */
    private static void exampleFour() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input a string: ");
        String text = in.nextLine();
        
        int index = 0;
        int countVowels = 0;

        while(index < text.length()){
            String nextLetter = text.substring(index, index + 1);
            if("aeiou".indexOf(nextLetter.toLowerCase())>=0){
                countVowels += 1;
                
            }
            index += 1;
        }

        System.out.println(countVowels);
    }

    /*find the percentage of even numbers when you get 1000 random numbers 1-100 */
    private static void exampleFive() {
        
        int numEven = 0;
        int numRandomNumbers = 1000;
        int i = 0;

        while(i<numRandomNumbers){
            int ran = (int)(Math.random()*100) + 1;
            if(ran % 2 == 0)
                numEven++;
            i++;
        }

        System.out.println((double)numEven / numRandomNumbers * 100 + "%");
    }

}