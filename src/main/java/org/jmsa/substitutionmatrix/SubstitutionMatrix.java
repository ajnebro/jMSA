package org.jmsa.substitutionmatrix;

/**
 * Hello world!
 */
public interface SubstitutionMatrix {
  double getDistance(char char1, char char2);

  default char getGapCharacter() {
    return '-' ;
  }

  double getGapPenalty() ;
}
