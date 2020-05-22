package org.jmsa.substitutionmatrix.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;

public class SubstitutionMatrixObject implements SubstitutionMatrix {

    public double getDistance(char char1, char char2) {
        return 0;
    }

    public char getGapCharacter() {
        return 0;
    }

    public double getGapPenalty() {
        return 0;
    }

    public Double getInitialGapPenalty() {
        return null;
    }

    public void setGapPenalty(Double gapPenalty) {

    }
}
