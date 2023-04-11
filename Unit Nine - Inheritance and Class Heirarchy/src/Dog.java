public class Dog extends Animal {
 
    public Dog(String name, int weight){
        super(name, weight);
    }

    public void makeNoise(){
        System.out.println("Bark");
    }
}
