package hu.meiit.haladojava.calculator;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    private static String readFromInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static void main( String[] args )
    {
        Representation representation = new Representation(readFromInput());

        Operands operands = representation.getOperands();

        if (operands == null){
            representation.printError();
            return;
        }

        Operator operator = representation.getOperator();

        if( operator == null){
            representation.printError();
            return;
        }

        Float result = new Service().calculate(operands, operator);

        if(result == null){
            representation.printError();
            return;
        }

        representation.printResult(result);
    }
}
