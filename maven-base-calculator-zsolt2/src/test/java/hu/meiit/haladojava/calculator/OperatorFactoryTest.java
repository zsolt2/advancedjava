package hu.meiit.haladojava.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OperatorFactoryTest {

    @Test
    void createOperator_null_argument() {
        //GIVEN
        OperatorFactory operatorFactory = new OperatorFactory();
        Character operatortType = null;

        //WHEN
        Operator rv = operatorFactory.createOperator(operatortType);

        //THEN
        assertNull(rv);
    }

    @Test
    void createOperator_add() {
        //GIVEN
        OperatorFactory operatorFactory = new OperatorFactory();
        Character operatortType = '+';

        //WHEN
        Operator rv = operatorFactory.createOperator(operatortType);

        //THEN
        assertTrue(rv instanceof AddOperator);
    }

    @Test
    void createOperator_subtract() {
        //GIVEN
        OperatorFactory operatorFactory = new OperatorFactory();
        Character operatortType = '-';

        //WHEN
        Operator rv = operatorFactory.createOperator(operatortType);

        //THEN
        assertTrue(rv instanceof SubtractOperator);
    }

    @Test
    void createOperator_multiply() {
        //GIVEN
        OperatorFactory operatorFactory = new OperatorFactory();
        Character operatortType = '*';

        //WHEN
        Operator rv = operatorFactory.createOperator(operatortType);

        //THEN
        assertTrue(rv instanceof MultiplyOperator);
    }

    @Test
    void createOperator_divide() {
        //GIVEN
        OperatorFactory operatorFactory = new OperatorFactory();
        Character operatortType = '/';

        //WHEN
        Operator rv = operatorFactory.createOperator(operatortType);

        //THEN
        assertTrue(rv instanceof DivideOperator);
    }

    @Test
    void createOperator_invalid() {
        //GIVEN
        OperatorFactory operatorFactory = new OperatorFactory();
        Character operatortType = 'p';

        //WHEN
        Operator rv = operatorFactory.createOperator(operatortType);

        //THEN
        assertNull(rv);
    }

}