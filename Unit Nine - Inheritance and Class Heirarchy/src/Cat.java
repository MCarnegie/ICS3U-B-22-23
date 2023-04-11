public class Cat extends Animal{


    public Cat(String name, int weight){
        super(name, weight);
    }

    public void makeNoise(){
        System.out.println("Meow");
    }

    public void scratch(){
        System.out.println("scratch");
    }
}
