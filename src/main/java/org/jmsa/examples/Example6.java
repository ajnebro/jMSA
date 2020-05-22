package org.jmsa.examples;
import org.jmsa.util.ReadMSA;
import org.jmsa.score.impl.*;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.jmsa.substitutionmatrix.impl.Blosum62;

import java.io.FileNotFoundException;

public class Example6 {
    public static void main(String[]args) throws FileNotFoundException {
        try {
            ReadMSA readMSA = new ReadMSA();
            char[][] CoVsequence = readMSA.readSequenceFromFastaFile("./resources/data/secuenciaalineada.fasta");
            PAM250 pam250 = new PAM250();
            Blosum62 blosum62 = new Blosum62();
            SumOfPairs sumOfPairsPam250 = new SumOfPairs(pam250);
            SumOfPairs sumOfPairsBlosum62 = new SumOfPairs(blosum62);
            Star starPam250 = new Star(pam250);
            Star starBlosum62 = new Star(blosum62);
            Entropy entropy = new Entropy();
            PercentageOfTotallyConservedColumns percentageOfTotallyConservedColumns = new PercentageOfTotallyConservedColumns();
            PercentageOfNonGaps percentageOfNonGaps = new PercentageOfNonGaps();

            System.out.println ("Percentage on non-gaps: " + percentageOfNonGaps.compute(CoVsequence));
            System.out.println ("Percentage of totally conserved columns: " + percentageOfTotallyConservedColumns.compute(CoVsequence));
            System.out.println ("Entropy score: " + entropy.compute(CoVsequence));
            System.out.println ("Sum of Pairs score (Blosum62): " + sumOfPairsBlosum62.compute(CoVsequence));
            System.out.println ("Sum of Pairs score (PAM250): " + sumOfPairsPam250.compute(CoVsequence));
            System.out.println ("Star score (Blosum62): " + starBlosum62.compute(CoVsequence));
            System.out.println ("Star score (PAM250): " + starPam250.compute(CoVsequence));
        } catch (FileNotFoundException e) {
            System.out.println("Path not found");
        }
    }

}
