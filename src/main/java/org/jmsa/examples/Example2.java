package org.jmsa.examples;

import org.jmsa.score.impl.*;
import org.jmsa.substitutionmatrix.impl.Blosum62;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.jmsa.util.ReadMSA;

import java.io.FileNotFoundException;

public class Example2 {
  public static void main(String[] args) {
    try {
      char[][] seq = ReadMSA.readSequenceFromFastaFile("resources/data/AuroraKinaseBMSA.fasta");
      Entropy entropy = new Entropy();
      PercentageOfNonGaps pong = new PercentageOfNonGaps();
      PercentageOfTotallyConservedColumns potcc = new PercentageOfTotallyConservedColumns();
      Star star1 = new Star(new PAM250());
      Star star2 = new Star(new Blosum62());
      SumOfPairs sop1 = new SumOfPairs(new PAM250());
      SumOfPairs sop2 = new SumOfPairs(new Blosum62());
      System.out.println(
          "Entropy: "
              + entropy.compute(seq)
              + "\n"
              + "Percentage of non gaps: "
              + pong.compute(seq)
              + "% \n"
              + "Percentage of totally conserved columns: "
              + potcc.compute(seq)
              + "% \n"
              + "Star PAM250: "
              + star1.compute(seq)
              + "\n"
              + "Star Blosum62: "
              + star2.compute(seq)
              + "\n"
              + "Sum of pairs PAM250: "
              + sop1.compute(seq)
              + "\n"
              + "Sum of pairs Blosum62: "
              + sop2.compute(seq)
              + "\n");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
