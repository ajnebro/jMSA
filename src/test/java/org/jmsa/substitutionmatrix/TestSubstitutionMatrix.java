package java.org.jmsa.substitutionMatrix;

import java.org.jmsa.substitutionmatrix.SubstitutionMatrix;
import java.org.jmsa.substitutionmatrix.impl.Blosum62;
import java.org.jmsa.substitutionmatrix.impl.PAM250;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSubstitutionMatrix {

  private PAM250 pam250;
  private Blosum62 blosum62;

  //PAM250 tests
  @Test
  public void testShouldReturnMinus8VerP250SubsMat() {
    SubstitutionMatrix p250 = new PAM250();
    double expectedValue = -8;
    double obtainedValue = p250.getGapPenalty();
    assertEquals(expectedValue, obtainedValue);
  }


  @Test
  public void testShouldReturnMinus8VerP250() {
    pam250 = new PAM250();
    double expectedValue = -8;
    double obtainedValue = pam250.getGapPenalty();
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void testShouldReturnMinus10VerP250() {
    pam250 = new PAM250(-10D);
    double expectedValue = -10D;
    double obtainedValue = pam250.getGapPenalty();
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void testShouldReturnOneVerP250() {
    pam250 = new PAM250();
    double expectedValue = 1;
    double obtainedValue = pam250.getDistance('-', '-');
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void testShouldReturnGapPenaltyVerP250() {
    pam250 = new PAM250();
    double expectedValue = pam250.getGapPenalty();
    double obtainedValue1 = pam250.getDistance('K', '-');
    double obtainedValue2 = pam250.getDistance('-', 'K');
    assertEquals(expectedValue, obtainedValue1);
    assertEquals(expectedValue, obtainedValue2);
  }

  @Test
  public void testShoulReturnDistancesMatrixVerP250() {
    pam250 = new PAM250();
    assertEquals(0, pam250.getDistance('X', 'A'));
    assertEquals(-4, pam250.getDistance('Y', 'R'));
    assertEquals(-4, pam250.getDistance('R', 'Y'));
    assertEquals(12, pam250.getDistance('C', 'C'));
    assertEquals(-6, pam250.getDistance('W', 'P'));
    assertEquals(6, pam250.getDistance('H', 'H'));
  }

  //Check correct distances when we introduce different gapPenalty parameter
  @Test
  public void testShoulReturnDistancesMatrixWithDifferentGPVerP250() {
    pam250 = new PAM250(-10D);
    assertEquals(-10D, pam250.getDistance('A', '-'));
    assertEquals(-10D, pam250.getDistance('-', 'S'));
    assertEquals(1, pam250.getDistance('-', '-'));
    assertEquals(0, pam250.getDistance('X', 'A'));
    assertEquals(-4, pam250.getDistance('Y', 'R'));
    assertEquals(-4, pam250.getDistance('R', 'Y'));
    assertEquals(12, pam250.getDistance('C', 'C'));
    assertEquals(-6, pam250.getDistance('W', 'P'));
    assertEquals(6, pam250.getDistance('H', 'H'));
  }


  //Blosum62 tests
  @Test
  public void testShouldReturnMinus8VerB62() {
    blosum62 = new Blosum62();
    double expectedValue = -8;
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
