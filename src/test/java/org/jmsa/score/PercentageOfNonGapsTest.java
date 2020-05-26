package org.jmsa.score;

import org.jmsa.score.impl.PercentageOfNonGaps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 1.- The percentage of a sequence without gaps is 100
// 2.- The percentage of a sequence that only has gaps is 0
// 3.- The percentage of a sequence with half letters and half gaps is 50
// 4.- The percentage of a sequence with 3/4 letters and 1/4 gaps is 75
// 5.- The percentage of a sequence with 10 letters and 2 gaps is 83.33
// 6.- The percentage of a sequence with 13 letters and 5 gaps is 72.22

public class PercentageOfNonGapsTest {

  private PercentageOfNonGaps pong;
  private char[][] sequence;

  @BeforeEach
  public void setUp() {
    pong = new PercentageOfNonGaps();
  }

  @Test
  public void thePercentageOfASequenceWithoutGapsIs100() {
    sequence = new char[][] {{'A', 'G', 'A', 'T'}, {'G', 'G', 'C', 'T'}, {'A', 'G', 'C', 'C'}};
    assertEquals(100, pong.compute(sequence));
  }

  @Test
  public void thePercentageOfASequenceAllGapsIs0() {
    sequence = new char[][] {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    assertEquals(0, pong.compute(sequence));
  }

  @Test
  public void thePercentageOfASequenceHalfLettersHalfGapsIs50() {
    sequence = new char[][] {{'-', 'G', '-', 'T', '-'}, {'A', 'G', '-', '-', 'T'}};
    assertEquals(50, pong.compute(sequence));
  }

  @Test
  public void thePercentageOfASequenceThreeQuartersLettersIs75() {
    sequence = new char[][] {{'A', 'G', '-', 'T'}, {'G', '-', 'C', 'T'}, {'A', 'G', '-', 'C'}};
    assertEquals(75, pong.compute(sequence));
  }

  @Test
  public void thePercentageOfASequence2GapsAnd10LettersIs83with33() {
    sequence = new char[][] {{'A', 'G', '-', 'T'}, {'G', 'G', 'C', 'T'}, {'A', 'G', '-', 'C'}};
    assertEquals(((double) 10 / 12) * 100, pong.compute(sequence));
  }

  @Test
  public void thePercentageOfASequence5GapsAnd13LettersIs72with22() {
    sequence =
        new char[][] {
          {'C', 'G'},
          {'A', '-'},
          {'G', 'T'},
          {'-', 'C'},
          {'A', '-'},
          {'-', 'C'},
          {'C', 'G'},
          {'A', '-'},
          {'G', 'T'}
        };
    assertEquals(((double) 13 / 18) * 100, pong.compute(sequence));
  }
}
