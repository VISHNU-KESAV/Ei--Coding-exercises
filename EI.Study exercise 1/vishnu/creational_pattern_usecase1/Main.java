import java.util.HashMap;
import java.util.Map;
interface Shape extends Cloneable {
    Shape clone();
    void draw();
}
class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle of width " + width + " and height " + height);
    }

    @Override
    public Rectangle clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }

    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class ShapeRegistry {
    private Map<String, Shape> shapes = new HashMap<>();

    public void addShape(String key, Shape shape) {
        shapes.put(key, shape);
    }

    public Shape getShape(String key) {
        return shapes.get(key).clone();
    }
}

public class Main {
    public static void main(String[] args) {
  
        ShapeRegistry shapeRegistry = new ShapeRegistry();

        Rectangle rectangle = new Rectangle(10, 20);
        Circle circle = new Circle(15);

        shapeRegistry.addShape("Big Rectangle", rectangle);
        shapeRegistry.addShape("Medium Circle", circle);

        Shape clonedRectangle = shapeRegistry.getShape("Big Rectangle");
        Shape clonedCircle = shapeRegistry.getShape("Medium Circle");

        clonedRectangle.draw();  
        clonedCircle.draw();   
    }
}

