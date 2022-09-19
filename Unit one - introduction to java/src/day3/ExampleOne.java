package day3;

// Primitive data types and variables

public class ExampleOne {
    public static void main(String[] args) {
        //variables are meant to store and recall data/information

        //the data could be anything like numbers, strings, true or false, etc...

        //before we use variables we must declare it
        //when we declare a variable WE MUST state the type of data it will hold

        //Primitive types store the value (THEY ARE PRIMITIVE)
        // int -> integer
        // double -> decimal numbers
        // boolean -> true or false

        int numberOfStudents;   //numberofstudents has been declared as an int
        numberOfStudents = 24;
        double testAverage = 63.7; // declared and initilized on the same line (gave it an initial value)
        final double PI = 3.14; // if the variable cannot be modified after it has been initilized 
        //then make it final
        //PI = 6.2; syntax error (wont compile) because PI is final
        // naming convention for constants (final) is ALL_UPPER_CASE_WITH_UNDERSCORES_BETWEEN_WORDS
        
        boolean isHeads = false;
        boolean hasToes = true;

        System.out.println("There are " + numberOfStudents + " students in class");
        System.out.println("5 + 3 = " + 5 + 3); // 5 + 3 = 53
        System.out.println("5 + 3 = " + (5 + 3)); // 5 + 3 = 8

    }
}
