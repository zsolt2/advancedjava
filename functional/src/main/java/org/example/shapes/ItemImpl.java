package org.example.shapes;

public abstract class ItemImpl implements Item {
    private int x;
    private int y;
    private int z;

    public ItemImpl(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "ItemImpl{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
