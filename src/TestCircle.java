import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {

        // Initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        double radius1, radius2;
        String color1, color2;
        boolean filled1, filled2;

        // Use user input to generate Circle 1
        do {
            try {
                System.out.println("Enter the radius of the circle 1, decimals are allowed: ");
                radius1 = sc.nextDouble();

                System.out.println("Enter the color of the circle 1: ");
                color1 = sc.next().toLowerCase().trim();

                System.out.println("Do you want the circle to be filled? true or false: ");
                filled1 = sc.nextBoolean();

                break;
            } catch (Exception e) {
                System.out.println("Invalid input for circle 1, please try again :(\n");
                sc.reset();
                sc.nextLine();
            }
        } while (true);

        System.out.println("\nCircle 1 completed! Please move on to Circle 2 :)\n");


        // Use user input to generate Circle 2
        do {
            try {
                System.out.println("Enter the radius of the circle 2, decimals are allowed: ");
                radius2 = sc.nextDouble();

                System.out.println("Enter the color of the circle 2: ");
                color2 = sc.next().toLowerCase().trim();

                System.out.println("Do you want circle 1 to be filled? true or false: ");
                filled2 = sc.nextBoolean();

                break;
            } catch (Exception e) {
                System.out.println("Invalid input for circle 1, please try again :(\n");
                sc.reset();
                sc.nextLine();
            }
        } while (true);

        System.out.println("\nCircle 2 completed! Generating data... :)\n");

        Circle circle1 = new Circle(radius1, color1, filled1);
        GeometricObject circle2 = new Circle(radius2, color2, filled2);

        // Shows Circle 1 as Circle object
        System.out.println("Information about Circle 1 (Circle object):");
        System.out.println(circle1);
        circle1.printCircle();

        System.out.println();

        // Shows Circle 2 as Geometric object
        System.out.println("Information about Circle 2 (Geometric object):");
        System.out.println(circle2);
        ((Circle) circle2).printCircle();

        System.out.println();

        // Shows comparison
        System.out.println("The two Circles have the same features?");
        System.out.println("Area: 1 if Circle 1 is bigger, 0 if Circles are equal, -1 if Circle 2 is Bigger");
        System.out.println("Color and Fill state: 1 if Circles are the same, 0 if Circles are different");
        System.out.println(circle1.compareTo((Circle) circle2));
    }
}

interface Comparable<Circle> { HashMap<String, Integer> compareTo(Circle o); }

abstract class GeometricObject {
    private String color = "White";
    private boolean filled;
    private final Date dateCreated;

    protected GeometricObject() { dateCreated = new Date(); }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public boolean isFilled() { return filled; }

    public void setFilled(boolean filled) { this.filled = filled; }

    public Date getDateCreated() { return dateCreated; }

    public String toString() {
        return "created on " + dateCreated +
                "\ncolor: " + color + "\nfilled: " + filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends GeometricObject implements Comparable<Circle> {
    // Circle-Oriented Data Fields
    private double radius;

    // Circle-Oriented Constructors
    public Circle() {}

    public Circle(double radius) { this.radius = radius; }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    // Circle-Oriented methods
    public double getRadius() { return radius; }

    public void setRadius(double radius) { this.radius = radius; }

    public double getDiameter() { return 2 * radius; }

    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }

    //Overridden methods and implementations
    @Override
    public double getArea() { return radius * radius * Math.PI; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }

    @Override
    public HashMap<String, Integer> compareTo(Circle o) {

        HashMap<String, Integer> result = new HashMap<>();

        result.put("Area", Double.compare(getArea(), o.getArea()));
        result.put("Color", getColor().equals(o.getColor()) ? 1 : 0);
        result.put("Filled", isFilled() == o.isFilled() ? 1 : 0);

        return result;
    }
}
