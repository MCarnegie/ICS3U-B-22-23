package day1;

public class DieGame {
    public static void main(String[] args) {
        Die die = new Die(6);
        Die die2 = new Die();


        int num1Wins = 0;
        int num2Wins = 0;
        int ties = 0;
        for (int i = 0; i < 100000; i++) {
            
           die.roll(); 
           die2.roll();
/*
           System.out.print("Die 1: ");
           System.out.println(die); //when we print the die we call its toString method
           System.out.print("Die 2: ");
           System.out.println(die2);
*/
           if(die.getTopSide()>die2.getTopSide()){
            num1Wins++;
           }else if(die2.getTopSide()>die.getTopSide()){
            num2Wins++;
           }else{
            ties++;
           }

        }

        System.out.println("1: " + num1Wins);
        System.out.println("2: " + num2Wins);
        System.out.println("ties: " + ties);
    }
}
