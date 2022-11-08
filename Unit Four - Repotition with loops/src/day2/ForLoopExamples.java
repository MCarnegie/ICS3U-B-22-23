package day2;

public class ForLoopExamples {
    public static void main(String[] args) {
        //exampleOne();
        //exampleTwo(1, 1000);
        exampleThree("Check this String");
  
     }
  
     /* Introduction to for loops (counting loops) */
     private static void exampleOne() {
        /*int i = 0;
        int sum = 0;
        while (i<10){
            sum += 1;
            i++;
        }*/

        // for loop (init counter; condition; increment counter)
        int sum = 0;
        for(int i =0; i<10; i++){
            sum += i;
        }

        //initialise (once)
        //check condition 
        //body
        //increment
        //check condition 
        //body


        //does not initialise
        //does not incremnet
        //runs forever -> infinite loop
        // for (;true;) {
            
        // }
     }
  
     /* Obtain the sum of the numbers from start to end */
     private static void exampleTwo(int start, int end) {
        
        int sum = 0;

        for(int i = start; i<=end; i++){
            sum += i;
        }

        System.out.println(sum);
     }
  
     /* count the number of words in the sentence */
     private static void exampleThree(String sentence) {
        int wordCount = 1;

        for(int i = 0; i<sentence.length(); i++){
            String letter = sentence.substring(i,i+1);
            if(letter.equals(" ")){
                wordCount++;
            }
        }

        System.out.println(wordCount);
     }

}
