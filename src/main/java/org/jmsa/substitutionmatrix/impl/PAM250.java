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
<<<<<<< HEAD
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
    double distance = 0;

    if (!subsMat.containsKey(par)){
      Collections.reverse(par);
    }
    distance = Double.valueOf(subsMat.get(par));
    return distance;
  }

  public char getGapCharacter() {
    return '-';
  }

  public double getGapPenalty() { return getDistance('A', '-'); }

  private HashMap<List<String>, Integer> readMatrixFromFile() {
    HashMap<List<String>, Integer> substitutionMatrix = new HashMap<List<String>, Integer>();
    String line;
    List<String> guide = null;
    List<String> key1;
    List<String> key2;
    int value;
    try (BufferedReader fileReader = new BufferedReader(new FileReader(String.valueOf(Paths.get("resources/data/PAM250"))))) {
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
              boolean k1=(guide.get(i).);
              if(key1.get(0).contains(Character.toString(getGapCharacter())) && gapPenalty != null){
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
    }
    // nothing
    return substitutionMatrix;
  }



    public static void main(String[] args) throws IOException {
        PAM250 p250 = new PAM250(-10D);
        System.out.println(p250.readMatrixFromFile());
        System.out.println(p250.getDistance('M', 'A'));
        System.out.println(p250.getDistance('M', 'A'));
        System.out.println(p250.getDistance('M', 'A'));
    }



}
=======
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






>>>>>>> 9806e04be9655beb17354f858a50964723281416
