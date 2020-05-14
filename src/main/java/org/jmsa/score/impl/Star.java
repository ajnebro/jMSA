package org.jmsa.score.impl;

import org.jmsa.score.Score;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;

import java.util.HashMap;
import java.util.Map;

/** grupo 3: irene sanchez, clara jimenez y lucia valverde */
public class Star implements Score {
  private final SubstitutionMatrix scoreMatrix;

  public Star(SubstitutionMatrix matrix) {
    scoreMatrix = matrix;
  }

  public double compute(char[][] sequence) {
    double result = 0;

    // We go through the sequences inside sequence. We assume all sequences have the same size

    for (int columnSequence = 0; columnSequence < sequence[0].length; columnSequence++) {
      /* 1. We select the most repeated Aa from all sequences in the column columnSequence.
      To do this we create two arrays with the same size. In one of them we store the char
      corresponding to our Aa, and the other stores its frequency
       */
      // 1. Seleccionamos el aa más repetido de todas las secuencias en la posición (o columna)
      // columnSequence. Para ello creamos dos arrays con la misma longitud
      // En uno guardamos el char del aa y en el otro su frecuencia

      HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();

      for (int k = 0; k < sequence.length; k++) {
        Character letter = sequence[k][columnSequence];
        if (charFreq.containsKey(sequence[k][columnSequence])) {
          Integer newFreq = (Integer) charFreq.get(letter) + 1;
          charFreq.remove(letter);
          charFreq.put(letter, newFreq);
        } else {
          charFreq.put(letter, 1);
        }
      }
      int moreRepeatedFreq = 0;
      Character moreRepeated = sequence[0][columnSequence];

      for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
        if (entry.getValue() > moreRepeatedFreq) {
          moreRepeated = entry.getKey();
          moreRepeatedFreq = entry.getValue();
        }
      }
      // 2. We compute the puntuation for this column
      // 2. Calculamos la puntuación para esta columna
      for (char[] chars : sequence) {
        double distance = scoreMatrix.getDistance(moreRepeated, chars[columnSequence]);

        // 3. We add the distance to the total result we have to return
        // 3. Sumamos la distancia al resultado total a devolver
        result = result + distance;
      }
    }
    return (result);
  }
}
