Scores
======

Explanation of the scores here ...

Star
----

Sum of pairs
------------

Percentage of non-gaps
----------------------
Visual depictions of the alignment illustrate mutation events such as point mutations (single amino acid or nucleotide changes) that appear as differing characters in a single alignment column, and insertion or deletion mutations (indels or gaps) that appear as hyphens.
 
This part of the programme is going to calculate the number of non-gaps in an alignment sequence. This is super important since the objective of the MSA, among others,  is to optimize to the maximum the value of the non-gaps-percentage.
 
That is the reason why we are going to create the class `PercentageOfNonGaps`
 
This class implements Score class. It has a method called `compute()` which we pass a matrix as a parameter. A counter for non-gaps is initialized to zero This method has nested loop to loop through it.  If the element we read is different from a hyphens, we increase the counter.
Finally we divide this counter between the total length of the sequence. To obtain a percentage over 100, we multiply the result by 100. 
 

Percentage of totally conserved columns
---------------------------------------

Entropy
-------

