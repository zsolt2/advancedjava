package org.example.shapes;

public class Square extends ItemImpl {
    private int side;

    public Square(int x, int y, int z, int side) {
        super(x, y, z);
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Square::draw " + toString());
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                "} " + super.toString();
    }
}
