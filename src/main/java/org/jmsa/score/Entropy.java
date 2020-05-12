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
    double totalNumberOfNucleotides = 0;
    double entropy = 0;
    HashMap<Character, Integer> MapOfNucleotideFrequencies = new HashMap<>();
    double nucleotideFrequency = 0;

    for (char[] line : sequence) {
      for (char nuc : line) {
        if (nuc == 'T'||nuc=='A'|| nuc =='C'|| nuc=='G')  {

          if (MapOfNucleotideFrequencies.containsKey(nuc)) {
            MapOfNucleotideFrequencies.put(nuc, MapOfNucleotideFrequencies.get(nuc) + 1);
          } else {
            MapOfNucleotideFrequencies.put(nuc, 1);
          }
          totalNumberOfNucleotides++;

        }
      }

    }


      for (Map.Entry<Character, Integer> entry : MapOfNucleotideFrequencies.entrySet()) {
        nucleotideFrequency = (double) entry.getValue() / totalNumberOfNucleotides;
        entropy += -(nucleotideFrequency * Math.log(nucleotideFrequency) / Math.log(2));
      }
    return entropy;
  }

}
