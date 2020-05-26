package org.jmsa.score;

import org.jmsa.score.impl.Star;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Assuming we are receiving sequences that contains correct letters.
 *
 * <p>Case 1: {{'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}} They are all the
 * same, so the program should return 3*4*5 = 60
 *
 * <p>Case 2: {{'A'}, {'A'}, {'T'}} They only differ in one letter, so the program should return
 * 5+5-4=6
 *
 * <p>Case 3: {{'A'}, {'C'}, {'T'}} They are all different, so the program should return 5-4-4 =-3
 *
 * <p>Case 4: {{'A'}, {'A'}, {'T'}, {'T'}} There's the same quantity of both letters, so we check it
 * doesn't get mixed up It should return 2
 *
 * <p>Case 5: { {'A', 'T', 'T', 'C', 'G'}, {'A', 'G', 'A', 'C', 'C'}, {'T', 'C', 'G', 'T', 'A'},
 * {'G', 'G', 'C', 'T', 'A'} } It should return 1
 */
class StarTest {
  private Star star;
  private Star starMock;

  class DummySubstitutionMatrix implements SubstitutionMatrix {
    int[][] matrix = {{5, -4, -4, -4}, {-4, 5, -4, -4}, {-4, -4, 5, -4}, {-4, -4, -4, 5}};
    // we create a matrix with the distances we'll use to evaluate the method
    private Map<Character, Integer> equivalences = new TreeMap<Character, Integer>();

    @Override
    public double getDistance(char char1, char char2) {
      /* we fill the map with the equivalences between letter and number,
      where A->0, c->1, G->2 and T->3
       */
      equivalences.put('A', 0);
      equivalences.put('C', 1);
      equivalences.put('G', 2);
      equivalences.put('T', 3);

      // we use two int variables to save the transformation from char1 and char2 to int
      int int1 = equivalences.get(char1);
      int int2 = equivalences.get(char2);

      // we get the distance by looking for the correct position in the matrix
      double distance = matrix[int1][int2];
      return distance;
    }

    @Override
    public double getGapPenalty() {
      // we assume it is 0 to make things easier, since this is just a test
      return 0;
    }
  }

  DummySubstitutionMatrix matrix = new DummySubstitutionMatrix();

  @BeforeEach
  // before each test we'll create a Star Object
  public void setup() {
    star = new Star(matrix);
    SubstitutionMatrix substitutionMatrix = mock(PAM250.class);

    when(substitutionMatrix.getDistance('A', 'A')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('A', 'T')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('A', 'G')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('A', 'C')).thenReturn(-4.0);

    when(substitutionMatrix.getDistance('T', 'T')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('T', 'C')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('T', 'A')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('T', 'G')).thenReturn(-4.0);

    when(substitutionMatrix.getDistance('C', 'C')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('C', 'T')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('C', 'A')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('C', 'G')).thenReturn(-4.0);

    when(substitutionMatrix.getDistance('G', 'G')).thenReturn(5.0);
    when(substitutionMatrix.getDistance('G', 'T')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('G', 'A')).thenReturn(-4.0);
    when(substitutionMatrix.getDistance('G', 'C')).thenReturn(-4.0);

    starMock = new Star(substitutionMatrix);
  }

  @Test
  public void equalSequencesShouldReturn5LengthSeq() {
    char[][] sequence = {{'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}};
    double expectedValue = 60;
    double obtainedValue = star.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void equalSequencesShouldReturn5LengthSeqWithMock() {
    char[][] sequence = {{'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}};
    double expectedValue = 60;
    double obtainedValue = starMock.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void threeUnitarySequencesWithOneDifferenceShouldReturn6() {
    char[][] sequence = {{'A'}, {'A'}, {'T'}};
    double expectedValue = 6;
    double obtainedValue = star.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void threeUnitarySequencesWithOneDifferenceShouldReturn6WithMock() {
    char[][] sequence = {{'A'}, {'A'}, {'T'}};
    double expectedValue = 6;
    double obtainedValue = starMock.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void threeUnitarySequencesWithNoEquivalencesShouldReturnMinus3() {
    char[][] sequence = {{'A'}, {'C'}, {'T'}};
    double expectedValue = -3;
    double obtainedValue = star.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void threeUnitarySequencesWithNoEquivalencesShouldReturnMinus3WithMock() {
    char[][] sequence = {{'A'}, {'C'}, {'T'}};
    double expectedValue = -3;
    double obtainedValue = starMock.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void fourUnitarySequencesWithSameLetterQuantitiesShouldReturn2() {
    char[][] sequence = {{'A'}, {'A'}, {'T'}, {'T'}};
    double expectedValue = 2;
    double obtainedValue = star.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void fourUnitarySequencesWithSameLetterQuantitiesShouldReturn2WithMock() {
    char[][] sequence = {{'A'}, {'A'}, {'T'}, {'T'}};
    double expectedValue = 2;
    double obtainedValue = starMock.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void exampleSequenceShouldReturn1() {
    char[][] sequence = {
      {'A', 'T', 'T', 'C', 'G'},
      {'A', 'G', 'A', 'C', 'C'},
      {'T', 'C', 'G', 'T', 'A'},
      {'G', 'G', 'C', 'T', 'A'}
    };
    double expectedValue = 1;
    double obtainedValue = star.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void exampleSequenceShouldReturn1WithMock() {
    char[][] sequence = {
      {'A', 'T', 'T', 'C', 'G'},
      {'A', 'G', 'A', 'C', 'C'},
      {'T', 'C', 'G', 'T', 'A'},
      {'G', 'G', 'C', 'T', 'A'}
    };
    double expectedValue = 1;
    double obtainedValue = starMock.compute(sequence);

    assertEquals(expectedValue, obtainedValue);
  }
}
