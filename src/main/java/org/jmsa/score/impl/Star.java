package java.org.jmsa.score.impl;

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

    // Recorremos las secuencias dentro de sequence. Suponemos que todas las secuencias tienen el
    // mismo tamaño
    for (int columnSequence = 0; columnSequence < sequence[0].length; columnSequence++) {
      // 1. Seleccionamos el aa más repetido de todas las secuencias en la posición (o columna)
      // columnSequence. Para ello creamos dos arrays con la misma longitud
      // En uno guardamos el char del aa y en el otro su frecuencia

      HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();

      for (int k = 0; k < sequence.length; k++){
        Character letter = sequence[k][columnSequence];
        if(charFreq.containsKey(sequence[k][columnSequence])){
          Integer newFreq = (Integer) charFreq.get(letter) +1;
          charFreq.remove(letter);
          charFreq.put(letter, newFreq);
        }
        else{
          charFreq.put(letter, 1);
        }
      }
      int moreRepeatedFreq = 0;
      Character moreRepeated = sequence[0][columnSequence];

      for(Map.Entry<Character, Integer> entry :charFreq.entrySet()){
        if(entry.getValue()>moreRepeatedFreq){
          moreRepeated = entry.getKey();
          moreRepeatedFreq = entry.getValue();
        }
      }
      /*


      Character[] aaChar = new Character[sequence.length];
      int[] aaFreq = new int[sequence.length];

      // Por cada aa de la columna que estamos leyendo
      for (char[] chars : sequence) {
        Character aa = chars[columnSequence];
        boolean found = false;
        int index = 0;
        // Si el aa está en el array, aumentamos la frecuencia
        while (!found && index < aaFreq.length) {
          if (aa.equals(aaChar[index])) {
            aaFreq[index] = aaFreq[index] + 1;
            found = true;
          }
          index++;
        }
        // Si el aa no está en el array, buscamos la primera posicion a cero y añadimos el aa
        if (!found) {
          int index2 = 0;
          boolean notFound = true;
          while (notFound && index2 < aaFreq.length) {
            if (aaFreq[index2] == 0) {
              aaChar[index2] = aa;
              aaFreq[index2] = 1;
              notFound = true;
            }
            index2++;
          }
        }
      }
      Character moreRepeated = aaChar[0];
      int value = aaFreq[0];
      for (int i : aaFreq) {
        // Recorremos el array buscando la posición con la mayor frecuencia y guardamos el aa
        // correspondiente. Este será el centro de la estrella
        if (value < i) {
          value = i;
          moreRepeated = aaChar[value];
        }
      }
      */

      // 2. Calculamos la puntuación para esta columna
      for (char[] chars : sequence) {
        double distance = scoreMatrix.getDistance(moreRepeated, chars[columnSequence]);

        // 3. Sumamos la distancia al resultado total a devolver
        result = result + distance;
      }
    }
    return (result);
  }
}
