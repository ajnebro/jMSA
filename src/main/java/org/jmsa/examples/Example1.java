package org.jmsa.examples;

import org.jmsa.util.ReadMSA;

import org.jmsa.score.impl.PercentageOfNonGaps;
import org.jmsa.score.impl.Entropy;
import org.jmsa.score.impl.PercentageOfTotallyConservedColumns;
import org.jmsa.score.impl.Star;
import org.jmsa.score.impl.SumOfPairs;
import org.jmsa.substitutionmatrix.impl.PAM250;
import org.jmsa.substitutionmatrix.impl.Blosum62;


import java.io.FileNotFoundException;


public class Example1 {

    public static void main(String[]args) throws FileNotFoundException {

        PAM250 p = new PAM250();
        Blosum62 b = new Blosum62();

        ReadMSA r = new ReadMSA();

        Entropy e = new Entropy();
        PercentageOfTotallyConservedColumns pt = new PercentageOfTotallyConservedColumns();
        PercentageOfNonGaps pn = new PercentageOfNonGaps();
        Star stp = new Star(p);
        Star stb = new Star(b);
        SumOfPairs spp = new SumOfPairs(p);
        SumOfPairs spb = new SumOfPairs(b);

        char [][] secuencia = r.readSequenceFromFastaFile("resources/data/hemoglobinAligned.txt");

        System.out.println ("Entropy score: " + e.compute(secuencia));
        System.out.println ("Percentaje of Totally Conserved Columns score: " + pt.compute(secuencia));
        System.out.println ("Percentage on Non Gaps score: " + pn.compute(secuencia));
        System.out.println ("Star score (PAM250): " + stp.compute(secuencia));
        System.out.println ("Star score (Blosum62): " + stb.compute(secuencia));
        System.out.println ("Sum of pairs score (PAM250): " + spp.compute(secuencia));
        System.out.println ("Sum of pairs score (Blosum62): " + spb.compute(secuencia));

    }
}
