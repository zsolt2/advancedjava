package org.example.shapes;

public class Circle extends ItemImpl {
    private int radius;

    public Circle(int x, int y, int z, int radius) {
        super(x, y, z);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle::draw " + toString());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
