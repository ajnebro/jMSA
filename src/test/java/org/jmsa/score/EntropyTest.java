package org.jmsa.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.jmsa.score.impl.Entropy;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * implement Test for Entropy
 * Entropy('A')= 0--> length =1
 */

public class EntropyTest {

    private Entropy entropy;
    private char[][] sequence;

    @BeforeEach
    public void setup() {
        entropy = new Entropy();
    }

    @Test
    public void shouldEntropyOfSequenceOf2NucleotidesReturn0() {
        long expectedValue = 0;
        sequence = new char['A']['A'];
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf2DifferentNucleotidesReturn069() {
        double expectedValue = 0.69;
        sequence = new char[][]{{'A'}, {'G'}};
        double obtainedValueRoundedWithTwoDecimals = (double) Math.round(entropy.compute(sequence) * 100d) / 100d;
        assertEquals(expectedValue, obtainedValueRoundedWithTwoDecimals);
    }

    @Test
    public void shouldEntropyOfSequenceOf4DifferentNucleotidesReturn139() {
        double expectedValue = 1.39;
        sequence = new char[][]{{'A', 'G'}, {'C', 'T'}};
        double obtainedValueRoundedWithTwoDecimals = (double) Math.round(entropy.compute(sequence) * 100d) / 100d;
        assertEquals(expectedValue, obtainedValueRoundedWithTwoDecimals);
    }

    @Test
    public void shouldEntropyOfSequenceOf8InvertedNucleotidesReturn139() {
        double expectedValue = 1.39;
        sequence = new char[][]{{'A', 'G', 'C', 'T'}, {'T', 'C', 'G', 'A'}};
        double obtainedValueRoundedWithTwoDecimals = (double) Math.round(entropy.compute(sequence) * 100d) / 100d;
        assertEquals(expectedValue, obtainedValueRoundedWithTwoDecimals);
    }

    @Test
    public void shouldEntropyWithGapAndOneDifferentNucleotideReturn0() {
        long expectedValue = 0;
        sequence = new char[][]{{'-', 'A', '-', '-'}, {'-', 'A', '-', '-'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }

    @Test
    public void shouldEntropyOfSequenceOf4DifferentNucleotidesWithManyGapsReturn139() {
        double expectedValue = 1.39;
        sequence = new char[][]{{'A', '-', 'G', '-'}, {'-', 'C', 'T', '-'}};
        double obtainedValueRoundedWithTwoDecimals = (double) Math.round(entropy.compute(sequence) * 100d) / 100d;
        assertEquals(expectedValue, obtainedValueRoundedWithTwoDecimals);
    }
}