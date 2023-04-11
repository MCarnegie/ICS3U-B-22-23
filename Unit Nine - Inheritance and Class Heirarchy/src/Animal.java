public class Animal {
    private int age;
    private int weight;
    private String name;

    //as soon as you write a constructor, Java no longer gives you a constructor
    public Animal(String name, int weight){
        this.name = name;
        this.age = 0;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void eat(){
        this.weight++;
    }
    
    public void makeNoise(){
        System.out.println("eheeheheh");
    }
    
}