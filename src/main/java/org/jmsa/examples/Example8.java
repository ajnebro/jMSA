package org.jmsa.examples;

import org.jmsa.score.impl.*;
import org.jmsa.substitutionmatrix.impl.*;
import org.jmsa.util.ReadMSA;

import java.io.FileNotFoundException;

public class Example8 {
    public static void main(String[] args) throws FileNotFoundException {
        ReadMSA reader = new ReadMSA();
        char[][] sequenceAlignment = reader.readSequenceFromFastaFile("./resources/data/Aminoglycoside-3-Phosphotransferase.fasta");

        Entropy entropy = new Entropy();

        PercentageOfNonGaps percentageOfNonGaps = new PercentageOfNonGaps();

        PercentageOfTotallyConservedColumns percentageOfTotallyConservedColumns = new PercentageOfTotallyConservedColumns();

        PAM250 pam250 = new PAM250();
        Blosum62 blosum62 = new Blosum62();

        Star starPAM250 = new Star(pam250);
        Star starBlosum62 = new Star(blosum62);

        SumOfPairs sumOfPairsPAM250 = new SumOfPairs(pam250);
        SumOfPairs sumOfPairsBlosum62 = new SumOfPairs(blosum62);

        System.out.print("Entropy : "+ entropy.compute(sequenceAlignment)+"\n"+
                "Percentage of non-gaps : "+percentageOfNonGaps.compute(sequenceAlignment)+"\n"+
                "Percentage of totally conserved columns : "+percentageOfTotallyConservedColumns.compute(sequenceAlignment)+"\n"+
                "Star PAM250 : "+starPAM250.compute(sequenceAlignment)+"\n"+
                "Star Blosum62 : "+starBlosum62.compute(sequenceAlignment)+"\n"+
                "Sum of pairs PAM250 : "+sumOfPairsPAM250.compute(sequenceAlignment)+"\n"+
                "Sum of pairs Blosum62 : "+sumOfPairsBlosum62.compute(sequenceAlignment));
    }
}
