package org.jmsa.score;

public interface Score {
  double compute(char[][] sequence);
  boolean isAMinimizationScore();
  String name() ;
}
