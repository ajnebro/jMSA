package org.jmsa.substitutionmatrix.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/** Blosum62 matrix class */
public class GenericSubstitutionMatrix extends AbstractSubstitutionMatrix {
  private static final double DEFAULT_GAP_PENALTY = -8 ;

  private double gapPenalty ;
  private HashMap<List<Character>, Integer> substitutionMatrix;

  public GenericSubstitutionMatrix(String dataFile) {
    this(DEFAULT_GAP_PENALTY, dataFile) ;
  }

  // Constructor that changes gapPenalty value
  public GenericSubstitutionMatrix(double gapPenalty, String dataFile) {
    this.gapPenalty = gapPenalty;
    matrixReader(dataFile);
  }

  // This method takes the distance from substitutionMatrix (HashMap created in readMatrixFromFile)
  @Override
  public double getDistance(char char1, char char2) {
    List<Character> pair = new ArrayList<>();
    pair.add(char1);
    pair.add(char2);
    double distance;

    if (!substitutionMatrix.containsKey(pair)) {
      Collections.reverse(pair);
    }
    distance = Double.valueOf(substitutionMatrix.get(pair));
    return distance;
  }

  // Default gapCharacter
  @Override
  public char getGapCharacter() {
    return '-';
  }

  // GapPenalty value obtained from substitutionMatrix
  @Override
  public double getGapPenalty() {
    return this.gapPenalty;
  }

  private void matrixReader(String dataFile) {
    SubstitutionMatrixReader matrixReader = new SubstitutionMatrixReader();
    this.substitutionMatrix =
        matrixReader.readMatrixFromFile(dataFile, this);
  }

  @Override
  public Double getInitialGapPenalty() {
    return this.gapPenalty;
  }

  @Override
  public void setGapPenalty(Double gapPenalty) {
    this.gapPenalty = gapPenalty;
  }
}
