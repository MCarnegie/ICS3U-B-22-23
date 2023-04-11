public class Zoo {
    public static void main(String[] args){
        Animal animal = new Animal("greg", 100);
        animal.eat();
        animal.makeNoise();

        Bird bird = new Bird("Moe", 8,true);

        bird.makeNoise();

        Monkey harry = new Monkey("harry", 1200);
        harry.eat();
    }
}
