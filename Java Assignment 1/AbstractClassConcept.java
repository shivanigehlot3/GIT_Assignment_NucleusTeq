public class AbstractClassConcept {
    public static void main(String args[]){
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);

        Chicken c = new Chicken();
        c.eat();
        c.walk();

        // AnimalClass11 a = new AnimalClass11(); //Cannot instantiate the type AnimalClass11

        Mustang m = new Mustang();
        // AnimalClass11 --> Horse ---> Mustang  (constructor execution order )
    }
}
abstract class AnimalClass{
    String color;
    // AnimalClass11(){
    //     color = "brown";
    // }
    AnimalClass(){
        System.out.println("animal constructor called");
    }
    void eat(){
        System.out.println("eating");
    }
    abstract void walk();
}

class Horse extends AnimalClass{
    Horse(){
        System.out.println("Horse Constructor called");
    }
    void changecolor(){
        color="dark brown";
    }
    void walk(){
        System.out.println("walks on 4 legs");
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor called");
    }
}
class Chicken extends AnimalClass{
    void changecolor(){
        color="yelllow";
    }
    void walk(){
        System.out.println("walks on 2 legs");
    }
}
