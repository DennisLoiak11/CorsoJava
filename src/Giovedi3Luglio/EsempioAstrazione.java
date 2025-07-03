package Giovedi3Luglio;

abstract class Animal {
    public abstract void verso();
}

class Pig extends Animal {
    @Override
    public void verso() {
        System.out.println("Oink Oink!!");
    }
}

class Dog extends Animal {
    @Override
    public void verso() {
        System.out.println("Bau bau!!");
    }
}

public class EsempioAstrazione {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Pig pig = new Pig();
        dog.verso();
        pig.verso();
    }
}