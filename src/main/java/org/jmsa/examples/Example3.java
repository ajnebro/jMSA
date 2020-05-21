package org.jmsa.examples;

import org.jmsa.score.impl.*;
import org.jmsa.substitutionmatrix.impl.Blosum62;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.jmsa.util.ReadMSA;

import java.io.FileNotFoundException;

public class Example3 {
    public static void main(String[] args){
        try{
            // Upload insulin sequences from fasta file
            char[][] insulinSequences = ReadMSA.readSequenceFromFastaFile("resources/data/insulin alignment.fasta");

            //Scores and values
            Entropy entropy = new Entropy();
            Double entropyValue = entropy.compute(insulinSequences);

            PercentageOfNonGaps percentageNonGaps = new PercentageOfNonGaps();
            Double percentageNonGapsValue = percentageNonGaps.compute(insulinSequences);

            PercentageOfTotallyConservedColumns percentageTotConservedColumns = new PercentageOfTotallyConservedColumns();
            Double percentageTotConservedColumnValue = percentageTotConservedColumns.compute(insulinSequences);

            // Star and Sum of pairs need a substitution matrix, we use PAM250 matrix and Blosum62 matrix
            PAM250 pam250Matrix = new PAM250();
            Blosum62 blosum62Matrix = new Blosum62();

            Star starWithPAM250 = new Star(pam250Matrix);
            Double starWithPAM250Value = starWithPAM250.compute(insulinSequences);
            Star starWithBlosum62 = new Star(blosum62Matrix);
            Double starWithBlosum62Value = starWithBlosum62.compute(insulinSequences);

            SumOfPairs sumOfPairsWithPAM250 = new SumOfPairs(pam250Matrix);
            Double sumOfPairsWithPAM250Value = sumOfPairsWithPAM250.compute(insulinSequences);
            SumOfPairs sumOfPairsWithBlosum62 = new SumOfPairs(blosum62Matrix);
            Double sumOfPairsWithBlosum62Value = sumOfPairsWithBlosum62.compute(insulinSequences);

            // Print the results
            System.out.print("Results of multiple sequence alignment with insulin protein sequences: " + "\n"
                    +"Entropy: " + entropyValue + "\n"
                    + "Percentage of non gaps: " + percentageNonGapsValue + "\n"
                    + "Percentage of totally conserved columns: " + percentageTotConservedColumnValue + "\n"
                    + "Star with PAM250 matrix: " + starWithPAM250Value + "\n"
                    + "Star with blosum62 matrix: " + starWithBlosum62Value + "\n"
                    + "Sum of pairs with PAM250 matrix: " + sumOfPairsWithPAM250Value + "\n"
                    + "Sum of pairs with blosum62 matrix: " + sumOfPairsWithBlosum62Value + "\n");
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
