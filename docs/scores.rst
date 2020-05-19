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

Percentage of non-gaps
----------------------
Visual depictions of the alignment illustrate mutation events such as point mutations (single amino acid or nucleotide changes) that appear as differing characters in a single alignment column, and insertion or deletion mutations (indels or gaps) that appear as hyphens.
 
This part of the programme is going to calculate the number of non-gaps in an alignment sequence. This is super important since the objective of the MSA, among others,  is to optimize to the maximum the value of the non-gaps-percentage.
 
That is the reason why we are going to create the class ‘PercentageOfNonGaps’
 
This class implements Score class. It has a method called ‘compute’ which we pass a matrix as a parameter. A counter for non-gaps is initialized to zero This method has nested loop to loop through it.  If the element we read is different from a hyphens, we increase the counter.
Finally we divide this counter between the total length of the sequence. To obtain a percentage over 100, we multiply the result by 100. 
 

Percentage of totally conserved columns
---------------------------------------

Entropy
-------
- Definition:

Entropy of Shanon can be defined as grade of disorder that a random variable can generate. It is related to the uncertainty that exists in
an experiment, as the amount of "noise" that contains the system.


However, it is also related to  the physics' magnitude that allows us to measure the non-usable part of the energy
contained in a system of particles or data. That means that that part of the total can not be used to produce
physical work.


In our case, it is useful in order to measure how diverse are the residues in a column. This is vey important when scoring MSA because it
represents how much distance exist between the sequences. Entropy is important because it tells us that systems can't go back in their processes and how is the energy wasted in a closed environment.
Mathematically it's represented by the summation of residue's frequency times the logarithm of different residue's number, as it can be observed in
the following picture:

.. image:: entropy.jpg
- Implementation:

We have created a function called compute, which receives a sequence and creates a HashMap <String, Integer>
with the number of times a nucleotide appears. We have supposed that the sequence doesn't contains incorrect characters.
Once we have the frequencies of nucleotide, we can apply the formula of Shanon Entropy.
In addition, we have implemented a range of JUnit Tests in order to be secure that the code works correctly.



