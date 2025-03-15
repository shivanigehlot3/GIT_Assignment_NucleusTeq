// Demonstrate polymorphism by creating methods with the same name but different parameters in a parent and child class.

class Animal {
    void speak() {
        System.out.println("Animal makes a sound");
    }

    void speak(String sound) {
        System.out.println("Animal says: " + sound);
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks: Woof Woof!");
    }

    void speak(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Dog barks: Woof!");
        }
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("Animal:");
        animal.speak();
        animal.speak("Growl");

        System.out.println();

        Dog dog = new Dog();
        System.out.println("Dog:");
        dog.speak();
        dog.speak("Bark");
        dog.speak(3);
    }
}
