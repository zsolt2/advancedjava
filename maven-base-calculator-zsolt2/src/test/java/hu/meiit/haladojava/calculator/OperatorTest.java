package hu.meiit.haladojava.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void round() {
        // GIVEN
        float input = 1.33f;
        // WHEN
        float rv = Operator.round(input);
        // THEN
        assertEquals(rv, 1.3f);
    }
}