package src.main;


import src.designpatterns.singleton.Singleton;
// import src.designpatterns.factory.Factory;
import src.designpatterns.factory.*;

public class Main {

     public static void main(String[] args) {
        
        // Using Singleton
        Singleton logger = Singleton.getInstance();
        logger.log("This is a singleton logger message.");

        // Using factory
        

        Shape shape1 = Factory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = Factory.getShape("SQUARE");
        shape2.draw();

     }
}
