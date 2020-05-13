Scores
======

Explanation of the scores here ...

Star
----

Sum of pairs
------------

Percentage of non-gaps
----------------------

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



