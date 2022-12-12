package day1;

public class Die {
    //attributes define the state of this Object and they should be private only the class should have access to them
    private int numSides;
    private int topSide;

    //the constructor is used to create an instance of the class
    //generally public so they can be called directly
    // initializes the state (attributes) of the class

    public int getTopSide() {
        return topSide;
    }

    public String toString(){
        return "the top side is: " + this.topSide;
    }


    //we can create as many constructors as we want
    public Die(int numSides){
        this.numSides = numSides;
        //this refers to this instance of the die
        roll();



    }

    //When the constructor does not any paramaters it is called the default constructor
    public Die(){
        numSides = 6;
        roll();
    }

    //if you do not explicityly write a constructor Java will give you a no arg constructor by default that does nothing

    //sets top side to be a number between 1 and number of side inclusive
    public void roll() {
        topSide = (int) (Math.random() * numSides)+1;

    }


}
