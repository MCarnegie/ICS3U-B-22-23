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
    static String yourHand = dealCards();
    static String playerOneHand = dealCards();
    static String playerTwoHand = dealCards();
    static String playerThreeHand = dealCards();
    static int scoreP = 0;
    static int scoreOne = 0;
    static int scoreTwo = 0;
    static int scoreThree = 0;
    static boolean isOver = true;
    static boolean isFirstTurn = true;
    
    public static void main(String[] args)throws InterruptedException{
        int roundCount = 1;
        while(isOver){
            //displays instructions and the old cards without the duplicates
            System.out.println("Welcome to Go Fish!");System.out.println(); 
            System.out.println("Today, you're going to be playing against 3 other computer players competing to get a score of 10");
            System.out.println("You can add to your score by getting matching pairs of cards. (Ex: 2C 4S 2H 7S 8D -> 1 point)");System.out.println("Good luck!");System.out.println();

            System.out.println("         Old Cards");
            displayHand(yourHand, false, "Your Hand: "); displayHand(playerOneHand, true, "Player 1 Hand: ");
            displayHand(playerTwoHand, true, "Player 2 Hand: "); displayHand(playerThreeHand, true, "Player 3 Hand: ");
            System.out.println(); System.out.println("         New Cards");
            //makes the hands without duplicates and displays them
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

            
            //Main gameplay loop: while everybody’s score is less than 10, the game will ask the players which player 
            //they want to take a card from and which card. using this information and more depending on the player, it will use endturn then delay so the user can read what actions happened
            //it will then display all the scores and hands and repeat the loop
            while(scoreOne <10 && scoreTwo<10 && scoreThree<10 && scoreP<10){
                System.out.println("--------------------------------------------");System.out.println("                  Round " + roundCount);System.out.println();
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
                roundCount++;
                
            }
            roundCount = 1;
            endGame();
        }
        
    }

    private static String dealCards(){
        //this method returns five new cards
        return getCard() + " " + getCard() + " " + getCard() + " " + getCard() + " " + getCard();
    }



    private static void endGame(){
        //endGame() first checks to see if you won and displays a message, it then prompts the user if they want to play again
        //if they say yes, it will reset all the scores and hands and end the loop, if they say no, it ends the loop and then the game. anything else is an invalid response
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
                    yourHand = dealCards();
                    playerOneHand = dealCards();
                    playerTwoHand = dealCards();
                    playerThreeHand = dealCards();
                    isFirstTurn = true;
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
        //first, this method takes the current players hand, which player they picked, and the card they picked and uses them to take the card from the player the user picks
        //afterwards, it displays the hand with the new card and depending on if it is a computer or not will display the hand
        //next, it checks to see if there are any duplicates and removes them, accordingly, afterwards displaying the score
        //this must be in an if statement to figure out what score has to be displayed
        //finally, it displays the new hand with the proper label and with it hidden or not
            currentPlayerHand = takeCards(whichPlayer, currentPlayerHand, card);
            if(isP1 || isP2 || isP3)
                displayHand(currentPlayerHand, true, label);
                
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
                System.out.println("Player 3 score: " + scoreThree);
            }else{
                currentPlayerHand = NewHand(currentPlayerHand, false, false, false);
                System.out.println("Your score: " + scoreP);
            }

            if(isP1 || isP2 || isP3)
                displayHand(currentPlayerHand, true, label);
            
            else
                displayHand(currentPlayerHand, false, label);
   }

    private static void displayAll(){
        //displays the scores and hands of the players
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
        //if the method detects that the user is playing, it will ask them for a card, if this card is a 10, it will change it to a one for convenience
        //if it’s not a ten, it will just return the card, making sure that it’s in your hand. anything else is a invalid response and will prompt the user again
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
        //using a temporary string, it will go through the players hand and add every card that is in their hand to a temp hand
        //it will then randomly pick a number between 0 and the players hand length which is going to be what card they want
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
         //if the computer is playing, a random number is chosen to decide what player they are going to ask
        //if the user is playing, the computer will ask them what player they would like to choose and respond accordingly
        //if anything, other than the player is chosen it will respond with invalid response and ask them again
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
                if(whichPlayer.equals("PLAYER 1") || whichPlayer.equals("1"))  
                    return playerOneHand;
                else if(whichPlayer.equals("PLAYER 2")|| whichPlayer.equals("2"))
                    return playerTwoHand;
                else if(whichPlayer.equals("PLAYER 3")|| whichPlayer.equals("3"))
                    return playerThreeHand;
                else
                    System.out.println("invalid player");
                
            }
        }
    }



    private static String takeCards(String otherHand, String currentPlayerHand, String card) {
        //this method first iterates through the chosen players hand to see if the card that the player chosen is there
        //if it is, it will find the location of it in the string and get everything but that card. it will than fix any spacing issues and make hasCard true
        //it then checks to see if the chosen players hand is empty and add cards accordingly. if the player they chose doesn’t have that card, the method will print go fish and give the current player a random card
        //finally, the method will assign the hands to the correct players and will return the current players hand
        String temp = otherHand;
        String temp2 = currentPlayerHand;
        boolean hasCard = false;
    
        for(int i = 0; i<otherHand.length(); i++){
            String s = otherHand.substring(i, i+1);
            if(card.equals(s)){
                if(card.equals("1")){
                    if(temp2.equals(yourHand))System.out.println("You got the card");
                    else System.out.println("They got the card");
                    otherHand = otherHand.substring(0, otherHand.indexOf(card)) + otherHand.substring(otherHand.indexOf(card)+3);
                    otherHand = fixSpaces(otherHand);
                    currentPlayerHand = currentPlayerHand + " " + card + "0" + getSuit();
                    currentPlayerHand = fixSpaces(currentPlayerHand);
                    hasCard = true;
                    
                }else{
                    if(temp2.equals(yourHand))System.out.println("You got the card");
                    else System.out.println("They got the card");
                    otherHand = otherHand.substring(0, otherHand.indexOf(card)) + otherHand.substring(otherHand.indexOf(card)+2);
                    otherHand = fixSpaces(otherHand);
                    currentPlayerHand = currentPlayerHand + " " + card + getSuit();
                    currentPlayerHand = fixSpaces(currentPlayerHand);
                    hasCard = true;

                }
            }
        }

        if(otherHand.length() <=1){
            otherHand = dealCards();
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
        //the method will iterate through the players hand and see if there is a duplicate
        //if there is, the method will find the first occurrence of the duplicate and the last occurrence of it and make a new string
        //consisting of everything before the first location, everything between the first and second locations, and everything after the second location
        //it will then fix any spacing issues and add cards to the players hand if they don’t have any in their hand
        //finally, it will assign the correct hand to the current player and return the correct hand
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

                    if(isP1){scoreOne++;}else if(isP2){scoreTwo++;}else if(isP3){scoreThree++;}else{scoreP++;}

                    }else{
                        newHand = cards.substring(0, location1) + cards.substring(location1+2, location2) + cards.substring(location2+2);
                    if(isFirstTurn)
                        System.out.print("");
                    else 
                        System.out.println("Pair Found! +1 to score!");

                    if(isP1){scoreOne++;}else if(isP2){scoreTwo++;}else if(isP3){scoreThree++;}else{scoreP++;}
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

                    if(isP1){scoreOne++;}else if(isP2){scoreTwo++;}else if(isP3){scoreThree++;}else{scoreP++;}

                    cards = newHand;
                    i = 0; 
                }
            }
        }
        
        firstHand = cards;

        firstHand = fixSpaces(firstHand);


        if(firstHand.length() <=1){
            System.out.println("You have no more cards, let me get you some");
            firstHand = dealCards();
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
        //this method will iterate through the hand and get two letters
        //if the two letters are spaces it will remove one of the spaces
        //if the first letter of the string is a space, it will remove it from the string
        //finally, it will return the fixed string
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
        //if isHidden is true, the method will go through the cards and get two letters
        //if both of these letters are not spaces it will add an XX to the bot hand and will print the bot hand with the label
        //if isHidden is false, it will print out the label and the cards
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
        //this will get a random value and suit
        return getValue() + getSuit();
    }

    private static String getSuit() {
        //this will choose an random suit
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
        //this will choose a random value
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