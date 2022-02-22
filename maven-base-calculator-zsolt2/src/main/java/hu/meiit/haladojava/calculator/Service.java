package hu.meiit.haladojava.calculator;

public class Service {
    public Float calculate(Operands operands, Operator operator){
        return operator.calculate(operands);
    }
}
