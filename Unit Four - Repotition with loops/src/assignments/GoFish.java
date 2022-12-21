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
    static String yourHand = "2D 9H 6C 2D 2D";//getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static String playerOneHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static String playerTwoHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static String playerThreeHand = getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    static int scoreP = 0;
    static int scoreOne = 0;
    static int scoreTwo = 0;
    static int scoreThree = 0;
    static boolean isOver = true;
    static boolean isFirstTurn = true;
    
    public static void main(String[] args)throws InterruptedException{
        
        while(isOver){
            //makes the hands without duplicates and dislplays them
            yourHand = NewHand(yourHand, false, false, false);
            displayHand(yourHand, false, "Your Hand: ");
            
            playerOneHand = NewHand(playerOneHand, true, false, false);
            displayHand(playerOneHand, true, "Player 1 Hand: ");

            playerTwoHand = NewHand(playerTwoHand, false, true, false);
            displayHand(playerTwoHand, true, "Player 2 Hand: ");

            playerThreeHand = NewHand(playerThreeHand, false, false, true);
            displayHand(playerThreeHand, true, "Player 3 Hand: ");
            isFirstTurn = false;

            //prints the scores
            System.out.println("Your Score: " + scoreP);
            System.out.println("Player 1 Score: " + scoreOne);
            System.out.println("Player 2 Score: " + scoreTwo);
            System.out.println("Player 3 Score: " + scoreThree);

            System.out.println("--------------------------------------------");
            
            //Main gameplay loop: while everybodys score is less than 10, the game will ask the players which player 
            //they want to take a card from and which card. using this information and more it will use endturn then delay so the user can read what actions happened
            //it will then display all the scores and hands and repeat the loop
            while(scoreOne <10 && scoreTwo<10 && scoreThree<10 && scoreP<10){
                
                String whichPlayer = getPlayer(false, false , false);
                String card = getUserCard(false, false , false); 
                endTurn(yourHand, whichPlayer, card, false, false, false, "Your Hand: ");
                Thread.sleep(5000);

                System.out.println("--------------------------------------------");System.out.println("               Player 1's Turn");System.out.println();
               
                whichPlayer = getPlayer(true, false , false);
                card = getUserCard(true, false , false); if(card.equals("1"))System.out.println("for a " + card + "0");else System.out.println("for a " + card);
                endTurn(playerOneHand, whichPlayer, card, true, false, false, "Player 1 Hand: ");
                Thread.sleep(5000);

                System.out.println("--------------------------------------------");System.out.println("               Player 2's Turn");System.out.println();
                
                whichPlayer = getPlayer(false, true , false);
                card = getUserCard(false, true , false);if(card.equals("1"))System.out.println("for a " + card + "0");else System.out.println("for a " + card);
                endTurn(playerTwoHand, whichPlayer, card, false, true, false, "Player 2 Hand: ");
                Thread.sleep(5000);

                System.out.println("--------------------------------------------");System.out.println("               Player 3's Turn");System.out.println();
                
                whichPlayer = getPlayer(false,false , true);
                card = getUserCard(false, false, true);if(card.equals("1"))System.out.println("for a " + card + "0");else System.out.println("for a " + card);
                endTurn(playerThreeHand, whichPlayer, card, false, false, true, "Player 3 Hand: ");
                Thread.sleep(5000);

                System.out.println("--------------------------------------------");System.out.println("                Results");System.out.println();
                
                displayAll();
                
            }
            endGame();
        }

    }

    private static void endGame(){
        //endGame() first checks to see if you won and displays a message, it then prompts the user if they want to play again
        //if they say yes, it will reset all the scores and hands, if they say no, it ends the game. anything else is an invalid response
        while(true){
                if(scoreP>=10){
                    System.out.println("YOU WIN!");
                }else{
                    System.out.println("YOU LOSE");
                }
                System.out.println("Do you want to play again?");
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


    private static void endTurn(String currentPlayerHand, String whichPlayer, String card, boolean isP1, boolean isP2, boolean isP3, String label){
            currentPlayerHand = takeCards(whichPlayer, currentPlayerHand, card);
            if(isP1 || isP2 || isP3)
                displayHand(currentPlayerHand, false, label);
                
            else
                displayHand(currentPlayerHand, false, label);

            if(isP1){
                currentPlayerHand = NewHand(currentPlayerHand, true, false, false);
                System.out.println("Player 1 score: " + scoreOne);
            }else if(isP2){
                currentPlayerHand = NewHand(currentPlayerHand, false, true, false);
                System.out.println("Player 2 score: " + scoreTwo);
            }else if(isP3){
                currentPlayerHand = NewHand(currentPlayerHand, false, false, true);
                System.out.println("Player 3 score" + scoreThree);
            }else{
                currentPlayerHand = NewHand(currentPlayerHand, false, false, false);
                System.out.println("Your score: " + scoreP);
            }

            if(isP1 || isP2 || isP3)
                displayHand(currentPlayerHand, false, label);
            
            else
                displayHand(currentPlayerHand, false, label);
   }

    private static void displayAll(){
        //displays the scores and hands of teh players
        displayHand(yourHand, false, "Your Hand: ");
        displayHand(playerOneHand, true, "Player 1 Hand: ");
        displayHand(playerTwoHand, true, "Player 2 Hand: ");
        displayHand(playerThreeHand, true, "Player 3 Hand: ");
        System.out.println("Your Score: " + scoreP);
        System.out.println("Player 1 Score: " + scoreOne);
        System.out.println("Player 2 Score: " + scoreTwo);
        System.out.println("Player 3 Score: " + scoreThree);
       
    }

    private static String getUserCard(boolean isP1, boolean isP2, boolean isP3) {
        //if the method detects that a NPC is playing, it will use the getRandomCard method to get a random card from their hand
        //if the method detects that the user is playing, it will ask them for a card, if this card is a 10, it will change it to a one for convienince
        //if its not a ten, it will just return the card, mkaing sure that its in your hand. anything else is a invalid response and will prompt the user again
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
                }else if(yourHand.indexOf(card)<0){
                    if("123456789AKJQ".indexOf(card)<0)
                    System.out.println("Invalid Response, Please say what card you want (2-10, AQJK)");
                    else
                    System.out.println("you dont have that card");
                }
            }
        }
        
    }

    private static String getRandomCard(String currentPlayerHand){
        //using a temperaory string, it will go through the players hand and add every card that is in their hand to a temp hand
        //it will then randomly pick a number between 0 and the players hand length which is going to be what card they decide they want
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



    private static String NewHand(String cards, boolean isP1, boolean isP2, boolean isP3) {
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
                    if(isFirstTurn)
                    System.out.print("");
                    else 
                    System.out.println("Pair Found! +1 to score!");
                    if(isP1){
                        scoreOne++;
                    }else if(isP2){
                        scoreTwo++;
                    }else if(isP3){
                        scoreThree++;
                    }else{
                        scoreP++;
                    }
                    }else{
                    newHand = cards.substring(0, location1) + cards.substring(location1+2, location2) + cards.substring(location2+2);
                    if(isFirstTurn)
                    System.out.print("");
                    else 
                    System.out.println("Pair Found! +1 to score!");
                    if(isP1){
                        scoreOne++;
                    }else if(isP2){
                        scoreTwo++;
                    }else if(isP3){
                        scoreThree++;
                    }else{
                        scoreP++;
                    }
                    }
                    
                    cards = newHand;
                    i = 0; 
                    
                    
                }
            }else if("23456789".indexOf(s) >= 0){
                if(restOf.indexOf(s)>=0){
                    int location1 = cards.indexOf(s);
                    int location2 = cards.lastIndexOf(s);

                    String newHand = cards.substring(0, location1) + cards.substring(location1+2, location2) + cards.substring(location2+2);
                    if(isFirstTurn)
                    System.out.print("");
                    else 
                    System.out.println("Pair Found! +1 to score!");
                    if(isP1){
                        scoreOne++;
                    }else if(isP2){
                        scoreTwo++;
                    }else if(isP3){
                        scoreThree++;
                    }else{
                        scoreP++;
                    }
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