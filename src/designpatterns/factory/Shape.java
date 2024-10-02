package src.designpatterns.factory;

// Factory class to generate objects of type Shape
public class Factory {

    // Factory method to get a Shape object based on the input shape type
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null; // Avoid null pointer exception
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

// Shape interface with a draw method
public interface Shape {
    void draw();
}

// Circle class implementing Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw a circle");
    }
}

// Square class implementing Shape interface
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw a square");
    }
}
