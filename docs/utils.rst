Utils
=====

Class ReadMSA provides methods to read one or multiple sequences from a .fasta file.
The main method is readSequenceFromFastaFile(), which takes a path to the .fasta file
as a parameter and returns an array of arrays of chars, containing the sequences
from the file (one array for each sequence), and its adjacent method seqAlignedCorrectly(),
which is used to determine whether or not the sequences in the file are aligned
correctly (in this case, if all sequences in the file are of equal length (including
gaps as chars), they will be considered correctly aligned).

+-----------------------------------------------------------------------------+
|  Method Summary                                                             |
+========================+====================================================+
| **Modifier and Type**  | **Method and Description**                         |
+------------------------+----------------------------------------------------+
| public static char[][] | readSequenceFromFastaFile(String filepath)         |
|                        |                                                    |
|                        | Returns sequences from the file specified by       |
|                        | *filepath* one array per sequence                  |
+------------------------+----------------------------------------------------+
| private static boolean | seqAlignedCorrectly(List<List<Character>> theList) |
|                        |                                                    |
|                        | Returns **true** if all List<Character> in         |
|                        | *theList* are of the same size                     |
+------------------------+----------------------------------------------------+

Class ReadMSATest contains methods for unit testing of the code in class ReadMSA.
The tests were written to cover 100% of the code in ReadMSA.
Following is the Method Summary for the class.

+-----------------------------------------------------------------------------+
|  Method Summary                                                             |
+========================+====================================================+
| **Modifier and Type**  | **Method and Description**                         |
+------------------------+----------------------------------------------------+
| @BeforeEach            | init()                                             |
|                        |                                                    |
| public void            | Initializes *seqReader* (the instance of ReadMSA)  |
|                        | before each Test                                   |
+------------------------+----------------------------------------------------+
| @Test                  | correctSequenceHandlingTest()                      |
|                        |                                                    |
| public void            | Unit testing for correctly aligned sequences.      |
|                        | Fails if the length of returned array does not fit |
|                        | the number of sequences in the input file, or if   |
|                        | any of the sequences has been read wrong           |
+------------------------+----------------------------------------------------+
| @Test                  | correctHandlingOfBlankLinesTest()                  |
|                        |                                                    |
| public void            | Unit testing for files that have blank lines (if   |
|                        | not handled correctly, blank lines will cause the  |
|                        | program to throw exception)                        |
+------------------------+----------------------------------------------------+
| @Test                  | invalidFilePathTest()                              |
|                        |                                                    |
| public void            | Unit testing for invalid filepaths. Fails if no    |
|                        | FileNotFoundException is raised in case of passing |
|                        | an invalid filepath as a parameter                 |
+------------------------+----------------------------------------------------+
| @Test                  | incorrectSequenceTest()                            |
|                        |                                                    |
| public void            | Unit testing for incorrectly aligned sequences.    |
|                        | The test fails if a file with incorrectly aligned  |
|                        | (not equal in size) sequences is passed as a       |
|                        | parameter in method call, and no RuntimeException  |
|                        | is thrown                                          |
+------------------------+----------------------------------------------------+
| @AterEach              | fin()                                              |
|                        |                                                    |
| public void            | Sets *seqReader* to null after each test           |
+------------------------+----------------------------------------------------+