package hu.meiit.haladojava.calculator;

public class Operands {
    private int a;
    private int b;

    public Operands(){
        a = 0;
        b = 0;
    }

    public Operands(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public Operands setA(int a) {
        this.a = a;
        return this;
    }

    public int getB() {
        return b;
    }

    public Operands setB(int b) {
        this.b = b;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operands operands = (Operands) o;
        return getA() == operands.getA() && getB() == operands.getB();
    }

}
