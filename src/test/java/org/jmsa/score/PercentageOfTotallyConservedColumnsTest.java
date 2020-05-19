package org.jmsa.score;

import org.jmsa.score.impl.PercentageOfTotallyConservedColumns;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercentageOfTotallyConservedColumnsTest {
    /*Vamos a hacer una serie de pruebas para comprobar que nuestro programa funciona:
        1. El porcentaje de una secuencia en la que coinciden todas las columnas es 100.
        2. El porcentaje de una secuencia en la que no coincide ninguna columa es 0.
        3. El porcentaje de una secuencia en la que coinciden la mitad de las columnas ha de ser 50.
        4. El porcentaje de una secuencia en la que coinciden 2 columnas de 7 debe de ser 40.
        5. Si alguna tiene más columnas que otra se cogerá la más pequeña para asegurar que sean todos los que coincidan
        para esto vamos a usar una que será mas corta que el resto. Esta más corta no tendrá ninguna en común mientras que
         las otras más largas si tendrán. Esta prueba ha de devolver 0.
    * */
    private char[][] sequence;
    private PercentageOfTotallyConservedColumns potcc;

    @BeforeEach
    public void setUp(){
        potcc = new PercentageOfTotallyConservedColumns();
    }
    @Test
    public void porcentajeCoincidenTodasDevuelve100(){
        sequence = new char[][]{{'A', 'G', 'C'}, {'A', 'G', 'C'}, {'A', 'G', 'C'}};
        assertEquals(100, potcc.compute(sequence));

    }
    @Test
    public void porcentajeCoincidenNingunaDevuelve0(){
        sequence = new char[][]{{'A', 'C', 'T'}, {'C', 'T', 'A'}, {'T', 'A', 'C'}};
        assertEquals(0, potcc.compute(sequence));
    }
    @Test
    public void porcentajeCoincidenLaMitadDevuelve50(){
        sequence = new char[][]{{'A', 'C', 'T', 'T'}, {'C', 'C', 'T','G'}, {'T', 'C', 'T', 'G'}};
        assertEquals(50, potcc.compute(sequence));
    }
    @Test
    public void porcentajeCoinciden2de7devuelve2857(){
        sequence = new char[][]{{'A', 'C', 'T', 'T', 'T'}, {'C', 'C', 'T','G', 'T'}, {'T', 'C', 'T', 'G', 'A'}};
        assertEquals(((double)2/5)*100, potcc.compute(sequence));
    }
    @Test
    public void porcentajeCoinciden0comprobamosLongitudDevuelve0(){
        sequence = new char[][]{{'A'}, {'C', 'C', 'T','G', 'T'}, {'T', 'C', 'T', 'G', 'A'}};
        assertEquals(0, potcc.compute(sequence));
    }


}