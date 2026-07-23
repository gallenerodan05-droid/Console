
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;



public  class CalculatorTest {
    @Test
    // method name should be very descriptive
    public void add() {

        Calculator calculator = new Calculator();
        assertEquals(14,calculator.add(2, 12));
        assertNotEquals(19,calculator.add(2, 12));



    }
}