package org.jmsa.substitutionmatrix.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import org.jmsa.substitutionmatrix.SubstitutionMatrix;
import java.util.*;

public class SubstitutionMatrixReader {


    public HashMap<List<Character>, Integer> readMatrixFromFile(String file, SubstitutionMatrixObject substitutionMatrix) {
        HashMap<List<Character>, Integer> NewSubstitutionMatrix = new HashMap<>();
        String line;
        List<String> guide = null;
        List<Character> key1;
        List<Character> key2;
        Double gapPenalty=substitutionMatrix.getInitialGapPenalty();
        int value;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(String.valueOf(Paths.get(file))))) {
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

                        if (!NewSubstitutionMatrix.containsKey(key1) && !NewSubstitutionMatrix.containsKey(key2)) {
                            //For determinate gapPenalty -> we check if gapPenalty value has been initialized
                            if ((key1.get(0).equals(substitutionMatrix.getGapCharacter()) ^ key1.get(1).equals(substitutionMatrix.getGapCharacter())) &&
                                    (substitutionMatrix.getInitialGapPenalty() != null)) {
                                //It changes gapPenalty value in matrix
                                value = substitutionMatrix.getInitialGapPenalty().intValue();
                            } else {
                                //It takes gapPenalty value from substitutionMatrix file (default gapPenalty)
                                value = Integer.parseInt(lineMatrix.get(i + 1));
                                if ((key1.get(0).equals(substitutionMatrix.getGapCharacter()) ^ key1.get(1).equals(substitutionMatrix.getGapCharacter()))){
                                    gapPenalty=Double.valueOf(value);
                                }
                            }

                            NewSubstitutionMatrix.put(key1, value);
                        }
                    }
                }
            }
            //Exception control
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("An IO error has occured: " + e.getMessage());
            System.exit(1);
        }
        substitutionMatrix.setGapPenalty(gapPenalty);
        return NewSubstitutionMatrix;
    }
}
/*
We have included this method beacause we took the time to implement it, but it's not functional because
otherwise, we would have had to include duplicate methods in the matrix classes (Because each reader returns
a different estructure)
    private Map<List<Character>, Double> readMatrixFromDictionary(file) {

        Map<List<Character>, Double> substitutionMatrix = new HashMap<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(Paths.get(file))))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                //We find two parts: key = pair aas, value = distance
                if (parts.length >= 2) {
                    //It saves pair aas
                    String[] lp = parts[0].split(",");
                    List<Character> key = List.of(lp[0].charAt(0), lp[1].charAt(0));
                    //It gets distance
                    String value = parts[1];
                    substitutionMatrix.put(key, Double.valueOf(value));
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
            //Exception control
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("An IO error has occured: " + e.getMessage());
            System.exit(1);
        }

        return substitutionMatrix;
    }
*/

