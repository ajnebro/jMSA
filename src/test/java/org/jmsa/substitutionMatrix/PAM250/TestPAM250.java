package org.jmsa.substitutionMatrix.PAM250;

import org.jmsa.substitutionmatrix.impl.PAM250;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPAM250 {

    private PAM250 p250;

    @Test
    public void testShouldReturnMinus8() throws IOException {
        p250 = new PAM250();
        double expectedValue = -8D;
        double obtainedValue = p250.getGapPenalty();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testShouldReturn10() throws IOException {
        p250 = new PAM250(10D);
        double expectedValue = 10;
        double obtainedValue = p250.getGapPenalty();
        assertEquals(expectedValue, obtainedValue);

    }

    @BeforeEach
    private void setUp() throws IOException {
        p250 = new PAM250();
    }

    @Test
    public void testShouldReturnGapPenalty() {
        double expectedValue = -8D;
        double obtainedValue = p250.getGapPenalty();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testShouldReturnOne() {
        double expectedValue = 1;
        double obtainedValue = p250.getDistance('-', '-');
        assertEquals(expectedValue, obtainedValue);

    }

    @Test
    public void testShouldReturnGapPenaltyCase2() {
        double expectedValue = p250.getGapPenalty();
        double obtainedValue1 = p250.getDistance('A', '-');
        double obtainedValue2 = p250.getDistance('-', 'A');
        assertEquals(expectedValue, obtainedValue1);
        assertEquals(expectedValue, obtainedValue2);

    }

    @Test
    public void testShoulReturnDistancesMatrix() {
        assertEquals(0, p250.getDistance('X', 'A'));
        assertEquals(-4, p250.getDistance('Y', 'R'));
        assertEquals(-4, p250.getDistance('R', 'Y'));
        assertEquals(12, p250.getDistance('C', 'C'));
        assertEquals(-6, p250.getDistance('W', 'P'));
    }

   /*
   //Me falta por completar
   @Test
   public void testShoulReturnException() {
       assertThrows(RuntimeException.class, () -> p250.getDistance('-', '-'));
   }
    */


}
