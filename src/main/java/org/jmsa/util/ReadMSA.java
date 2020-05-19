package org.jmsa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ReadMSA {
  static char[][] myArray;
  public static char[][] readSequenceFromFastaFile(String filepath) throws FileNotFoundException {
    List<List<Character>> seqList = new ArrayList<List<Character>>();
    int rowCnt=0;

    File file = new File(filepath);
    Scanner reader = new Scanner(file);


    boolean first = true;
    while(reader.hasNextLine()) {
      String line = reader.nextLine().trim();
      if (line.isBlank()==false) {
        if (line.charAt(0)=='>') {
          List<Character> myList = new ArrayList<Character>();
          seqList.add(myList);
          if(first) {
            first=false;
          }
          else {
            rowCnt++;
          }
        }
        else{
          char[] secuenceArray = line.toCharArray();
          for (char c : secuenceArray) {
            seqList.get(rowCnt).add(c);
          }
        }
      }else if(line.isBlank()){ //line.isBlank()==true;
        if(reader.hasNextLine()) {
          continue;
        }else {
          line=null;
        }
      }
    }

    reader.close();

    if(!seqAlignedCorrectly(seqList)) {
      throw new RuntimeException("The sequences in the input .fasta file are not aligned correctly");
    }

    myArray = new char[rowCnt+1][seqList.get(0).size()];
    for (int i=0; i <= rowCnt; i++) {
      for (int j=0; j<seqList.get(i).size(); j++) {
        myArray[i][j]=seqList.get(i).get(j);
      }
    }

    return myArray;
  }

  private static boolean seqAlignedCorrectly(List<List<Character>> theList) {
    boolean eq = true;
    int sizeRef = theList.get(0).size();
    for (List<Character> list : theList) {
      if(list.size()!=sizeRef) {
        eq = false;
      }
    }

    return eq;
  }
}