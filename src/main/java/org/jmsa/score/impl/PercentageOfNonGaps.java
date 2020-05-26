package org.jmsa.score.impl;

import org.jmsa.score.Score;

public class PercentageOfNonGaps implements Score {
  public double compute(char[][] sequence) {
    double counterNonGaps = 0;
    for (char[] chars : sequence) {
      for (char aChar : chars) {
        if (aChar != '-') {
          counterNonGaps += 1;
        }
      }
    }
    return counterNonGaps / (sequence.length * sequence[0].length) * 100;
  }
}
