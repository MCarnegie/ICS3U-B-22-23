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
    static String yourHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static String playerOneHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static String playerTwoHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static String playerThreeHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static int scoreP = 0;
    static int scoreOne = 0;
    static int scoreTwo = 0;
    static int scoreThree = 0;
    
    public static void main(String[] args) {
        boolean isOver = true;
        
        scoreP = getScore(yourHand, true, scoreP);
        scoreOne = getScore(playerOneHand, true, scoreOne);
        scoreTwo = getScore(playerTwoHand, true, scoreTwo);
        scoreThree = getScore(playerThreeHand, true, scoreThree);

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

        System.out.println("--------------------------------------------");
        
        yourTurn();
        System.out.println("--------------------------------------------");
        /*playerOneTurn();
        System.out.println("--------------------------------------------");
        playerTwoTurn();
        System.out.println("--------------------------------------------");
        playerThreeTurn();*/
       

    }

    private static void yourTurn(){
        String whichPlayer = getPlayer(false, false, false);
        String card = getUserCard(false, false, false);
        takeCards(whichPlayer, yourHand, card);
        scoreP = getScore(yourHand, false, scoreP);
        yourHand = NewHand(yourHand);
        displayAll();

    }

    private static void displayAll(){
        displayHand(yourHand, false, "Your Hand: ");
        displayHand(playerOneHand, false, "Player 1 Hand: ");
        displayHand(playerTwoHand, false, "Player 2 Hand: ");
        displayHand(playerThreeHand, false, "Player 3 Hand: ");
        System.out.println("your score: " + scoreP);
        System.out.println("Player 1 score: " + scoreOne);
        System.out.println("Player 2 score: " + scoreTwo);
        System.out.println("Player 3 score: " + scoreThree);
    }

    private static String getUserCard(boolean isP1, boolean isP2, boolean isP3) {
        if(isP1 || isP2 || isP3){
            if(isP1){
                String tempHand = "";
                for (int i = 0; i < playerOneHand.length(); i++) {
                    String s = playerOneHand.substring(i, i+1);
                    
                    if("123456789JQKA".indexOf(s)>=0){
                        tempHand += s;
                    }
                }
                int ran = (int) (Math.random()*tempHand.length());
                return tempHand.substring(ran, ran+1);
            }else if(isP2){
                String tempHand = "";
                for (int i = 0; i < playerTwoHand.length(); i++) {
                    String s = playerTwoHand.substring(i, i+1);
                    
                    if("123456789JQKA".indexOf(s)>=0){
                        tempHand += s;
                    }
                }
                int ran = (int) (Math.random()*tempHand.length());
                return tempHand.substring(ran, ran+1);
            }else{
                String tempHand = "";
                for (int i = 0; i < playerThreeHand.length(); i++) {
                    String s = playerThreeHand.substring(i, i+1);
                    if("123456789JQKA".indexOf(s)>=0){
                        tempHand += s;
                    }
                }
                int ran = (int) (Math.random()*tempHand.length());
                return tempHand.substring(ran, ran+1);
            }
        }else{
            while(true){
                System.out.println("What card do you want?");
                String card = in.nextLine().toUpperCase();
                if(card.equals("10")){
                    card = "1";
                }
                if("123456789JQKA".indexOf(card)>=0){
                    return card;
                }else{
                    System.out.println("you dont have that card");
                }
            }
        }
        
    }



    private static String getPlayer(boolean isP1, boolean isP2, boolean isP3) {
        if(isP1 || isP2 || isP3){
            int ranP = (int) (Math.random()*3);
            if(isP1){
                if(ranP == 0)
                    return yourHand;
                else if(ranP == 2)
                    return playerTwoHand;
                else
                    return playerThreeHand;
            }else if(isP2){
                if(ranP == 0)
                    return yourHand;
                else if(ranP == 1)
                    return playerOneHand;
                else
                    return playerThreeHand;
            }else{
                if(ranP == 0)
                    return yourHand;
                else if(ranP == 1)
                    return playerOneHand;
                else
                    return playerTwoHand;
            }

        }else{
            while(true){
                System.out.println("Which player do you want to ask? (Player 1, Player 2, or Player 3)");
                String whichPlayer = in.nextLine().toUpperCase();
                if(whichPlayer.equals("PLAYER 1"))  
                    return playerOneHand;
                else if(whichPlayer.equals("PLAYER 2"))
                    return playerTwoHand;
                else if(whichPlayer.equals("PLAYER 3"))
                    return playerThreeHand;
                else
                    System.out.println("invalid player");
                
            }
        }
    }



    private static String takeCards(String otherHand, String currentPlayerHand, String card) {
        String temp = otherHand;
        String temp2 = currentPlayerHand;
        boolean hasCard = false;
    
        for(int i = 0; i<otherHand.length(); i++){
            String s = otherHand.substring(i, i+1);
            if(card.equals(s)){

                if(card.equals("1")){
                    otherHand = otherHand.substring(0, otherHand.indexOf(card)) + otherHand.substring(otherHand.indexOf(card)+3);
                    otherHand = fixSpaces(otherHand);
                    currentPlayerHand = currentPlayerHand + " " + card + "0" + getSuit();
                    currentPlayerHand = fixSpaces(currentPlayerHand);
                    hasCard = true;
                    
                }else{
                    otherHand = otherHand.substring(0, otherHand.indexOf(card)) + otherHand.substring(otherHand.indexOf(card)+2);
                    otherHand = fixSpaces(otherHand);
                    currentPlayerHand = currentPlayerHand + " " + card + getSuit();
                    currentPlayerHand = fixSpaces(currentPlayerHand);
                    hasCard = true;

                }
            }
        }

        if(!hasCard){
            System.out.println("GO FISH");
            currentPlayerHand += " " + getCard();
        }


        if(temp.equals(playerOneHand)){
            playerOneHand = otherHand;
        }else if(temp.equals(playerTwoHand)){
            playerTwoHand = otherHand;
        }else if(temp.equals(playerThreeHand)){
            playerThreeHand = otherHand;
        }else{
            yourHand = otherHand;
        }
        
        if(temp2.equals(playerOneHand)){
            playerOneHand = currentPlayerHand;
        }else if(temp2.equals(playerTwoHand)){
            playerTwoHand = currentPlayerHand;
        }else if(temp2.equals(playerThreeHand)){
            playerThreeHand = currentPlayerHand;
        }else{
            yourHand = currentPlayerHand;
        }
        
        return currentPlayerHand;
        

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

        if(firstHand.length() <=1){
            firstHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        }
        
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



    private static int getScore(String cards, boolean isFirstTurn, int playerScore) {
       int score = playerScore;

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

        if(score>=10){
            
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