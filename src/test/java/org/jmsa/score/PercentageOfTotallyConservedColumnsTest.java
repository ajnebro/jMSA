package org.jmsa.score;

import org.jmsa.score.impl.PercentageOfTotallyConservedColumns;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercentageOfTotallyConservedColumnsTest {
  /* Now lets do som tests to see if our programme works:
      1. The % of a sequence in which all the columns are the same is 100.
      2. The % of a sequence in which all the columns are different is 0.
      3. The % of a sequence in which only half of the columns are the same is 50.
      4. The % of a sequence in which 2 columns out of 7 are the same is 40.
  */
  private char[][] sequence;
  private PercentageOfTotallyConservedColumns porcentajeConservedColumns;

  @BeforeEach
  public void setUp() {
    porcentajeConservedColumns = new PercentageOfTotallyConservedColumns();
  }

  @Test
  public void allEqualPercentajeReturn100() {
    sequence = new char[][] {{'A', 'G', 'C'}, {'A', 'G', 'C'}, {'A', 'G', 'C'}};
    assertEquals(100, porcentajeConservedColumns.compute(sequence));
  }

  @Test
  public void noMatchReturn0() {
    sequence = new char[][] {{'A', 'C', 'T'}, {'C', 'T', 'A'}, {'T', 'A', 'C'}};
    assertEquals(0, porcentajeConservedColumns.compute(sequence));
  }

  @Test
  public void matchHalfReturn50() {
    sequence = new char[][] {{'A', 'C', 'T', 'T'}, {'C', 'C', 'T', 'G'}, {'T', 'C', 'T', 'G'}};
    assertEquals(50, porcentajeConservedColumns.compute(sequence));
  }

  @Test
  public void match2of5returns2857() {
    sequence =
        new char[][] {
          {'A', 'C', 'T', 'T', 'T'}, {'C', 'C', 'T', 'G', 'T'}, {'T', 'C', 'T', 'G', 'A'}
        };
    assertEquals(((double) 2 / 5) * 100, porcentajeConservedColumns.compute(sequence));
  }
}
