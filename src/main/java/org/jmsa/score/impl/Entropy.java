package org.jmsa.score.impl;

import org.jmsa.score.Score;

import java.util.HashMap;
import java.util.Map;

/** Compute entropy of a given multiple sequence char */
public class Entropy implements Score {
  public double compute(char[][] multipleSequences) {
    /* initialization */
    double totalNumberOfWords = 0;
    HashMap<Character, Integer> MapOfWordsWhitTimesOfRepetition = new HashMap<>();
    double wordsFrequency = 0;
    double entropyValue = 0;
    /* calculate time every different word appears in a sequence; word can be amino acid or nucleotide */
    for (char[] sequence : multipleSequences) {
      for (char word : sequence) {
        if (word != '-') {
          if (MapOfWordsWhitTimesOfRepetition.containsKey(word)) {
            MapOfWordsWhitTimesOfRepetition.put(
                word, MapOfWordsWhitTimesOfRepetition.get(word) + 1);
          } else {
            MapOfWordsWhitTimesOfRepetition.put(word, 1);
          }
          totalNumberOfWords++;
        }
      }
    }
    /* calculate Entropy */
    for (Map.Entry<Character, Integer> nucleotideInMap :
        MapOfWordsWhitTimesOfRepetition.entrySet()) {
      wordsFrequency = (double) nucleotideInMap.getValue() / totalNumberOfWords;
      entropyValue += -(wordsFrequency * Math.log(wordsFrequency));
    }
    return entropyValue;
  }

  @Override
  public boolean isAMinimizationScore() {
    return false;
  }

  @Override
  public String name() {
    return "Entropy" ;
  }
}
