package org.example.shapes;

public class App {
    public static void main(String[] args) {
        Engine engine = new Engine();

        engine.addItem(new Circle(10,20,3, 33));
        engine.addItem(new Circle(10,20,3, 33));
        engine.addItem(new Square(10,20,3, 10));
        engine.addItem(new Square(10,20,3,10));

        engine.draw();
    }
}
