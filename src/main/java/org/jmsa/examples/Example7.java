package org.jmsa.examples;
import org.jmsa.util.ReadMSA;
import org.jmsa.score.impl.*;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.jmsa.substitutionmatrix.impl.Blosum62;

import java.io.FileNotFoundException;

public class Example7 {

    public static void main(String[]args) throws FileNotFoundException {

        try {
            ReadMSA readMSA = new ReadMSA();
            char[][] sequence = readMSA.readSequenceFromFastaFile("./resources/data/P04818(TYSY_HUMAN).fasta");

            Star star1 = new Star(new PAM250());
            Star star2 = new Star(new Blosum62());
            System.out.println("Star Blosum62: " + star2.compute(sequence));
            System.out.println("Star PAM250: " + star1.compute(sequence));

            SumOfPairs sumOfPairs1 = new SumOfPairs(new PAM250());
            SumOfPairs sumOfPairs2 = new SumOfPairs(new Blosum62());
            System.out.println("Sum of Pairs Blosum62: " + sumOfPairs2.compute(sequence));
            System.out.println("Sum of Pairs PAM250: " + sumOfPairs1.compute(sequence));

            Entropy entropy = new Entropy();
            System.out.println("Entropy score: " + entropy.compute(sequence));

            PercentageOfNonGaps nonGaps = new PercentageOfNonGaps();
            PercentageOfTotallyConservedColumns totallyConservedColumns = new PercentageOfTotallyConservedColumns();
            System.out.println("Percentage on non-gaps: " + nonGaps.compute(sequence));
            System.out.println("Percentage of totally conserved columns: " + totallyConservedColumns.compute(sequence));

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
