package hu.meiit.haladojava.calculator;

public interface Operator {
    static Float round(float number){
        return Math.round(number * 10.0f) / 10.0f;
    }
    Float calculate(Operands operands);
}
