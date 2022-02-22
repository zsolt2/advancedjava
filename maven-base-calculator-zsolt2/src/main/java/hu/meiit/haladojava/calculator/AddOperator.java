package hu.meiit.haladojava.calculator;

public class AddOperator implements Operator{

    @Override
    public Float calculate(Operands operands) {
        if (operands == null)
            return null;
        return Operator.round(operands.getA() + operands.getB());
    }
}
