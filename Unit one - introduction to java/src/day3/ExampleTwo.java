package day3;

public class ExampleTwo {
    public static void main(String[] args) {
        int age1 = 16, age2 = 17, age3 = 20;

        double averageAge;

        final int NUMBER_OF_STUDENTS = 3; // do not declare as double

        //averageAge = (age1 + age2 + age3)/3;   // int / int = int (truncates the decimal)

        averageAge = (age1 + age2 + age3)/ (double)NUMBER_OF_STUDENTS;
        
        System.out.println(averageAge);

    }
}
