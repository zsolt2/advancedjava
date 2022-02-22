package hu.meiit.haladojava.calculator;

public class OperatorFactory {
    public Operator createOperator(Character type){
        if (type == null)
            return null;
        switch ( type ){
            case '-':
                return new SubtractOperator();
            case '+':
                return new AddOperator();
            case '*':
                return new MultiplyOperator();
            case '/':
                return new DivideOperator();
            default:
                return null;
        }
    }
}
