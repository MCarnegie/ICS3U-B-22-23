package assignments;

import java.util.Scanner;

import javax.swing.plaf.TreeUI;

public class GoFish {
    static Scanner in = new Scanner(System.in);
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final int NUM_VALUES = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    public static void main(String[] args) {
        boolean isOver = true;
        String yourHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        String playerOneHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        String playerTwoHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        String playerThreeHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();


        displayHand(yourHand, false, "Your Hand: ");
        displayHand(playerOneHand, true, "Player 1: ");
        displayHand(playerTwoHand, true, "Player 2: ");
        displayHand(playerThreeHand, true, "Player 3: ");

        
        int scoreP = getScore(yourHand, true);
        int scoreOne = getScore(playerOneHand, true);
        int scoreTwo = getScore(playerTwoHand, true);
        int scoreThree = getScore(playerThreeHand, true);

        System.out.println("Your Score: " + scoreP);
        System.out.println("Player 1 Score: " + scoreOne);
        System.out.println("Player 2 Score: " + scoreTwo);
        System.out.println("Player 3 Score: " + scoreThree);

        
        
        
        yourHand = NewHand(yourHand);
        displayHand(yourHand, false, "Your Hand: ");
        
        playerOneHand = NewHand(playerOneHand);
        displayHand(playerOneHand, true, "PLayer 1 Hand: ");

        playerTwoHand = NewHand(playerTwoHand);
        displayHand(playerTwoHand, true, "PLayer 2 Hand: ");

        playerThreeHand = NewHand(playerThreeHand);
        displayHand(playerThreeHand, true, "PLayer 2 Hand: ");
        //while(!isOver){

            //it should go like this, after displaying the new hand it should let you do your turn 
            //than display it than make your new hand than display the neww hand with your new score
            // during this secquence it should check to see if your score is equal to 10


            //this should be the same with the npcs except the cards are hidden

        //completes your turn, displays the old hand, caluculates your score, gets your new hand, displays the new hand 
        yourHand = Turns(yourHand, false);
        displayHand(yourHand, false, "Your Hand: ");
        scoreP = getScore(yourHand, false);
        yourHand = NewHand(yourHand);
        displayHand(yourHand, false, "Your Hand: ");

        playerOneHand = Turns(playerOneHand, false);
        displayHand(playerOneHand, false, "Your Hand: ");
        scoreOne = getScore(playerOneHand, true);
        playerOneHand = NewHand(playerOneHand);
        displayHand(playerOneHand, false, "Your Hand: ");
        
        
        //gets your score and displays it
        
        System.out.println("Your Score: " + scoreP);
        System.out.println("Player 1 Score: " + scoreOne);
        
        
       
        
        //}


 
        //playerTurn();
        //computerTurn();
        
    }

    

    private static String Turns(String cards, boolean isComputer) {
       if(isComputer){

       }else{

       }



        return "hi";
    }



    private static String NewHand(String cards) {
        String firstHand = cards;
       
        
        
        
        for(int i = 0; i<cards.length(); i++){
            String s = cards.substring(i, i+1);
            String restOf = cards.substring(i+1);
            if("JQK1A".indexOf(s)>=0){
                if(restOf.indexOf(s)>=0){
                    String newHand = "";
                    int location1 = cards.indexOf(s);
                    int location2 = cards.lastIndexOf(s);

                    if(s.equals("1")){
                    newHand = cards.substring(0, location1) + cards.substring(location1+3, location2) + cards.substring(location2+3);
                    }else{
                    newHand = cards.substring(0, location1) + cards.substring(location1+2, location2) + cards.substring(location2+2);
                    }
                    
                    cards = newHand;
                    i = 0; 
                    
                    
                }
            }else if("23456789".indexOf(s) >= 0){
                if(restOf.indexOf(s)>=0){
                    int location1 = cards.indexOf(s);
                    int location2 = cards.lastIndexOf(s);

                    String newHand = cards.substring(0, location1) + cards.substring(location1+2, location2) + cards.substring(location2+2);
                    cards = newHand;
                    i = 0; 
                }
            }
                


        }
        
        firstHand = cards;
        
        for(int b = 0; b<firstHand.length()-1; b++){
            String letter = firstHand.substring(b, b+1);
            String letter2 = firstHand.substring(b+1, b+2);
            if(letter.equals(" ") && letter2.equals(" ")){
                if(firstHand.indexOf(letter) == 0){
                    firstHand = firstHand.substring(1);
                    if(firstHand.indexOf(" ") == 0){
                        firstHand = firstHand.substring(1);
                        b = 0;
                    }else{
                    b = 0;
                    }
                }else{
                firstHand = firstHand.substring(0,b+1) + firstHand.substring(b+2);
                b = 0;
                }
            }else if(letter.equals(" ")){
                if(firstHand.indexOf(letter) == 0){
                    firstHand = firstHand.substring(1);
                    if(firstHand.indexOf(" ") == 0){
                        firstHand = firstHand.substring(1);
                        b = 0;
                    }else{
                    b = 0;
                    }
                }
            }
        }




        
        return firstHand;

    }

    private static int getScore(String cards, boolean isFirstTurn) {
       int score = 0;

        for(int i = 0; i<cards.length(); i++){
            String s = cards.substring(i, i+1);
            String restOf = cards.substring(i+1);
            if("JQK1A".indexOf(s)>=0){
                if(restOf.indexOf(s)>=0){
                    score++;
                }
            }else if("23456789".indexOf(s) >= 0){
                if(restOf.indexOf(s)>=0){
                    score++;
                }
            }
                


        }
        if(score>=3 && isFirstTurn){
            score--;
        }

        return score;
    }

    private static void displayHand(String cards, boolean isHidden, String label) {
        String botHand = "";
        if(isHidden){
           for(int i = 0; i<cards.length()-1; i++){
            String letter1 = cards.substring(i, i+1);
            String letter2 = cards.substring(i+1, i+2);
            if("023456789JQKHDCSA".indexOf(letter1)>=0 && "023456789JQKHDCSA".indexOf(letter2)>=0){
                botHand += "XX" + " ";
            }


           } 

           System.out.println(label + botHand);
        }else{
            System.out.println(label + cards);
        }

        
    }


    private static String getCard() {
        return getValue() + getSuit();
    }

    private static String getSuit() {
        int iSuit = (int) (Math.random()* NUM_SUITS) + 1;
        if(iSuit == 1)
            return HEARTS;
        else if(iSuit == 2)
            return SPADES;
        else if(iSuit == 3)
            return CLUBS;
        else
            return DIAMONDS;

    }

    private static String getValue() {
        int iValue = (int)(Math.random()* NUM_VALUES) + 1;

        if(iValue == 1)
            return ACE;
        else if(iValue == 11)
            return JACK;
        else if(iValue == 12)
            return QUEEN;
        else if(iValue == 13)
            return KING;
        else
            return "" + iValue;

        
    }

}
