package org.jmsa.score.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Case 1:
    [[A]
     [B]
     [C]
 * Case 2:
 *
 *
 */

class StarTest {
  class DummySubstitutionMatrix implements SubstitutionMatrix{
    char[][]matrix ;


    @Override
    public double getDistance(char char1, char char2) {
      return 0;
    }

    @Override
    public double getGapPenalty() {
      return 0;
    }
  }

}