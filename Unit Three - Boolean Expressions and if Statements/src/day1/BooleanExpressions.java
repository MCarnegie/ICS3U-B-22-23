package day1;

public class BooleanExpressions {
    public static void main(String[] args) {
        // mathematical expressions evaluate to a number
        // boolean expressions evaluate to true or false
        
        // >, <, >=, <=, ==, !=
        boolean exp1 = 17 > 5;
        //result will be true
        boolean exp2 = 17 == 17;
        //result will be true
        boolean isRed = true;
        boolean isHard = false;

        boolean isHardAndRed = isHard == isRed;
        //result will be false because isRed is true while isHard is false

        int x = 7;
        boolean exp4 = (x<3) != (x>5);
        //the result will be true

        int y = 3;
        boolean exp5 = (x < y) == (y > x);
        //the result will be true (flase == false which is equal to true)


        // Compund Boolean Expressions
        // AND (&&), OR (||), NOT (!)

        //NOT operator 

        boolean isGreen = true;
        
        boolean exp6 = !isGreen;


        boolean exp7 = !true; //false
        boolean exp8 = !false; //true
        
        boolean isBlue = false;
        isHard = true;
        boolean isHardBlue = isBlue && isHard; //&& requires both left and right side to be true if it is going to be

        boolean isBlueOrHard = isBlue||isHard; //false || true, (or requires one of them to be true in order to be true)

        x = 7;
        y = 17; 
        boolean exp9 = (x>7) && (y<25); //false
    }
}
