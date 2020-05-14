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
    private Double gapPenalty;
    private HashMap<List, Integer> subsMat;


    public PAM250() {
        this.gapPenalty = -8D;
        this.subsMat = readFromFile();
    }

    public PAM250(Double gp) {
        this.gapPenalty = gp;
        this.subsMat = readFromFile();
    }

    public double getDistance(char char1, char char2) {
        List<String> par = new ArrayList<String>();
        par.add(Character.toString(char1));
        par.add(Character.toString(char2));
        double distance = 1;

        if (char1 == this.getGapCharacter() & char2 == this.getGapCharacter()) {
        } else if (char1 == this.getGapCharacter() || char2 == this.getGapCharacter()) {
            distance = this.getGapPenalty();
        } else if (!subsMat.containsKey(par)) {
            Collections.reverse(par);
            distance = Double.valueOf(subsMat.get(par));
        } else {
            distance = Double.valueOf(subsMat.get(par));
        }
        return distance;
    }

    public char getGapCharacter() {
        return '-';
    }

    public double getGapPenalty() {
        return gapPenalty;
    }

    private HashMap<List, Integer> readFromFile() {
        HashMap<List, Integer> subsMatrix = new HashMap<List, Integer>();
        BufferedReader fileReader = null;
        String line;
        List<String> guide = null;
        List<String> key1;
        List<String> key2;
        Integer value;

        try {
            fileReader = new BufferedReader(new FileReader(String.valueOf(Paths.get("resources/data/PAM250"))));
            while ((line = fileReader.readLine()) != null) {
                if (!line.startsWith("#") & !line.startsWith("*")) {
                    List<String> lineMatrix = Arrays.asList(line.trim().split("\\s+"));
                    if (line.startsWith(" ")) {
                        guide = lineMatrix;
                    } else {
                        for (int i = 0; i < guide.size() - 2; i++) {
                            key1 = new ArrayList<>();
                            key1.add(lineMatrix.get(0));
                            key1.add(guide.get(i));
                            key2 = new ArrayList<>();
                            key2.add(guide.get(i));
                            key2.add(lineMatrix.get(0));

                            if (!subsMatrix.containsKey(key1) & !subsMatrix.containsKey(key2)) {
                                value = Integer.parseInt(lineMatrix.get(i + 1));
                                subsMatrix.put(key1, value);
                            }
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
        return subsMatrix;
    }

    /*
    public static void main(String[] args) {
        PAM250 p250 = new PAM250();
        p250.readFromFile();
    }
    */
}



