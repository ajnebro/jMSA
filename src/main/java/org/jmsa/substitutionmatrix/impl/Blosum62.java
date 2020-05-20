package org.jmsa.substitutionmatrix.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;
import java.util.*;

/**
 * Blosum62 matrix class
 */
public class Blosum62 implements SubstitutionMatrix {
private Double gapPenalty = null;
  private HashMap<List<Character>, Integer> substitutionMatrix;

  //Constructor that takes default gapPenalty value
  //This value is taken from substitutionMatrix file (method readMatrixFromFile)
  public Blosum62() {this.substitutionMatrix=null;
  matrixReader();}

  //Constructor that changes gapPenalty value
  public Blosum62(Double gapPenalty) {
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
    this.substitutionMatrix=matrixReader.readMatrixFromFile("resources/data/Blosum62Matrix",this);
  }

  public Double getInitialGapPenalty(){
    return this.gapPenalty;
  }

  public void setGapPenalty(Double gapPenalty) {
    this.gapPenalty = gapPenalty;
  }
}