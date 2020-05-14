Scores
======

Explanation of the scores here ...

Star
----
The Star method is one of the algorithms used to score multi-sequence alignment.
It was proposed by Gusfield in 1997 and consists of finding the sequence best aligned
to the others (center) by scoring in pairs. This method makes use of a substitution matrix.

The following process is performed:

- Find the scores of all the pairings by forming an score matrix S.

.. figure:: /resources/image/Captura3.PNG

- Find the Sc center such that:

.. figure:: /resources/image/Captura5.PNG

- Align Sc with the other sequences respecting the principle of consistency.

.. figure:: /resources/image/Captura1.PNG

IMPLEMENTATION

We have created a function called "compute", in which we go through each of the sequences
of the two-dimensional matrix called "sequence". First, we have to select
the most repeated amino acid of all the sequences in each column, so we're going
build a map in which we will store the amino acid along with its frequency of occurrence.
For every amino acid in the column we're working with, we check if it's
included on the map. If it is not, we include it as a key and put its value to 1.
If it is included, we add one to the frequency, delete the previous relationship
and introduce the amino acid with its new frequency.
Once all the frequencies have been calculated, we must select the highest one.
We use a for loop in which we compare the frequency saved for each
amino acid with a counter that we've initialized to 0. Every time the
frequency is higher than the one stored in the counter, we update the counter
with that new frequency and we store the amino acid that has that frequency.
Finally, we calculate the distances of each amino acid in the column from the
amino acid with the highest value.
So the star shape emerges, with the most repeated amino acid in the center
and the rest around.

Sum of pairs
------------

Percentage of non-gaps
----------------------

Percentage of totally conserved columns
---------------------------------------

Entropy
-------

