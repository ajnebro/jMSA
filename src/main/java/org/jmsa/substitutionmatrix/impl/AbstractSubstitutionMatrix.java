package org.jmsa.substitutionmatrix.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;

public abstract class AbstractSubstitutionMatrix implements SubstitutionMatrix {
  public abstract double getDistance(char char1, char char2) ;
  public abstract char getGapCharacter() ;
  public abstract double getGapPenalty() ;
  public abstract Double getInitialGapPenalty() ;
  public abstract void setGapPenalty(Double gapPenalty) ;
}
