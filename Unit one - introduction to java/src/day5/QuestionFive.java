package day5;

public class QuestionFive {
    public static void main(String[] args) {
        double winPercentage = 110.0/154;
        
        double rounded = Math.round(winPercentage*1000)/1000.0;


        System.out.println("the win percentage is: " + rounded);
    }
}
