package org.jmsa.substitutionmatrix.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/** Blosum62 matrix class */
public class Blosum62 extends AbstractSubstitutionMatrix {
  private Double gapPenalty = null;
  private HashMap<List<Character>, Integer> substitutionMatrix;

  // Constructor that takes default gapPenalty value
  // This value is taken from substitutionMatrix file (method readMatrixFromFile)
  public Blosum62() {
    this.substitutionMatrix = null;
    matrixReader();
  }

  // Constructor that changes gapPenalty value
  public Blosum62(Double gapPenalty) {
    this.gapPenalty = gapPenalty;
    this.substitutionMatrix = null;
    matrixReader();
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

  private void matrixReader() {
    SubstitutionMatrixReader matrixReader = new SubstitutionMatrixReader();
    this.substitutionMatrix =
        matrixReader.readMatrixFromFile("resources/data/Blosum62Matrix", this);
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
