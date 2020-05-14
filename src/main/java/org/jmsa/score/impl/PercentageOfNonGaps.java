package org.jmsa.score.impl;

import org.jmsa.score.Score;

public class PercentageOfNonGaps implements Score {
    public double compute(char[][] sequence) {
        double counterNonGaps = 0;
        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < sequence[i].length; j++) {
                if (sequence[i][j] != '-') {
                    counterNonGaps += 1;
                }
            }
        }
        return counterNonGaps / (sequence.length * sequence[0].length) * 100;
    }
}
