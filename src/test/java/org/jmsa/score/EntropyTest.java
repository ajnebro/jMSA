package org.jmsa.score;

import org.jmsa.score.impl.Entropy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * implemented Tests for Entropy
 * Entropy('A')= 0--> length =1
 * Entropy('AT')=1
 * Entropy('ATCG')=2
 */

public class EntropyTest {

  private Entropy entropy;
  private char[][] multipleSequence;

  @BeforeEach
  public void setup() {
    entropy = new Entropy();
  }

  @Test
  public void shouldEntropyOfSequenceOf2NucleotidesReturn0() {
    long expectedValue = 0;
    multipleSequence = new char['A']['A'];
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyOfSequenceOf2DifferentNucleotidesReturns1() {
    long expectedValue = 1;
    multipleSequence = new char[][]{{'A'}, {'G'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyOfSequenceOf4DifferentNucleotidesReturn2() {
    long expectedValue = 2;
    multipleSequence = new char[][]{{'A', 'G'}, {'C', 'T'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyOfSequenceOf4EqualNucleotidesReturn1() {
    long expectedValue = 1;
    multipleSequence = new char[][]{{'A', 'G'}, {'A', 'G'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyOfSequenceOf8NoOrderNucleotidesReturn2() {
    long expectedValue = 2;
    multipleSequence = new char[][]{{'A', 'G', 'C', 'T'}, {'G', 'T', 'A', 'C'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyOfSequenceOf8EqualNucleotidesReturn2() {
    long expectedValue = 2;
    multipleSequence = new char[][]{{'A', 'G', 'C', 'T'}, {'A', 'G', 'C', 'T'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyWith8GapsReturn0() {
    long expectedValue = 0;
    multipleSequence = new char[][]{{'-', '-', '-', '-'}, {'-', '-', '-', '-'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);

  }

  @Test
  public void shouldEntropyWithGapsOfSequenceOf1NucleotidesReturn0() {
    long expectedValue = 0;
    multipleSequence = new char[][]{{'A', '-'}, {'A'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);

  }

  @Test
  public void shouldEntropyOfSequenceOf4DifferentNucleotidesWithGapsReturn2() {
    long expectedValue = 2;
    multipleSequence = new char[][]{{'A', 'G', '-'}, {'C', 'T', '-'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyOfSequenceOf4DifferentNucleotidesWithManyGapsReturn2() {
    long expectedValue = 2;
    multipleSequence = new char[][]{{'A', '-', 'G', '-'}, {'-', 'C', 'T', '-'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }

  @Test
  public void shouldEntropyOfSequenceOf3RepeatedSequencesReturn0() {
    long expectedValue = 0;
    multipleSequence = new char[][]{{'A', '-'}, {'A'}, {'-', 'A'}};
    double obtainedValue = entropy.compute(multipleSequence);
    assertEquals(expectedValue, obtainedValue);
  }
}

