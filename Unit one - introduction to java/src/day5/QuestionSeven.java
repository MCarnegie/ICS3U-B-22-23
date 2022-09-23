package day5;

public class QuestionSeven {
    public static void main(String[] args) {
        double celcius = (98.0 - 30) * (5/9.0);
        
        double round = Math.round(celcius*10)/10.0;
        
        System.out.println("98*F in celcius is: " + round + "*C");
    }
}
