package java.org.jmsa.score.impl;

import org.jmsa.score.Score;

import java.org.jmsa.score.impl.starScoreMatrix;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;

/**
 * Hello world!
 * grupo 3: irene sanchez, clara jimenez y lucia valverde
 */
public class Star implements Score {
  private starScoreMatrix scoreMatrix;


  public Star(starScoreMatrix matrix){
    scoreMatrix = matrix;
  }
  public double compute(char[][] sequence) {
    double result = 0;
    //Recorremos las secuencias dentro de sequence. Suponemos que todas las secuencias tienen el mismo tamaño
    for (int columnSequence = 0; columnSequence<length(sequence[0]); columnSequence++){
      //1. Seleccionamos el aa más repetido de todas las secuencias en la posición (o columna) columnSequence. Para ello creamos dos arrays con la misma longitud
      // En uno guardamos el char del aa y en el otro su frecuencia
      Character[] aaChar = new Character[length(sequence)];
      int[] aaFreq = new int[length(sequence)];
      //Por cada aa de la columna que estamos leyendo
      for(int e = 0; e<length(sequence); e ++){
        Character aa = sequence[e][columnSequence];
        boolean found = false;
        int index = 0;
        //Si el aa está en el array, aumentamos la frecuencia
        while(found==false || index <length(aaFreq)) {
          if (aa.equals(aaChar[index])) {
            aaFreq[index] = aaFreq[index] + 1;
            found = true;
          }
          index = index + 1;
        }
        //Si el aa no está en el array, buscamos la primera posicion a cero y lo añadimos
        if(!found){
          int index2 = 0;
          boolean notFound = true;
          while(notFound || index2 <length(aaFreq)){
            if(aaFreq[index2] ==0){
              aaChar[index2] = aa;
              aaFreq[index2] = 1;
              notFound = true;
            }
          }
        }

      }
      Character moreRepeated = aaChar[0];
      int value = aaFreq[0];
      for (int v =0; v<length(aaFreq); v++) {
        //Recorremos el array buscando la posición con la mayor frecuencia y guardamos el aa correspondiente. Este será el centro de la estrella
        if (value < aaFreq[v]) {
          value = aaFreq[v];
          moreRepeated = aaChar[value];
        }
      }
      //2. Calculamos la puntuación para esta columna
      for (int numSeq = 0; numSeq<length(sequence); numSeq ++){
        double distance= scoreMatrix.getDistance(moreRepeated, sequence[numSeq][columnSequence]);
        //3. Sumamos la distnacie al resultado total a devolver
        result = result +distance;
      }

    }
    return (result);
  }


}
