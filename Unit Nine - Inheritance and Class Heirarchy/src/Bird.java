public class Bird extends Animal{
    private boolean canFly;


    //The first line of Any constructor must be a call to a parent constructor using super
    //if you dont the Java will call super()
    //if the parent does not have a no argument constructor its over
    public Bird(String name, int weight, boolean canFly){
        super(name, weight);
        this.canFly = canFly;
    }

    public void fly(){
        if(canFly){
        System.out.println("i am flying");
        }else{
        System.out.println("i cant fly");
        }

    }

    public void makeNoise(){
        System.out.println("Chrip");
    }
}
