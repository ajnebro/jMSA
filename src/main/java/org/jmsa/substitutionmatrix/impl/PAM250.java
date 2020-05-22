package org.jmsa.substitutionmatrix.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * PAM250 matrix class
 */
public class PAM250 extends SubstitutionMatrixObject {
  private Double gapPenalty = null;
  private HashMap<List<Character>, Integer> substitutionMatrix;

  //Constructor that takes default gapPenalty value
  //This value is taken from substitutionMatrix file (method readMatrixFromFile)
  public PAM250() {
    this.substitutionMatrix=null;
    matrixReader();
  }

  //Constructor that changes gapPenalty value
  public PAM250(Double gapPenalty) {
    this.gapPenalty = gapPenalty;
    this.substitutionMatrix=null;
    matrixReader();
  }

  //This method takes the distance from substitutionMatrix (HashMap created in readMatrixFromFile)
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

  //Default gapCharacter
  public char getGapCharacter() {
    return '-';
  }

  //GapPenalty value obtained from substitutionMatrix
  public double getGapPenalty() {
    return this.gapPenalty;
  }

  private void matrixReader(){
    SubstitutionMatrixReader matrixReader= new SubstitutionMatrixReader();

    this.substitutionMatrix=matrixReader.readMatrixFromFile("resources/data/PAM250",this);
  }

  public Double getInitialGapPenalty(){
    return this.gapPenalty;
  }

  public void setGapPenalty(Double gapPenalty) {
    this.gapPenalty = gapPenalty;
  }
}