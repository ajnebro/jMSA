package org.jmsa.score.impl;
import org.jmsa.score.Score;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;

public class SumOfPairs implements Score {
    private SubstitutionMatrix matrix;

    public SumOfPairs(SubstitutionMatrix m) {
        matrix = m;
    }

    public double compute(char[][] sequence) {
        double totalSum = 0;
        for (int c = 0; c < sequence[0].length; c++) {
            totalSum += sumCol(sequence,c);
            }
        return totalSum;
    }

    public double sumCol(char[][] sequence,int column) {
        double columnSum = 0;
        for (int f = 0; f < sequence.length - 1; f++) {
            for (int p = f + 1; p < sequence.length; p++) {
                columnSum += matrix.getDistance(sequence[f][column], sequence[p][column]);
            }
        }
        return columnSum;
    }
}