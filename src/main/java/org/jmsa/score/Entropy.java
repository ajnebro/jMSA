package org.jmsa.score;

import org.jmsa.score.Score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class Entropy implements Score {
  public double compute(char[][] sequence) {

    double t = 0;
    double a = 0;
    double g = 0;
    double c = 0;
    double total= sequence.length;
    double entropy = 0;
    List<Double> frequencies;
    for (int i = 0; i <= sequence.length; i++) {
      for (int j = 0; j <= sequence.length; j++) {
        switch (sequence[i][j]) {
          case 'a':
            a++;
            break;
          case 'c':
            c++;
            break;
          case 't':
            t++;
            break;
          case 'g':
            g++;
            break;
        }
      }
    }
    frequencies = List.of(a/total, c/total, t/total, g/total);
    for (double nucleotideFrequency : frequencies)
      entropy += -(nucleotideFrequency * Math.log(nucleotideFrequency) / Math.log(2));
    return entropy;
  }
}
