package hu.meiit.haladojava.calculator;

public class Representation {
    private Operands operands;
    private Operator operator;

    public Representation(String input) {

        Validator validator = new Validator(input);
        this.operands = validator.getOperands();

        OperatorFactory operatorFactory = new OperatorFactory();
        Character operatorType = validator.getOperatorType();

        this.operator = operatorFactory.createOperator(operatorType);
    }

    public Operands getOperands() {
        return operands;
    }

    public Operator getOperator() {
        return operator;
    }

    public void printError(){
        System.out.println("-");
    }

    public void printResult(Float result){
        System.out.println(result);
    }
}
