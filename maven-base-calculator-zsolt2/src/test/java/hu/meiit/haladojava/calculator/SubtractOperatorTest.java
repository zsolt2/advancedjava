package hu.meiit.haladojava.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SubtractOperatorTest {

    @Test
    void calculate_goodValues() {
        // GIVEN
        Operands operands = mock(Operands.class);

        when(operands.getB()).thenReturn(1);
        when(operands.getA()).thenReturn(3);

        Operator operator = new SubtractOperator();
        // WHEN

        Float rv = operator.calculate(operands);

        // THEN

        verify(operands, times(1)).getA();
        verify(operands, times(1)).getB();
        assertEquals(rv, 2f);
    }

    @Test
    void calculate_opearands_is_null() {
        // GIVEN
        Operands operands = null;

        Operator operator = new SubtractOperator();
        // WHEN

        Float rv = operator.calculate(operands);

        // THEN

        assertNull(rv);
    }
}