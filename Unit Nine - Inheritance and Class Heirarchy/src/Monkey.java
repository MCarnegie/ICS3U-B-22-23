public class Monkey extends Animal{
    public Monkey(String name, int weight){
        super(name, weight);
    }

    public void makeNoise(){
        System.out.println("ooo ooo ah ah");
    }

    public void eat(){
        super.eat();
        super.eat();
        //you could make a get and set weight to do it
    }
}
