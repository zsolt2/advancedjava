package hu.meiit.haladojava.calculator;

public class DivideOperator implements Operator{
    @Override
    public Float calculate(Operands operands) {
        if(operands == null){
            return null;
        }
        if( operands.getB() == 0){
            return null;
        }
        return Operator.round(operands.getA() / Float.valueOf(operands.getB()));
    }
}
