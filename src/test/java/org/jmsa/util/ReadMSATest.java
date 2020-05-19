package org.jmsa.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for class ReadMSA
 */
class ReadMSATest {
  ReadMSA seqReader;

  @BeforeEach
  public void init(){
    seqReader = new ReadMSA();
  }

  @Test
  public void correctSequenceHandlingTest() throws FileNotFoundException {
    char[][] seqArray = seqReader.readSequenceFromFastaFile("./resources/data/correctSequence.fasta");

    //Asserting that the number of arrays equals the number of
    //sequences in the input file
    int expectedLength = 4;
    int actualLength = seqArray.length;
    assertEquals(expectedLength,actualLength);

    //Asserting that the first sequence was read correctly
    char expectedChar1stSequence10thElement = 'G';
    char actualChar1stSequence10thElement = seqArray[0][9];
    assertEquals(expectedChar1stSequence10thElement,actualChar1stSequence10thElement);

    //Asserting that the second, third and fourth sequences were read correctly
    char expectedChar2ndSequence23rdElement = 'K';
    char actualChar2ndSequence23rdElement = seqArray[1][22];
    assertEquals(expectedChar2ndSequence23rdElement,actualChar2ndSequence23rdElement);

    char expectedChar3rdSequence17thElement = 'P';
    char actualChar3rdSequence17thElement = seqArray[2][16];
    assertEquals(expectedChar3rdSequence17thElement,actualChar3rdSequence17thElement);

    char expectedChar4thSequence8thElement = 'N';
    char actualChar4thSequence8thElement = seqArray[3][7];
    assertEquals(expectedChar4thSequence8thElement,actualChar4thSequence8thElement);
  }

  @Test
  public void correctHandlingOfBlankLinesTest() throws FileNotFoundException {
    char[][] seqArray = seqReader.readSequenceFromFastaFile("./resources/data/correctSeqWithBlanks.fasta");

    char expectedChar3rdSequence30thElement = 'A';
    char actualChar3rdSequence30thElement = seqArray[2][29];
    assertEquals(expectedChar3rdSequence30thElement,actualChar3rdSequence30thElement);
  }

  @Test
  public void invalidFilePathTest(){
    //Purposefully passing an invalid filepath in order to assure the correct exception is thrown
    assertThrows(FileNotFoundException.class,()->seqReader.readSequenceFromFastaFile("./resources/data/nonexistent.fasta"));
  }

  @Disabled
  @Test
  public void incorrectSequenceTest(){
    //Passing a valid filepath, with the file containing incorrectly aligned sequences
    assertThrows(RuntimeException.class,()->seqReader.readSequenceFromFastaFile("./resources/data/BB11001.tfa"));
  }

  @AfterEach
  public void fin(){
    seqReader=null;
  }
}