package org.jmsa.score.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Sequence;

import static org.junit.jupiter.api.Assertions.*;

class SumOfPairsTest {
    private int[][] matrix = {{5, -4, -4, -4}, {-4, 5, -4, -4}, {-4, -4, 5, -4}, {-4, -4, -4, 5}};
    private SumOfPairs sum;

    @BeforeEach
    public void setup(){
        sum=new SumOfPairs(matrix);
    }
    // creamos una matriz con las distancias

    @Test
    public void equalSequencesShouldReturn5LengthSeq() {

        char[][] sequence = {{'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}, {'A', 'T', 'C', 'G'}};
        double expectedValue = 60;
        double obtainedValue = Sequence.compute(sequence);
        assertEquals(expectedValue, obtainedValue);

    }
}