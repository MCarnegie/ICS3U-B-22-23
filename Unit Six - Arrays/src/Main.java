//this was for the CCC waterloo contest 2/15/2023

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int[] nums = new int[5];
    static  int whatDay = 1;
    public static void main(String[] args) {
        /*int pack = in.nextInt();
        int collision = in.nextInt();
        
        j1(pack, collision);*/

        /*int spiceScore = 0;
        int numPep = in.nextInt();
        for (int i = 0; i <= numPep; i++) {
            String pepper = in.nextLine();
            spiceScore += j2(pepper);
        }

        System.out.println(spiceScore);*/

        /*int numPeople = Integer.parseInt(in.nextLine());
 
        
        
           for(int i = 0; i<numPeople; i++){
                String days = in.nextLine();
                while(whatDay < 6){
                    j3(days, whatDay);
                }
                whatDay = 1;
            } 

            
        int highestNum = nums[0];
        String indexes = "";
        for (int i = 0; i < nums.length; i++) {
            if(highestNum<nums[i]){
                highestNum = nums[i];
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if(highestNum == nums[i])
                indexes+= i+1 + ",";
        }

        
            indexes = indexes.substring(0, indexes.length()-1);
        
        System.out.println(indexes);*/

        int size = Integer.parseInt(in.nextLine());

        String top = in.nextLine();
        String bottom = in.nextLine();

        int meters = 0;
        for(int i = 0; i<top.length(); i++){
            if(top.substring(i, i+1).equals("1")){
                meters += 3;
            }
        }

        for(int i = 0; i<bottom.length(); i++){
            if(bottom.substring(i, i+1).equals("1")){
                meters += 3;
            }
        }
        
        for (int i = 0; i < top.length()-1; i++) {
           
        }

        
    }
    
    private static void j3(String days, int Day) {
        if(Day == 1){
            if(days.substring(0,1).equals("Y"))
                nums[0]++;
            
        }else if(Day == 2){
            if(days.substring(1,2).equals("Y"))
                nums[1]++;

        }else if(Day == 3){
            if(days.substring(2,3).equals("Y"))
                nums[2]++;
        }else if(Day == 4){
            if(days.substring(3,4).equals("Y"))
                nums[3]++;
        }else if(Day == 5){
            if(days.substring(4).equals("Y"))
                nums[4]++;
        }

        whatDay++;
    }

    private static int j2(String pep) {
        int spice = 0;

        if(pep.equals("Poblano"))
            spice = 1500;
        else if(pep.equals("Mirasol"))
            spice = 6000;
        else if(pep.equals("Serrano"))
            spice = 15500;
        else if(pep.equals("Cayenne"))
            spice = 40000;
        else if(pep.equals("Thai"))
            spice = 75000;
        else if(pep.equals("Habanero"))
            spice = 125000;   
            
        return spice;
    }
    
    private static void j1(int pack, int collision) {
        int finalScore = 0;
        int pointsEarned = 50*pack;
        int ponitsLossed = 10*collision;

        if(pack>collision)
            finalScore+= 500;

        finalScore+= pointsEarned-ponitsLossed;

        System.out.println(finalScore);

    }
    
    
}
