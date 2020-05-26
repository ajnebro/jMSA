package org.jmsa.examples;

import org.jmsa.score.impl.*;
import org.jmsa.substitutionmatrix.impl.Blosum62;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.jmsa.util.ReadMSA;

import java.io.FileNotFoundException;

public class Example1 {
  public static void main(String[] args) throws FileNotFoundException {
    char[][] sequence = ReadMSA.readSequenceFromFastaFile("resources/data/hemoglobinAligned.txt");
    Entropy entropy = new Entropy();
    PercentageOfTotallyConservedColumns percentageOfTotallyConservedColumns =
        new PercentageOfTotallyConservedColumns();
    PercentageOfNonGaps percentageOfNonGaps = new PercentageOfNonGaps();
    Star star1 = new Star(new PAM250());
    Star star2 = new Star(new Blosum62());
    SumOfPairs sumOfPairs1 = new SumOfPairs(new PAM250());
    SumOfPairs sumOfPairs2 = new SumOfPairs(new Blosum62());
    System.out.println("Entropy score: " + entropy.compute(sequence));
    System.out.println(
        "Percentage of Totally Conserved Columns score: "
            + percentageOfTotallyConservedColumns.compute(sequence));
    System.out.println("Percentage on Non Gaps score: " + percentageOfNonGaps.compute(sequence));
    System.out.println("Star score (PAM250): " + star1.compute(sequence));
    System.out.println("Star score (Blosum62): " + star2.compute(sequence));
    System.out.println("Sum of pairs score (PAM250): " + sumOfPairs1.compute(sequence));
    System.out.println("Sum of pairs score (Blosum62): " + sumOfPairs2.compute(sequence));
  }
}
