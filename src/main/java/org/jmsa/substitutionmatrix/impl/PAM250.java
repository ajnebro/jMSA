package org.jmsa.substitutionmatrix.impl;

import org.jmsa.substitutionmatrix.SubstitutionMatrix;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * Hello world!
 */
public class PAM250 implements SubstitutionMatrix {
    private Double gapPenalty = null;
    private final HashMap<List<String>, Integer> subsMat;

    public PAM250() {
        this.subsMat = readMatrixFromFile();
    }

    public PAM250(Double gp) {
        this.gapPenalty = gp;
        this.subsMat = readMatrixFromFile();
    }

    public double getDistance(char char1, char char2) {
        List<String> par = new ArrayList<String>();
        par.add(Character.toString(char1));
        par.add(Character.toString(char2));
        double distance;

        if (!subsMat.containsKey(par)) {
            Collections.reverse(par);
        }
        distance = Double.valueOf(subsMat.get(par));
        return distance;
    }

    public char getGapCharacter() {
        return '-';
    }

    public double getGapPenalty() {
        return getDistance('A', '-');
    }

    private HashMap<List<String>, Integer> readMatrixFromFile() {
        HashMap<List<String>, Integer> substitutionMatrix = new HashMap<List<String>, Integer>();
        String line;
        List<String> guide = null;
        List<String> key1;
        List<String> key2;
        int value;
        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(String.valueOf(Paths.get("resources/data/PAM250"))));
            while ((line = fileReader.readLine()) != null) {
                if (!line.startsWith("#")) {
                    List<String> lineMatrix = Arrays.asList(line.trim().split("\\s+"));
                    if (line.startsWith(" ")) {
                        guide = lineMatrix;
                    } else for (int i = 0; i < Objects.requireNonNull(guide).size(); i++) {
                        key1 = new ArrayList<>();
                        key2 = new ArrayList<>();
                        key1.add(lineMatrix.get(0));
                        key1.add(guide.get(i));

                        key2.add(guide.get(i));
                        key2.add(lineMatrix.get(0));

                        if (!substitutionMatrix.containsKey(key1) && !substitutionMatrix.containsKey(key2)) {

                            if ((key1.get(0).equals(Character.toString(getGapCharacter())) ^ key1.get(1).equals(Character.toString(getGapCharacter())))
                                    && gapPenalty != null) {
                                value = gapPenalty.intValue();

                            } else {
                                value = Integer.parseInt(lineMatrix.get(i + 1));
                            }
                            substitutionMatrix.put(key1, value);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File: PAM250 is not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("An IO error has occured: " + e.getMessage());
            System.exit(1);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    // nothing
                }
            }
        }
        return substitutionMatrix;
    }
}






