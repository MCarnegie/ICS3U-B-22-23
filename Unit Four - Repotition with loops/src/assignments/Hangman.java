package assignments;

import java.util.Scanner;

public class Hangman {
    public static Scanner in = new Scanner(System.in);
    public static final int MAX_BODY_PARTS = 7;
    public static final String VALID_CHARS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final int LETTER = 2;
    public static void main(String[] args) {
        
        String phrase = getPhrase();
        for (int i = 0; i < 21; i++) {
          System.out.println();  
        }
        int numWrong = 0;
        String chosenLetters = "";


        while(numWrong<MAX_BODY_PARTS){
        
        displayEncodedPhrase(phrase, chosenLetters);

        int option = getPlayerOption();
         if (option == LETTER) {
             String letter = getLetter(chosenLetters);
             chosenLetters += letter;
            if (!isInPhrase(letter, phrase)) {
               numWrong++;
               drawHangman(numWrong);
            }
         }else{
             String answer = getAnswer();
             if(answer.equals(phrase)){
               System.out.println("YOU WIN!");
               numWrong = 20;
             }else{
                System.out.println("WRONG!");
                numWrong++;
                drawHangman(numWrong);
             }
         }


        if(numWrong == MAX_BODY_PARTS){
            System.out.println("YOU LOSE!");
        }
    }
    }
    //  ________
    // |        |
    // |        o
    // |       /|\
    // |        |
    // |      _/ \_
    // |
    // |--------------
   

    private static String getAnswer() {
        while(true){
            System.out.println("What is your solution?: ");
            String answer = new Scanner(System.in).nextLine().toUpperCase();
            return answer;
            
        }

    }




    private static int getPlayerOption() {
        int answer = 0;
        
        while(answer<=0){
            System.out.println("Do you want to solve the word? Yes(1) No(2): ");
            answer = in.nextInt();
            if(answer <=0|| answer>2){
                System.out.println("Invalid answer");
                answer = 0;
            }
        }
        
        // 1 for letter
      // 2 for solve
      // create constants for these
        return answer;
     
    }


    private static boolean isInPhrase(String letter, String phrase) {
        return phrase.indexOf(letter) >= 0;
    }


    private static String getLetter(String chosenLetters) {
        
        while(true){
            System.out.println("Please enter a letter. Chosen Letters are: ");
            getLettersString(chosenLetters);
            String letter = new Scanner(System.in).nextLine().toUpperCase();
            if(letter.length() > 1){
                System.out.println("Only one letter please!");
            }else if(VALID_CHARS.indexOf(letter)<0){
                System.out.println("only valid letters please a-z");
            }else if(chosenLetters.indexOf(letter)>0){
                System.out.println("you already chose that letter!");
            }else{
                return letter;
            }
            
        }
    }


    private static void getLettersString(String chosenLetters) {
      displayEncodedPhrase("ABCDEFGHIJKLMNOPQRSTUVWXYZ", chosenLetters);
    
    }


    private static void displayEncodedPhrase(String phrase, String chosenLetter) {

        /*
         * Phrase: THIS IS GOOD
         * Encoded: _ _ I _/ I _ / _ _ _ _ 
         * 
         */

         String result = "";
         for (int i = 0; i < phrase.length(); i++) {
            String letter = phrase.substring(i, i+1);
            if(letter.equals(" ")){
                result += "/ ";
            }else if(chosenLetter.indexOf(letter)>=0){
                result += letter + " ";
            }else{
                result += "_";
            }
         }

        System.out.println(result);
    }


    private static String getPhrase() {
        while(true){
            boolean isValid = false;
            System.out.println("Please enter your phrase (letters and spaces only): ");
            String answer = in.nextLine().toUpperCase();
            for(int i = 0; i<answer.length(); i++){
                String section = answer.substring(i, i+1);
                if(VALID_CHARS.indexOf(section) >=0 ){
                    isValid = true;
                }else if(" ".indexOf(section) >= 0){
                    isValid = true;
                }else{
                    isValid = false;
                }
            }

            if(isValid){
                System.out.println("it works");
                return answer;
                
            }else{
                System.out.println("Invalid Phrase");
            }

            
        }
    }


    public static void drawHangman(int numBodyParts){
        if(numBodyParts == 7){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        o");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|      _/ \\_");
            System.out.println("|");
            System.out.println("|--------------");
        }else if(numBodyParts == 6){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        o");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|      _/ ");
            System.out.println("|");
            System.out.println("|--------------");
        }else if(numBodyParts == 5){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        o");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|");
            System.out.println("|--------------");
        }else if(numBodyParts == 4){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        o");
            System.out.println("|       /|\\");
            System.out.println("|");
            System.out.println("|--------------");
        }else if(numBodyParts == 3){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        o");
            System.out.println("|       /|");
            System.out.println("|");
            System.out.println("|--------------");
        }else if(numBodyParts == 2){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        o");
            System.out.println("|        |");
            System.out.println("|");
            System.out.println("|--------------");
        }else if(numBodyParts == 1){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        o");
            System.out.println("|       ");
            System.out.println("|        ");
            System.out.println("|");
            System.out.println("|--------------");
        }else if(numBodyParts == 0){
            System.out.println("________");
            System.out.println("|        |");
            System.out.println("|        ");
            System.out.println("|       ");
            System.out.println("|        ");
            System.out.println("|");
            System.out.println("|--------------");
    }    }
}
