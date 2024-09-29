package src.solid;

interface Flyable{
    public void fly();
}

class Birds implements Flyable{
    @Override
    public void fly(){
        System.out.println("birds can fly");
    }
}



class Animal{

    public void makeNoise(){
        System.out.println("some generic sound");
    }

    

}

class Dog extends Animal{

    @Override
    public void makeNoise(){
        System.out.println("bark bark bark");
    }

}

class Cat extends Animal{
    @Override
    public void makeNoise(){
        System.out.println("meow meow");
    }
}

class Chicken extends Animal implements Flyable{
    @Override
    public void fly(){
        System.out.println("possibly");
    }

    @Override
    public void makeNoise(){
        System.out.println("WTFFFFF");
    }
}

public class LiskovPrinciple{

    public static void main(String[] args){

        Animal myDog = new Dog();
        Animal myCat = new Cat();
        Chicken myChicken = new Chicken();

        myCat.makeNoise();
        myDog.makeNoise();
        myChicken.fly();
    }

}