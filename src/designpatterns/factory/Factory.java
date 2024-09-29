package src.designpatterns.factory;

public class Factory {

    public static Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
    
}

/**
 * InnerFactory
 */
 public interface Shape {

    void draw();
    
}

class Circle implements Shape{
    public void draw(){
        System.out.println("draw a circle");
    }
}

class Square implements Shape{

    public void draw(){
        System.out.println("draw a square");
    }

}
