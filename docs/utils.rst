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
The tests
