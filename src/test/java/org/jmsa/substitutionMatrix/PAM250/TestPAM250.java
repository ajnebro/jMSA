package org.jmsa.substitutionMatrix.PAM250;

import org.jmsa.substitutionmatrix.impl.PAM250;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPAM250 {

    private PAM250 p250;

    @Test
    public void testShouldReturnMinus8() {
        p250 = new PAM250();
        double expectedValue = -8;
        double obtainedValue = p250.getGapPenalty();
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testShouldReturn10() {
        p250 = new PAM250(-10D);
        double expectedValue = -10D;
        double obtainedValue = p250.getGapPenalty();
        assertEquals(expectedValue, obtainedValue);

    }

    //Comprueba que al introducirle como parámetro el gapPenalty, las distancias que proporciona siguen siendo correctas
    @Test
    public void testShoulReturnDistancesMatrixVer1() {
        p250 = new PAM250(-10D);
        assertEquals(-10D, p250.getDistance('A', '-'));
        assertEquals(-10D, p250.getDistance('-', 'S'));
        assertEquals(1, p250.getDistance('-', '-'));
        assertEquals(0, p250.getDistance('X', 'A'));
        assertEquals(-4, p250.getDistance('Y', 'R'));
        assertEquals(-4, p250.getDistance('R', 'Y'));
        assertEquals(12, p250.getDistance('C', 'C'));
        assertEquals(-6, p250.getDistance('W', 'P'));
        assertEquals(6, p250.getDistance('H', 'H'));

    }

    /*

    @BeforeEach
    public void setUp() {
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

    //De la forma en la que está planteado, no tiene sentido
    @Test
    public void testShouldReturnGapPenaltyCase2() {
        double expectedValue = p250.getGapPenalty();
        double obtainedValue1 = p250.getDistance('A', '-');
        double obtainedValue2 = p250.getDistance('-', 'A');
        assertEquals(expectedValue, obtainedValue1);
        assertEquals(expectedValue, obtainedValue2);

    }

    @Test
    public void testShoulReturnDistancesMatrixVer2() {
        assertEquals(-8, p250.getDistance('A', '-'));
        assertEquals(0, p250.getDistance('X', 'A'));
        assertEquals(-4, p250.getDistance('Y', 'R'));
        assertEquals(-4, p250.getDistance('R', 'Y'));
        assertEquals(12, p250.getDistance('C', 'C'));
        assertEquals(-6, p250.getDistance('W', 'P'));
        assertEquals(6, p250.getDistance('H', 'H'));
    }

     */

}
