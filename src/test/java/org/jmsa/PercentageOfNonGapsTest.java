package org.jmsa;

import org.jmsa.score.impl.PercentageOfNonGaps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 1.- El porcentaje de una secuencia sin gaps es 100
// 2.- El porcentaje de una secuencia que solo tiene gaps es 0
// 3.- El porcentaje de una secuencia con mitad letras y mitad gaps es 50
// 4.- El porcentaje de una secuencia con 3/4 de letras y 1/4 de gaps es 75
// 5.- El porcentaje de una secuencia con 10 letras y 2 gaps es 83.33
// 6.- El porcentaje de una secuencia con 13 letras y 5 gaps es 72.22

public class PercentageOfNonGapsTest {

    private PercentageOfNonGaps pong;
    private char[][] sequence;

    @BeforeEach
    public void setUp() {
        pong = new PercentageOfNonGaps();
    }

    @Test
    public void elPorcentajeDeSequenceTodoLetrasEs100() {
        sequence = new char[][]{{'A', 'G', 'A', 'T'}, {'G', 'G', 'C', 'T'}, {'A', 'G', 'C', 'C'}};
        assertEquals(100, pong.compute(sequence));
    }

    @Test
    public void elPorcentajeDeSequenceTodoGapsEs0() {
        sequence = new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        assertEquals(0, pong.compute(sequence));
    }

    @Test
    public void elPorcentajeDeSequenceMitadLetrasMitadGapsEs50() {
        sequence = new char[][]{{'-', 'G', '-', 'T', '-'}, {'A', 'G', '-', '-', 'T'}};
        assertEquals(50, pong.compute(sequence));
    }

    @Test
    public void elPorcentajeDeSequenceTresCuartosLetrasEs75() {
        sequence = new char[][]{{'A', 'G', '-', 'T'}, {'G', '-', 'C', 'T'}, {'A', 'G', '-', 'C'}};
        assertEquals(75, pong.compute(sequence));
    }

    @Test
    public void elPorcentajeDeSequence2Gapsy10LetrasEs83con33() {
        sequence = new char[][]{{'A', 'G', '-', 'T'}, {'G', 'G', 'C', 'T'}, {'A', 'G', '-', 'C'}};
        assertEquals(((double) 10 / 12) * 100, pong.compute(sequence));
    }

    @Test
    public void elPorcentajeDeSequence5Gapsy13LetrasEs72con22() {
        sequence = new char[][]{{'C', 'G'}, {'A', '-'}, {'G', 'T'}, {'-', 'C'}, {'A', '-'}, {'-', 'C'},
                {'C', 'G'}, {'A', '-'}, {'G', 'T'}};
        assertEquals(((double) 13 / 18) * 100, pong.compute(sequence));
    }
}
