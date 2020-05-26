package org.jmsa.examples;

import org.jmsa.score.impl.*;
import org.jmsa.substitutionmatrix.impl.Blosum62;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.jmsa.util.ReadMSA;

import java.io.FileNotFoundException;

public class Example5 {
  public static void main(String[] args) {
    ReadMSA seqReader = new ReadMSA();
    PercentageOfNonGaps pong = new PercentageOfNonGaps();
    PercentageOfTotallyConservedColumns potcc = new PercentageOfTotallyConservedColumns();
    char[][] seqArray = new char[0][];
    Entropy entropy = new Entropy();
    Blosum62 blosum62 = new Blosum62();
    PAM250 pam250 = new PAM250();
    Star starPam250 = new Star(pam250);
    Star starBlosum62 = new Star(blosum62);
    SumOfPairs sumOfPairsPam250 = new SumOfPairs(pam250);
    SumOfPairs sumOfPairsBlosum62 = new SumOfPairs(blosum62);

    {
      try {
        seqArray = seqReader.readSequenceFromFastaFile("./resources/data/vih.fasta");
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Percentaje of non gaps:" + pong.compute(seqArray));
    System.out.println("Percentaje of totally conserved collums:" + potcc.compute(seqArray));
    System.out.println("Entropy:" + entropy.compute(seqArray));
    System.out.println("Star score (Blosum62):" + starBlosum62.compute(seqArray));
    System.out.println("Star score (PAM250):" + starPam250.compute(seqArray));
    System.out.println("Sum of pairs score (Blosum62):" + sumOfPairsBlosum62.compute(seqArray));
    System.out.println("Sum of pairs score (PAM250):" + sumOfPairsPam250.compute(seqArray));
  }
}
