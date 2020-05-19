package org.jmsa.score;

import org.jmsa.score.impl.SumOfPairs;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SumOfPairsTest {

    private SumOfPairs sum;

    @Test
    public void testneg27() {
        char[][] matrix = {{'A', 'A','C'}, {'A', 'T','-'},{'C', '-','A'}};
        /*        {'A', 'A','C'},  +5 -4 -4
                  {'A', 'T','-'},  -4 -4 -4
                  {'C', '-','A'}   -4 -4 -4
                                                +5 - 4*8 = -27*/
        SubstitutionMatrix substitutionMatrix = mock(SubstitutionMatrix.class);
        SumOfPairs sum = new SumOfPairs(substitutionMatrix);

        when(substitutionMatrix.getDistance('A','A')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('A','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','T')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('T','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','G')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('G','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','C')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('C','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','C')).thenReturn(-4.0);

        double expectedValue = -27;
        double obtainedValue =sum.compute(matrix);
        assertEquals(expectedValue, obtainedValue);

    }
    @Test
    public void test0() {
        char[][] matrix = {{'A', 'G','G'}, {'A', 'C','T'},{'A', 'G', '-'}};
        /*      {'A', 'G', 'G'}, AT AT TT       +5 +5 +5
                {'A', 'C', 'T'}, G- GG -G       -4 +5 -4
                {'A', 'G', '-'}  -A -- A-       -4 -4 -4
                                                                +5*4 -4*5=0*/
        SubstitutionMatrix substitutionMatrix = mock(SubstitutionMatrix.class);
        SumOfPairs sum = new SumOfPairs(substitutionMatrix);

        when(substitutionMatrix.getDistance('A','A')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('A','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','T')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('T','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','G')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('G','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','C')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('C','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','C')).thenReturn(-4.0);

        double expectedValue = 0;
        double obtainedValue =sum.compute(matrix);
        assertEquals(expectedValue, obtainedValue);

    }
    @Test
    public void allAlignment() {
        char[][] matrix = {{'A', 'T','C'}, {'A', 'T','C'},{'A', 'T', 'C'}};
        /*      {'A', 'T', 'C'}, AA AA AA       +5 +5 +5
                {'A', 'T', 'C'}, AA AA AA       +5 +5 +5
                {'A', 'T', 'C'}  AA AA AA       +5 +5 +5
                                                                +5*9=45*/
        SubstitutionMatrix substitutionMatrix = mock(SubstitutionMatrix.class);
        SumOfPairs sum = new SumOfPairs(substitutionMatrix);

        when(substitutionMatrix.getDistance('A','A')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('A','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','T')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('T','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','G')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('G','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','C')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('C','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','C')).thenReturn(-4.0);

        double expectedValue = 45;
        double obtainedValue =sum.compute(matrix);
        assertEquals(expectedValue, obtainedValue);

    }
    @Test
    public void allGaps() {
        char[][] matrix = {{'-', '-','-'}, {'-', '-','-'},{'-', '-', '-'}};
        /*      {'-', '-', '-'}, -- -- --       -4 -4 -4
                {'-', '-', '-'}, -- -- --       -4 -4 -4
                {'-', '-', '-'}  -- -- --       -4 -4 -4
                                                                -4*9=-36*/
        SubstitutionMatrix substitutionMatrix = mock(SubstitutionMatrix.class);
        SumOfPairs sum = new SumOfPairs(substitutionMatrix);

        when(substitutionMatrix.getDistance('A','A')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('A','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('A','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','T')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('T','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('T','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','G')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('G','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','C')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('G','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','C')).thenReturn(5.0);
        when(substitutionMatrix.getDistance('C','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('C','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','-')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','A')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','T')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','G')).thenReturn(-4.0);
        when(substitutionMatrix.getDistance('-','C')).thenReturn(-4.0);

        double expectedValue = -36;
        double obtainedValue =sum.compute(matrix);
        assertEquals(expectedValue, obtainedValue);

    }
}