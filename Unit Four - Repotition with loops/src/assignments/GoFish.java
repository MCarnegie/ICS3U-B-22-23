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
    static boolean isOver = true;
    static boolean isFirstTurn = true;
    
    public static void main(String[] args){
        
        while(isOver){
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
            displayHand(playerOneHand, true, "Player 1 Hand: ");

            playerTwoHand = NewHand(playerTwoHand);
            displayHand(playerTwoHand, true, "Player 2 Hand: ");

            playerThreeHand = NewHand(playerThreeHand);
            displayHand(playerThreeHand, true, "Player 3 Hand: ");
            isFirstTurn = false;

            System.out.println("--------------------------------------------");
            
            while(scoreOne <10 && scoreTwo<10 && scoreThree<10 && scoreP<10){
                
                String whichPlayer = getPlayer(false, false , false);
                String card = getUserCard(false, false , false); 
                endTurn(yourHand, whichPlayer, card, scoreP, false, false, false, "Your Hand: ", "Your score: ");
                
                System.out.println("--------------------------------------------");System.out.println("               Player 1's Turn");System.out.println();
                
               
                whichPlayer = getPlayer(true, false , false);
                card = getUserCard(true, false , false); if(card.equals("1"))System.out.println("for a " + card + "0");else System.out.println("for a " + card);
                endTurn(playerOneHand, whichPlayer, card, scoreOne, true, false, false, "Player 1 Hand: ", "Player 1 score: ");
                
                System.out.println("--------------------------------------------");System.out.println("               Player 2's Turn");System.out.println();
                
                
                whichPlayer = getPlayer(false, true , false);
                card = getUserCard(false, true , false);if(card.equals("1"))System.out.println("for a " + card + "0");else System.out.println("for a " + card);
                endTurn(playerTwoHand, whichPlayer, card, scoreTwo, false, true, false, "Player 2 Hand: ", "Player 2 score: ");
                
                System.out.println("--------------------------------------------");System.out.println("               Player 3's Turn");System.out.println();
                
                
                whichPlayer = getPlayer(false,false , true);
                card = getUserCard(false, false, true);if(card.equals("1"))System.out.println("for a " + card + "0");else System.out.println("for a " + card);
                endTurn(playerThreeHand, whichPlayer, card, scoreThree, false, false, true, "Player 3 Hand: ", "Player 3 score: ");
                System.out.println("--------------------------------------------");System.out.println();

                displayAll();
                
            }
            endGame();
        }

    }

    private static void endGame(){
        while(true){
                if(scoreP>=10){
                    System.out.println("YOU WIN!");
                }else{
                    System.out.println("YOU LOSE");
                }
                System.out.println("Do you want to play again");
                String answer = in.nextLine().toUpperCase();
                if(answer.equals("Y") || answer.equals("YES") || answer.equals("YEAH")){
                    scoreOne = 0;
                    scoreP = 0;
                    scoreTwo = 0;
                    scoreThree = 0;
                    yourHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
                    playerOneHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
                    playerTwoHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
                    playerThreeHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
                    System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
                    break;
                }else if(answer.equals("N") || answer.equals("NO")){
                    isOver = false;
                    break;
                
                }else{
                    System.out.println("invalid response (type yes or no)");
                }
            
        }
    }


    private static void endTurn(String currentPlayerHand, String whichPlayer, String card, int score, boolean isP1, boolean isP2, boolean isP3, String label,  String scoreLabel){
            currentPlayerHand = takeCards(whichPlayer, currentPlayerHand, card);
            if(!isP1 || !isP2 || !isP3)
                displayHand(currentPlayerHand, false, label);
            else
                displayHand(currentPlayerHand, true, label);//is hidden should be true at the end

            if(isP1){
                scoreOne = getScore(currentPlayerHand, false, scoreOne);
                System.out.println(scoreLabel + scoreOne);
            }else if(isP2){
                scoreTwo = getScore(currentPlayerHand, false, scoreTwo);
                System.out.println(scoreLabel + scoreTwo);
            }else if(isP3){
                scoreThree = getScore(currentPlayerHand, false, scoreThree);
                System.out.println(scoreLabel + scoreThree);
            }else{
                scoreP = getScore(currentPlayerHand, false, scoreP);
                System.out.println(scoreLabel + scoreP);
            }
            currentPlayerHand = NewHand(currentPlayerHand);

            if(!isP1 || !isP2 || !isP3)
                displayHand(currentPlayerHand, false, label);
            else
                displayHand(currentPlayerHand, true, label);//is hidden should be true at the end
   }

    private static void displayAll(){
        displayHand(yourHand, false, "Your Hand: ");
        displayHand(playerOneHand, false, "Player 1 Hand: ");
        displayHand(playerTwoHand, false, "Player 2 Hand: ");
        displayHand(playerThreeHand, false, "Player 3 Hand: ");
        System.out.println("Your Score: " + scoreP);
        System.out.println("Player 1 Score: " + scoreOne);
        System.out.println("Player 2 Score: " + scoreTwo);
        System.out.println("Player 3 Score: " + scoreThree);
       
    }

    private static String getUserCard(boolean isP1, boolean isP2, boolean isP3) {
        if(isP1 || isP2 || isP3){
            if(isP1){
                return getRandomCard(playerOneHand);

            }else if(isP2){
                return getRandomCard(playerTwoHand);
            }else{
                return getRandomCard(playerThreeHand);
            }
        }else{
            while(true){
                System.out.println("What card do you want?");
                String card = in.nextLine().toUpperCase();
                if(card.equals("10")){
                    card = "1";
                }
                if(yourHand.indexOf(card)>=0){
                    return card;
                }else{
                    System.out.println("you dont have that card");
                }
            }
        }
        
    }

    private static String getRandomCard(String currentPlayerHand){
        String tempHand = "";
        for (int i = 0; i < currentPlayerHand.length(); i++) {
            String s = currentPlayerHand.substring(i, i+1);
            
            if("123456789JQKA".indexOf(s)>=0){
                tempHand += s;
            }
        }
        int ran = (int) (Math.random()*tempHand.length());
        return tempHand.substring(ran, ran+1);
    }


    private static String getPlayer(boolean isP1, boolean isP2, boolean isP3) {
        if(isP1 || isP2 || isP3){
            int ranP = (int) (Math.random()*3);
            if(isP1){
                if(ranP == 0){
                    System.out.print("They asked You ");
                    return yourHand;
                }else if(ranP == 2){
                    System.out.print("They asked Player 2 ");
                    return playerTwoHand;
                }else{
                    System.out.print("They asked Player 3 ");
                    return playerThreeHand;
                }
            }else if(isP2){
                if(ranP == 0){
                    System.out.print("They asked You ");
                    return yourHand;
                }else if(ranP == 1){
                    System.out.print("They asked Player 1 ");
                    return playerOneHand;
                }else{
                    System.out.print("They asked Player 3 ");
                    return playerThreeHand;
                }
            }else{
                if(ranP == 0){
                    System.out.print("They asked You ");
                    return yourHand;
                }else if(ranP == 1){
                    System.out.print("They asked Player 1 ");
                    return playerOneHand;
                }else{
                    System.out.print("They asked Player 2 ");
                    return playerTwoHand;
                }
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

        if(otherHand.length() <=1){
            otherHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        }

        if(!hasCard){
            System.out.println("GO FISH");
            currentPlayerHand += " " + getCard();
            currentPlayerHand = fixSpaces(currentPlayerHand);
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
        String temp = cards;

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
            System.out.println("You have no more cards, let me get you some");
            firstHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
        }
        if(temp.equals(playerOneHand)){
            playerOneHand = firstHand;
        }else if(temp.equals(playerTwoHand)){
            playerTwoHand = firstHand;
        }else if(temp.equals(playerThreeHand)){
            playerThreeHand = firstHand;
        }else{
            yourHand = firstHand;
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
                    if(isFirstTurn)
                    System.out.print("");
                    else 
                    System.out.println("Pair Found! +1 to score!");
                    score++;
                }
            }else if("23456789".indexOf(s) >= 0){
                if(restOf.indexOf(s)>=0){
                    if(isFirstTurn)
                    System.out.print("");
                    else 
                    System.out.println("Pair Found! +1 to score!");
                    score++;
                }
            }

        }
        if(isFirstTurn && score>=3){
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