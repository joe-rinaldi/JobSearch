package main.examples;
// File: ShapeExample.java
import java.util.Scanner;



// 1. Interface: Defines a contract for all shapes
interface Shape {
    void draw();
    double area();
}

// 2. Concrete classes implementing the Shape interface
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public double area() {
        return width * height;
    }
}

// 3. Factory Pattern: Creates Shape objects based on input
class ShapeFactory {
    public static Shape getShape(String type, double... params) {
        if (type == null) {
            throw new IllegalArgumentException("Shape type cannot be null");
        }
        switch (type.toLowerCase()) {
            case "circle":
                if (params.length != 1) throw new IllegalArgumentException("Circle needs radius");
                return new Circle(params[0]);
            case "rectangle":
                if (params.length != 2) throw new IllegalArgumentException("Rectangle needs width and height");
                return new Rectangle(params[0], params[1]);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}

// 4. Main class to test the implementation
public class FactoryPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Example: Create a Circle
            System.out.print("Enter radius of circle: ");
            double radius = scanner.nextDouble();
            Shape circle = ShapeFactory.getShape("circle", radius);
            circle.draw();
            System.out.println("Area: " + circle.area());

            // Example: Create a Rectangle
            System.out.print("Enter width of rectangle: ");
            double width = scanner.nextDouble();
            System.out.print("Enter height of rectangle: ");
            double height = scanner.nextDouble();
            Shape rectangle = ShapeFactory.getShape("rectangle", width, height);
            rectangle.draw();
            System.out.println("Area: " + rectangle.area());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

