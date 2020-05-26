package org.jmsa.score;

import org.jmsa.score.impl.SumOfPairs;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SumOfPairsTest {

  private SumOfPairs sum;

  @BeforeEach
  // Before each test we'll create a SumOfPairs Object and a SubstitutionMatrix with mock
  public void setup() {
    SubstitutionMatrix substitutionMatrix = mock(SubstitutionMatrix.class);
    sum = new SumOfPairs(substitutionMatrix);
    when(substitutionMatrix.getDistance('A', 'A')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('A', 'T')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('A', 'G')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('A', 'C')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('A', '-')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('T', 'T')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('T', 'A')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('T', 'G')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('T', 'C')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('T', '-')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('G', 'G')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('G', 'A')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('G', 'T')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('G', 'C')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('G', '-')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('C', 'C')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('C', 'A')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('C', 'T')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('C', 'G')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('C', '-')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('-', '-')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('-', 'A')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('-', 'T')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('-', 'G')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('-', 'C')).thenReturn(-4.0);
  }

  @Test
  /*Example:  {'A', 'G', 'G'}, AT AT TT       +5 +5 +5
  {'A', 'C', 'G'}, G- GG -G       -4 +5 +5
  {'A', 'G', '-'}  -A -- A-       -4 -4 -4
  Sum of pair = 5*5 -4*4=9                 */
  public void shouldSumOfPairsGeneralCaseWithGapsAlignedAndNotAlignedPairsReturnTheRightValue9() {
    char[][] matrix = {{'A', 'G', 'G'}, {'A', 'C', 'G'}, {'A', 'G', '-'}};
    double expectedValue = 9;
    double obtainedValue = sum.compute(matrix);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  /*Example:  {'A', 'T', 'C'}, AA AA AA       +5 +5 +5
  {'A', 'T', 'C'}, AA AA AA       +5 +5 +5
  {'A', 'T', 'C'}  AA AA AA       +5 +5 +5
  Sum of pair = 5*9=45                      */
  public void shouldATotallyAlignedMSAReturnTheRightValue45() {
    char[][] matrix = {{'A', 'T', 'C'}, {'A', 'T', 'C'}, {'A', 'T', 'C'}};
    double expectedValue = 45;
    double obtainedValue = sum.compute(matrix);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  /*Example:  {'-', '-', '-'}, -- -- --       -4 -4 -4
  {'-', '-', '-'}, -- -- --       -4 -4 -4
  {'-', '-', '-'}  -- -- --       -4 -4 -4
  Sum of pair = -4*9=-36                    */
  public void shouldATotallyGapsMSAReturnTheRightValueNegative36() {
    char[][] matrix = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    double expectedValue = -36;
    double obtainedValue = sum.compute(matrix);
    assertEquals(expectedValue, obtainedValue);
  }
}
