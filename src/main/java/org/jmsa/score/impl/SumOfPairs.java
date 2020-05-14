package org.jmsa.score.impl;

import org.jmsa.score.Score;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;


/**
 * Hello world!
 */
public class SumOfPairs implements Score {

  private SubstitutionMatrix matrix;

  public SumOfPairs(SubstitutionMatrix m) {
    matrix = m;

  }

  public double compute(char[][] sequence) {

    int totalSum = 0;

    for (int c = 0; c < sequence[0].length; c++) {

      int columnSum = 0;

      for (int f = 0; f < sequence.length - 1; f++) {

        for (int p = f + 1; p < sequence.length; p++) {
            columnSum += matrix.getDistance();

          }
        }
      }
      totalSum += columnSum;
    }

    return totalSum;
  }
}




/*
class SumOfPairs(Score):

    def __init__(self, msa: MSA, substitution_matrix: SubstitutionMatrix = PAM250()):
        super(SumOfPairs, self).__init__(msa=msa)
        self.substitution_matrix = substitution_matrix

    def get_column_score(self, k: int) -> float:
        column = self.get_column(k)

        score_of_column = 0
        for char_a, char_b in self.possible_combinations(column):
            score_of_column += get_score_of_two_chars(self.substitution_matrix, char_a, char_b)

        return score_of_column

    @staticmethod
    def possible_combinations(column) -> itertools.combinations:
        return itertools.combinations(column, 2)

    @staticmethod
    def is_minimization() -> bool:
        return False

 */

