Scores
======

Explanation of the scores here ...

Star
----
Star is a method to score a MSA. It was proposed by Gusfield in 1997.
This method makes use of a substitution matrix.
Star considers the most repeated symbol.

The process is:
- To find the scores of all pairs making a substitution matrix S.
- To find the "center" Sc, so that:

.. figure:: /resources/image/Captura1.PNG
.. figure:: /resources/image/Captura2.PNG

Sum of pairs
------------
Sum of pairs is a method of evaluating the quality of multiple sequence alignment.
This method assigns a specific score to the set of possible pair combinations using a substitution matrix. Its operation consists of, given a sequence alignment, selecting by column the possible pair combinations and identifying the sum of the values provided by the substitution matrix, which gives us a final sum made up of the sums of each column.

That is: given an alignment A composed of 4 sequences such that:

S1: ATGCTA

S2: CT-CAA

S3: AT-CTA

S4: -TGATA

Our method sequentially selects each column and for each column it will select all possible nucleotide pair combinations for that column. Each possible pair will be translated into a numerical value given by the substitution matrix, these values will be added together to finally obtain a final value.
The higher the final value, the better the alignment.

Percentage of non-gaps
----------------------

Percentage of totally conserved columns
---------------------------------------

Entropy
-------

