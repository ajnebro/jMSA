package org.jmsa.substitutionmatrix.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;

/**
 * Hello world!
 */
public class Blosum62 implements SubstitutionMatrix {
  public double getDistance(char char1, char char2) {
    return 0 ;
  }

  public char getGapCharacter() {
    return '-' ;
  }

  public double getGapPenalty() {
    return 0 ;
  }
}
