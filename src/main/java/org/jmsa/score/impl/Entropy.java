package org.jmsa.score.impl;

import org.jmsa.score.Score;

import java.util.HashMap;
import java.util.Map;

/**
 * Compute entropy of a given multiple sequence char
 */
public class Entropy implements Score {
  public double compute(char[][] multipleSequences) {
    double totalNumberOfNucleotides = 0;
    HashMap<Character, Integer> MapOfNucleotideWhitTimesOfRepetition = new HashMap<>();
    double nucleotideFrequency = 0;
    double entropyValue = 0;

    for (char[] sequence : multipleSequences) {
      for (char nucleotide : sequence) {
        if (nucleotide != '-') {
          if (MapOfNucleotideWhitTimesOfRepetition.containsKey(nucleotide)) {
            MapOfNucleotideWhitTimesOfRepetition.put(nucleotide, MapOfNucleotideWhitTimesOfRepetition.get(nucleotide) + 1);
          } else {
            MapOfNucleotideWhitTimesOfRepetition.put(nucleotide, 1);
          }
          totalNumberOfNucleotides++;
        }
      }
    }

    for (Map.Entry<Character, Integer> nucleotideInMap : MapOfNucleotideWhitTimesOfRepetition.entrySet()) {
      nucleotideFrequency = (double) nucleotideInMap.getValue() / totalNumberOfNucleotides;
      entropyValue += -(nucleotideFrequency * Math.log(nucleotideFrequency));
    }
    return entropyValue;
  }
}

