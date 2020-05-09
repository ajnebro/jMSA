package org.jmsa.substitutionmatrix.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class Blosum62 implements SubstitutionMatrix {

    private Map<List, Double> substitutionMatrix = new HashMap<List, Double>();
    private double gapPenalty;

    public Blosum62() throws IOException {
        this(-8);
    }

    public Blosum62(double gP) throws IOException {
        gapPenalty=gP;
        substitutionMatrix=matrixReader();
    }

    public double getDistance(char char1, char char2) {

      double result=0;
      if(char1=='-' & char2 =='-'){
          result=1;
      }else if (char1=='-' || char2 =='-'){
          result=this.getGapPenalty();
      }else{
          Map<List, Double> matrix = substitutionMatrix;
          if (matrix.get(List.of(char1, char2))!=null) {
              result = matrix.get(List.of(char1, char2));
          }else{
              result = matrix.get(List.of(char2, char1));
          }
      }
      return result ;
  }

  public char getGapCharacter(){
    return '-' ;
  }

  public double getGapPenalty() {
    return gapPenalty ;
  }

  private Map matrixReader() throws IOException {


      String filePath = new File("resources\\data\\Blosum62.txt").getAbsolutePath();
      Map<List, Double> sMatrix = new HashMap<List, Double>();

      String line;
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      while ((line = reader.readLine()) != null)
      {
          String[] parts = line.split(":", 2);
          if (parts.length >= 2)
          {
              String[] lp=parts[0].split(",");
              List key = List.of(lp[0].charAt(0),lp[1].charAt(0));
              String value = parts[1];
              sMatrix.put(key, Double.valueOf(value));
          } else {
              System.out.println("ignoring line: " + line);
          }
      }
      reader.close();

        return sMatrix;
    }
}
