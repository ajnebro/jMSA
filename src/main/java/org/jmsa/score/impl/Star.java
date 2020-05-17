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

    for (int posAAinSequence = 0; posAAinSequence < sequence[0].length; posAAinSequence++) {
      /* 1. We select the most repeated Aa from all sequences in the position posAAinSequence.
      To do this, we call aaMoreRepeated method.
       */
      Character moreRepeatedAA = aaMoreRepeated(sequence, posAAinSequence);

      // 2. We compute the punctuation for this column
      for (char[] chars : sequence) {
        double distance = scoreMatrix.getDistance(moreRepeatedAA, chars[posAAinSequence]);

        // 3. We add the distance to the total result we have to return
        result = result + distance;
      }
    }
    return (result);
  }

  public Character aaMoreRepeated(char[][] parameterSequence, int parameterPosAAinSequence){
    /*
    The aim of this function is to return the Character of the most repeated aa in a determined position
    of a group of sequences.
      First, we create a map in which we store the char corresponding to our Aa and its frequency.
      Then, we select the most repeated aa in the map.
     */

    HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();

    for (int numberOfSequence = 0; numberOfSequence < parameterSequence.length; numberOfSequence++) {
      Character aa = parameterSequence[numberOfSequence][parameterPosAAinSequence];
      if (charFreq.containsKey(parameterSequence[numberOfSequence][parameterPosAAinSequence])) {
        Integer newFreq = (Integer) charFreq.get(aa) + 1;
        charFreq.remove(aa);
        charFreq.put(aa, newFreq);
      } else {
        charFreq.put(aa, 1);
      }
    }
    int moreRepeatedFreq = 0;
    Character moreRepeatedAA = parameterSequence[0][parameterPosAAinSequence];

    for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
      if (entry.getValue() > moreRepeatedFreq) {
        moreRepeatedAA = entry.getKey();
        moreRepeatedFreq = entry.getValue();
      }
    }
    return moreRepeatedAA;
  }

}