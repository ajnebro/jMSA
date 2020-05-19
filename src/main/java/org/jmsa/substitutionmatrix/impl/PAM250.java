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
    private final HashMap<List<Character>, Integer> subsMatrix;

    //Constructor that takes default gapPenalty value
    //This value is taken from substitutionMatrix file (method readMatrixFromFile)
    public PAM250() {
        this.subsMatrix = readMatrixFromFile();
    }

    //Constructor that changes gapPenalty value
    public PAM250(Double gp) {
        this.gapPenalty = gp;
        this.subsMatrix = readMatrixFromFile();
    }

    //This method takes the distance from substitutionMatrix (HashMap created in readMatrixFromFile)
    public double getDistance(char char1, char char2) {
        List<Character> pair = new ArrayList<>();
        pair.add(char1);
        pair.add(char2);
        double distance;

        if (!subsMatrix.containsKey(pair)) {
            Collections.reverse(pair);
        }
        distance = Double.valueOf(subsMatrix.get(pair));
        return distance;
    }

    //Default gapCharacter
    public char getGapCharacter() {
        return '-';
    }

    //GapPenalty value obtained from substitutionMatrix
    public double getGapPenalty() {
        return getDistance('A', '-');
    }


    private HashMap<List<Character>, Integer> readMatrixFromFile() {
        HashMap<List<Character>, Integer> substitutionMatrix = new HashMap<>();
        String line;
        List<String> guide = null;
        List<Character> key1;
        List<Character> key2;
        int value;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(String.valueOf(Paths.get("resources/data/PAM250"))))) {
            while ((line = fileReader.readLine()) != null) {
                //The first nine lines start by # -> they don't contain substitutionMatrix distances
                if (!line.startsWith("#")) {
                    List<String> lineMatrix = Arrays.asList(line.trim().split("\\s+"));
                    if (line.startsWith(" ")) {
                        //The first line, with amino acids values -> this is the guide to compare with aas in rest of lines
                        guide = lineMatrix;
                    } else for (int i = 0; i < Objects.requireNonNull(guide).size(); i++) {
                        //Two keys to get the aas in both ways
                        key1 = new ArrayList<>();
                        key2 = new ArrayList<>();

                        key1.add(lineMatrix.get(0).charAt(0));
                        key1.add(guide.get(i).charAt(0));

                        key2.add(guide.get(i).charAt(0));
                        key2.add(lineMatrix.get(0).charAt(0));

                        if (!substitutionMatrix.containsKey(key1) && !substitutionMatrix.containsKey(key2)) {
                            //For determinate gapPenalty -> we check if gapPenalty value has been initialized
                            if ((key1.get(0).equals(getGapCharacter()) ^ key1.get(1).equals(getGapCharacter())) && gapPenalty != null) {
                                //It changes gapPenalty value in matrix
                                value = gapPenalty.intValue();
                            } else {
                                //It takes gapPenalty value from substitutionMatrix file (default gapPenalty)
                                value = Integer.parseInt(lineMatrix.get(i + 1));
                            }

                            substitutionMatrix.put(key1, value);
                        }
                    }
                }
            }
            //Exception control
        } catch (FileNotFoundException e) {
            System.out.println("File: PAM250 is not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("An IO error has occured: " + e.getMessage());
            System.exit(1);
        }

        return substitutionMatrix;
    }

}






