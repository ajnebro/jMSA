package org.jmsa.score.impl;

import org.jmsa.score.Score;

/**
 * Hello world!
 */
public class SumOfPairs implements Score {
  int[][] matrizSuma;
  public double compute(char[][] sequence) {

    for (int i=0; i<sequence[0].length; i++){
      int suma=0;
      for (int j=0; i<sequence[0].length; j++){
        if (sequence[j][i] == sequence[j + 1][i]){
          suma += 5;
        }
        else {
          suma -= 4;
        }
        matrizSuma[j][i]=suma+matrizSuma[j][i];
      }
    }
    /*
    Ya tenemos una matriz con la que sumando los valores de las
    columnas tendriamos la suma de pares de cada una, nos queda hacer tests.
    valorar lo que pasa con los gaps y saber que es el double que tenemos
    que devolver ¿la suma de todas las sumas de pares de las columnas?
     */
    return 0;
  }
}
