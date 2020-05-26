package org.jmsa.score.impl;

import org.jmsa.score.Score;

// We assume they are correctly aligned
public class PercentageOfTotallyConservedColumns implements Score {
  public double compute(char[][] sequence) {
    double counterConservedColumns = 0;
    double lenghtSeq = sequence[0].length;
    for (int j = 0; j < lenghtSeq; j++) {
      double equalCounter = 0;
      for (int i = 0; i < sequence.length - 1; i++) {
        if (sequence[i][j] == sequence[i + 1][j]) {
          equalCounter += 1;
        }
        if (equalCounter == sequence.length - 1) {
          counterConservedColumns += 1;
        }
      }
    }
    return counterConservedColumns / (lenghtSeq) * 100;
  }
}
