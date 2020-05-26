package org.jmsa.substitutionMatrix;

import org.jmsa.substitutionmatrix.impl.Blosum62;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSubstitutioMatrixBlosum62 {

  private Blosum62 blosum62;

  // Blosum62 tests
  @Test
  public void testShouldReturnMinus8VerB62() {
    blosum62 = new Blosum62();
    double expectedValue = -4;
    double obtainedValue = blosum62.getGapPenalty();
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void testShouldReturnMinus10VerB62() {
    blosum62 = new Blosum62(-10D);
    double expectedValue = -10D;
    double obtainedValue = blosum62.getGapPenalty();
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void testShouldReturnOneVerB62() {
    blosum62 = new Blosum62();
    double expectedValue = 1;
    double obtainedValue = blosum62.getDistance('-', '-');
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void testShouldReturnGapPenaltyVerB62() {
    blosum62 = new Blosum62();
    double expectedValue = blosum62.getGapPenalty();
    double obtainedValue1 = blosum62.getDistance('K', '-');
    double obtainedValue2 = blosum62.getDistance('-', 'K');
    assertEquals(expectedValue, obtainedValue1);
    assertEquals(expectedValue, obtainedValue2);
  }

  @Test
  public void testShoulReturnDistancesMatrixVerB62() {
    blosum62 = new Blosum62();
    assertEquals(0, blosum62.getDistance('X', 'A'));
    assertEquals(-2, blosum62.getDistance('Y', 'R'));
    assertEquals(-2, blosum62.getDistance('R', 'Y'));
    assertEquals(9, blosum62.getDistance('C', 'C'));
    assertEquals(-4, blosum62.getDistance('W', 'P'));
    assertEquals(8, blosum62.getDistance('H', 'H'));
  }

  @Test
  public void testShoulReturnDistancesMatrixWithDifferentGPVerB62() {
    blosum62 = new Blosum62(-10D);
    assertEquals(-10D, blosum62.getDistance('A', '-'));
    assertEquals(-10D, blosum62.getDistance('-', 'S'));
    assertEquals(1, blosum62.getDistance('-', '-'));
    assertEquals(0, blosum62.getDistance('X', 'A'));
    assertEquals(-2, blosum62.getDistance('Y', 'R'));
    assertEquals(-2, blosum62.getDistance('R', 'Y'));
    assertEquals(9, blosum62.getDistance('C', 'C'));
    assertEquals(-4, blosum62.getDistance('W', 'P'));
    assertEquals(8, blosum62.getDistance('H', 'H'));
  }
}
