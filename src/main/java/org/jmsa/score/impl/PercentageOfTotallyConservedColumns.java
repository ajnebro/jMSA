package org.jmsa.score.impl;

import org.jmsa.score.Score;

public class PercentageOfTotallyConservedColumns implements Score {
  public double compute(char[][] sequence) {
    double contadorConservedColumns = 0;
    // Realmente lo hacemos hasta la longitud mas corta por si acaso hay otro más largo ya que este de todas formas no coincidirá.
    // Primero debemos saber cuál es la mas corta.
    double longitudMasCorta = sequence[0].length;
    for (int n = 0; n < sequence.length; n++) {
      if (sequence[n].length < longitudMasCorta) {
        longitudMasCorta = sequence[n].length;
      }
    }
    //Ahora que ya tenemos la mas corta es la que usamos
    for (int j = 0; j < longitudMasCorta; j++) {
      double contadorIguales = 0;
      for (int i = 0; i < sequence.length - 1; i++) {
        if (sequence[i][j] == sequence[i + 1][j]) {
          contadorIguales += 1;
        }
        if (contadorIguales == sequence.length - 1) {
          contadorConservedColumns += 1;
        }
      }
    }
    //Al igual que con la más corta necesitamos saber cuál es la más larga, ya que esta será entre la que tenemos que
    //dividir para obtener el porcentaje
    double longitudMasLarga = sequence[0].length;
    for (int p = 0; p < sequence.length; p++) {
      if (sequence[p].length > longitudMasLarga) {
        longitudMasLarga = sequence[p].length;
      }
    }
    return contadorConservedColumns / (longitudMasLarga) * 100;
  }
}

