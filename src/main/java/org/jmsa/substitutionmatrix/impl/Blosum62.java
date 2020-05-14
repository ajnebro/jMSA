package org.jmsa.substitutionmatrix.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class Blosum62 implements SubstitutionMatrix {

    private final Map<List<String>, Double> substitutionMatrix;
    private double gapPenalty;

    public Blosum62() {
        this(-8D);
    }

    public Blosum62(double gP) {
        gapPenalty = gP;
        substitutionMatrix = matrixReader();
    }

    public double getDistance(char char1, char char2) {

        double result;
        if (char1 == '-' & char2 == '-') {
            result = 1;
        } else if (char1 == '-' || char2 == '-') {
            result = this.getGapPenalty();
        } else {
            Map<List<String>, Double> matrix = substitutionMatrix;
            if (matrix.get(List.of(char1, char2)) != null) {
                result = matrix.get(List.of(char1, char2));
            } else {
                result = matrix.get(List.of(char2, char1));
            }
        }
        return result;
    }

    public char getGapCharacter() {
        return '-';
    }

    public double getGapPenalty() {
        return gapPenalty;
    }

    private Map matrixReader() {

        Map<List<String>, Double> substitutionMatrix = new HashMap<List<String>, Double>();
        String line;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(String.valueOf(Paths.get("resources/data/Blosum62.txt"))));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length >= 2) {
                    String[] lp = parts[0].split(",");
                    List key = List.of(lp[0].charAt(0), lp[1].charAt(0));
                    String value = parts[1];
                    substitutionMatrix.put(key, Double.valueOf(value));
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File: Blosum62 is not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("An IO error has occured: " + e.getMessage());
            System.exit(1);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // nothing
                }
            }
        }

        return substitutionMatrix;
    }


}


