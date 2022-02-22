package hu.meiit.haladojava.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RepresentationTest {

    @Test
    void getOperands_add() {
        // GIVEN
        String args = "1+2";

        // WHEN
        Representation representation = new Representation(args);
        Operands rvOperands= representation.getOperands();
        Operator rvOperator = representation.getOperator();

        // THEN
        assertEquals(rvOperands, new Operands().setA(1).setB(2));
        assertTrue(rvOperator instanceof AddOperator);
    }

    @Test
    void getOperands_subtract() {
        // GIVEN
        String args = "1 - 2";

        // WHEN
        Representation representation = new Representation(args);
        Operands rvOperands= representation.getOperands();
        Operator rvOperator = representation.getOperator();

        // THEN
        assertEquals(rvOperands, new Operands().setA(1).setB(2));
        assertTrue(rvOperator instanceof SubtractOperator);
    }

    @Test
    void getOperands_multiply() {
        // GIVEN
        String args = "1* 2";

        // WHEN
        Representation representation = new Representation(args);
        Operands rvOperands= representation.getOperands();
        Operator rvOperator = representation.getOperator();

        // THEN
        assertEquals(rvOperands, new Operands().setA(1).setB(2));
        assertTrue(rvOperator instanceof MultiplyOperator);
    }

    @Test
    void getOperands_divide() {
        // GIVEN
        String args = "1 /2";

        // WHEN
        Representation representation = new Representation(args);
        Operands rvOperands= representation.getOperands();
        Operator rvOperator = representation.getOperator();

        // THEN
        assertEquals(rvOperands, new Operands().setA(1).setB(2));
        assertTrue(rvOperator instanceof DivideOperator);
    }

    @Test
    void getOperands_noargument() {
        // GIVEN
        String args = null;

        // WHEN
        Representation representation = new Representation(args);
        Operands rvOperands= representation.getOperands();
        Operator rvOperator = representation.getOperator();

        // THEN
        assertNull(rvOperands);
        assertNull(rvOperator);
    }

    @Test
    void getOperands_invalidArguments() {
        // GIVEN
        String args = "aa";

        // WHEN
        Representation representation = new Representation(args);
        Operands rvOperands= representation.getOperands();
        Operator rvOperator = representation.getOperator();

        // THEN
        assertNull(rvOperands);
        assertNull(rvOperator);
    }
}