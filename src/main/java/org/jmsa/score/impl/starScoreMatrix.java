package java.org.jmsa.score.impl;

import java.util.HashMap;
import java.util.Map;

public class starScoreMatrix implements org.jmsa.substitutionmatrix.SubstitutionMatrix {
    private int[][] matrix;
    private Map<Character, Integer> matrixMap;
    public starScoreMatrix(){
        //Por defecto creamos una matriz de aminoácidos. Tendremos get y set para modificarla
        matrix = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == j) {
                    matrix[i][j] = 5;
                } else {
                    matrix[i][j] = -4;
                }
            }
        }
        //La matriz necesita un mapa que relacione la columna/fila (será lo mismo, es simétrica) con el aa.
        matrixMap = new HashMap<>();
        matrixMap.put('A', 0);
        matrixMap.put('R', 1);
        matrixMap.put('N', 2);
        matrixMap.put('D', 3);
        matrixMap.put('C', 4);
        matrixMap.put('Q', 5);
        matrixMap.put('E', 6);
        matrixMap.put('G', 7);
        matrixMap.put('H', 8);
        matrixMap.put('I', 9);
        matrixMap.put('L', 10);
        matrixMap.put('K', 11);
        matrixMap.put('M', 12);
        matrixMap.put('F', 13);
        matrixMap.put('P', 14);
        matrixMap.put('S', 15);
        matrixMap.put('T', 16);
        matrixMap.put('W', 17);
        matrixMap.put('Y', 18);
        matrixMap.put('V', 19);

    }
    @Override
    public double getDistance(char char1, char char2) {
        int pos1 = matrixMap.get(char1);
        int pos2 = matrixMap.get(char2);
        double distance = matrix[pos1][pos2];
        return distance;
    }

    @Override
    public double getGapPenalty() {
        return 0;
    }
}
