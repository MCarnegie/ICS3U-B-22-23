package assignments;

import java.util.Scanner;


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


       /*displayHand(yourHand, false, "Your Hand: ");
        displayHand(playerOneHand, false, "Player 1: ");
        displayHand(playerTwoHand, false, "Player 2: ");
        displayHand(playerThreeHand, false, "Player 3: ");*/

        
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
        displayHand(playerOneHand, false, "PLayer 1 Hand: ");

        playerTwoHand = NewHand(playerTwoHand);
        displayHand(playerTwoHand, false, "PLayer 2 Hand: ");

        playerThreeHand = NewHand(playerThreeHand);
        displayHand(playerThreeHand, false, "PLayer 3 Hand: ");
        //while(!isOver){

            //it should go like this, after displaying the new hand it should let you do your turn 
            //than display it than make your new hand than display the neww hand with your new score
            // during this secquence it should check to see if your score is equal to 10


            //this should be the same with the npcs except the cards are hidden

        //completes your turn, displays the old hand, caluculates your score, gets your new hand, displays the new hand 
        
        String temp = Turns(yourHand, playerOneHand, playerTwoHand, playerThreeHand, false);
        yourHand = temp.substring(0, temp.indexOf("~"));
        if(yourHand.equals("")){
            yourHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        }
        if(temp.indexOf("!")>=0){
            playerOneHand = temp.substring(temp.indexOf("~") + 1, temp.indexOf("!"));
            if(playerOneHand.equals("")){
                playerOneHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
            }
        }else if(temp.indexOf("@")>=0){
            playerTwoHand = temp.substring(temp.indexOf("~") + 1, temp.indexOf("@"));
            if(playerTwoHand.equals("")){
                playerTwoHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
            }
        }else{
            playerThreeHand = temp.substring(temp.indexOf("~") + 1, temp.indexOf("#"));
            if(playerThreeHand.equals("")){
                playerThreeHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
            }
        }
        displayHand(yourHand, false, "Your Hand: ");
        scoreP = getScore(yourHand, false);
        yourHand = NewHand(yourHand);
        displayHand(yourHand, false, "Your Hand: ");
        System.out.println("Your Score: " + scoreP);

        
        
        
        //gets your score and displays it
        
        /*System.out.println("Your Score: " + scoreP);
        System.out.println("Player 1 Score: " + scoreOne);*/
        
        
       
        
        //}


 
       
        
    }

    

    private static String Turns(String yourHand, String playerOneHand, String playerTwoHand, String playerThreeHand, boolean isComputer) {
       
      
        if(isComputer){

        }else{
         
       
        String whichPlayer = getPlayer();

        String card = getUserCard();
          


            if(whichPlayer.equals("PLAYER 1")){
                yourHand = takeCards(playerOneHand, yourHand, card, true);
                playerOneHand = takeCards(playerOneHand, yourHand, card, false);
                return yourHand + "~" + playerOneHand + "!";
            }else if(whichPlayer.equals("PLAYER 2")){
                yourHand = takeCards(playerTwoHand, yourHand, card, true);
                playerTwoHand = takeCards(playerTwoHand, yourHand, card, false);
                return yourHand + "~" + playerTwoHand + "@";
            }else if(whichPlayer.equals("PLAYER 3")){
                yourHand = takeCards(playerThreeHand, yourHand, card, true);
                playerThreeHand = takeCards(playerThreeHand, yourHand, card, false);
                return yourHand + "~" + playerThreeHand + "#";
            }



       }
        return "SYSTEM OVERLOAD PLEASE RESET IDK WHY THIS IS HAPPENING AHHHHHHHHHHHHHHHHHHHHHH IF YOU SEE THIS DURING THE GAME MR.D THIS SHOULD NEVER HAPPEN PLEASE DONT GIVE ME A 0%!!!!!";



        
    }



    private static String getUserCard() {
        
        while(true){
            System.out.println("What card do you want?");
            String card = in.nextLine().toUpperCase();
            if(card.equals("10")){
                card = "1";
            }
            if("123456789JQKA".indexOf(card)>=0){
                return card;
            }else{
                System.out.println("invalid card");
            }
        }
    }



    private static String getPlayer() {
        
        while(true){
            System.out.println("Which player do you want to ask? (Player 1, Player 2, or Player 3)");
            String whichPlayer = in.nextLine().toUpperCase();
            if(whichPlayer.equals("PLAYER 1") || whichPlayer.equals("PLAYER 2") || whichPlayer.equals("PLAYER 3")){
                return whichPlayer;
            }else{
                System.out.println("invalid player");
            }
        }
    }



    private static String takeCards(String computerHand, String yourHand, String card, boolean isCurrentPlayerHand) {

             
                for(int i = 0; i<computerHand.length(); i++){
                    String s = computerHand.substring(i, i+1);
                    if(card.equals(s)){

                        if(card.equals("1")){
                            computerHand = computerHand.substring(0, computerHand.indexOf(card)) + computerHand.substring(computerHand.indexOf(card)+3);
                            computerHand = fixSpaces(computerHand);
                            yourHand = yourHand + " " + card + "0" + getSuit();
                            
                        }else{

                        computerHand = computerHand.substring(0, computerHand.indexOf(card)) + computerHand.substring(computerHand.indexOf(card)+2);
                        computerHand = fixSpaces(computerHand);
                        yourHand = yourHand + " " + card + getSuit();
                        
                        }



                    }else if(i == computerHand.length()){
                        yourHand = yourHand + " " + getCard();
                    }


                }

                if(isCurrentPlayerHand){
                    return yourHand;
                }else{
                    return computerHand;
                }

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

        firstHand = fixSpaces(firstHand);
        
        




        
        return firstHand;

    }

    private static String fixSpaces(String firstHand) {
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

