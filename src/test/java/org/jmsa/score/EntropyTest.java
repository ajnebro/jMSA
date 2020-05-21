package org.jmsa.score;

import org.jmsa.score.impl.Entropy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * implement Test for Entropy
 * Entropy('A')= 0--> length =1
 * Entropy('AT')=1
 * Entropy('ATCG')=
 * F2->2
 * negative->??
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
    public void shouldEntropyOfSequenceOf2DifferentNucleotidesReturn2() {
        long expectedValue = 1;
        sequence = new char[][]{{'A'}, {'G'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf4DifferentNucleotidesReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', 'G'}, {'C', 'T'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf6EqualNucleotidesReturn1() {
        long expectedValue = 1;
        sequence = new char[][]{{'A', 'G'}, {'A', 'G'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf8InvertedNucleotidesReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', 'G', 'C', 'T'}, {'T', 'C', 'G', 'A'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf8NoOrderNucleotidesReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', 'G', 'C', 'T'}, {'G', 'T', 'A', 'C'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf8EqualNucleotidesReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', 'G', 'C', 'T'}, {'A', 'G', 'C', 'T'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyWith2GapsReturn0() {
        long expectedValue = 0;
        sequence = new char[][]{{'_'}, {'_'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }

    @Test
    public void shouldEntropyWith4GapsReturn0() {
        long expectedValue = 0;
        sequence = new char[][]{{'_', '_'}, {'_', '_'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }

    @Test
    public void shouldEntropyWith8GapsReturn0() {
        long expectedValue = 0;
        sequence = new char[][]{{'_', '_', '_', '_'}, {'_', '_', '_', '_'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }

    @Test
    public void shouldEntropyWithGapsOfSequenceOf2NucleotidesReturn0() {
        long expectedValue = 0;
        sequence = new char[][]{{'A', '-'}, {'A'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }

    @Test
    public void shouldEntropyOfSequenceOf4DifferentNucleotidesWithGapsReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', 'G', '_'}, {'C', 'T', '_'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf4DifferentNucleotidesWithManyGapsReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', '_', 'G', '_'}, {'_', 'C', 'T', '_'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf8InvertedNucleotidesWithGapsReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', 'G', 'C', 'T', '_', '_', '_'}, {'T', 'C', 'G', 'A', '_', '_', '_'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyOfSequenceOf8NoOrderNucleotidesWithInsideReturn2() {
        long expectedValue = 2;
        sequence = new char[][]{{'A', '_', 'G', 'C', '_', 'T'}, {'G', '_', 'T', 'A', 'C', '_'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

}
