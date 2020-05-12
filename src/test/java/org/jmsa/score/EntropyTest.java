package org.jmsa.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  implement Test for Entropy
 * Entropy('A')= 0--> length =1
 * Entropy('AT')=1
 * Entropy('ATCG')=
 * F2->2
 * negative->??
 *
 */
public class EntropyTest {
    private Entropy entropy;
    private char[][] sequence;
    @BeforeEach
    public void setup(){
        entropy = new Entropy();
    }
    @Test
    public void shouldEntropyOfSequenceOf2NucleotidesReturn0() {
        long expectedValue = 0;
        sequence= new char['A']['A'];
       double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }
    @Test
    public void shouldEntropyOfSequenceOf4DifferentNucleotidesReturn2() {
        long expectedValue = 2;
        sequence= new char[][]{{'A', '-','-','G'}, {'C', 'T'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldEntropyWithGapsOfSequenceOf2NucleotidesReturn0() {
        long expectedValue = 0;
        sequence= new char[][]{{'A','-'},{'A'}};
        double obtainedValue = entropy.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }


}

