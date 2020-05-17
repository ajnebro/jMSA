Scores
======

Explanation of the scores here ...

Star
----
The Star method is one of the algorithms used to score multi-sequence alignment.
It was proposed by Gusfield in 1997 and consists of finding the best aligned sequence
with the others (center) by scoring in pairs. This method makes use of a substitution matrix.

The following process is carried out:

- Search for the most recurring symbol (nucleotide or aminoacid) in each column of the sequence set.

- Calculate the distances from the remaining symbols to the most repeated from a substitution matrix.

.. figure:: /resources/image/Captura2.PNG

That way, the form of a Star emerges:

.. figure:: /resources/image/Captura4.PNG

IMPLEMENTATION

We have created a function called `aaMoreRepeated`, in which we select the most repeated symbol
of all the sequences in each column, so we're going build a map in which we will store the symbol
along with its frequency of occurrence.

For every character in the column we're working with, we check if it's
included on the map. If it is not, we include it as a key and put its value to 1.
If it is included, we add one to the frequency, delete the previous relationship
and introduce the amino acid with its new frequency.


.. code-block:: java

    public Character aaMoreRepeated(char[][] parameterSequence, int parameterPosAAinSequence){

        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();

        for (int numberOfSequence = 0; numberOfSequence < parameterSequence.length; numberOfSequence++) {
          Character aa = parameterSequence[numberOfSequence][parameterPosAAinSequence];
          if (charFreq.containsKey(parameterSequence[numberOfSequence][parameterPosAAinSequence])) {
            Integer newFreq = (Integer) charFreq.get(aa) + 1;
            charFreq.remove(aa);
            charFreq.put(aa, newFreq);
          } else {
            charFreq.put(aa, 1);
          }
        }

Once all the frequencies have been calculated, we must select the highest one.
We use a for loop in which we compare the frequency saved for each character
with a counter that we've initialized to 0. Every time the frequency is higher
than the one stored in the counter, we update the counter with that new frequency
and we store the amino acid that has that frequency.


.. code-block:: java

        int moreRepeatedFreq = 0;
        Character moreRepeatedAA = parameterSequence[0][parameterPosAAinSequence];

        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
          if (entry.getValue() > moreRepeatedFreq) {
            moreRepeatedAA = entry.getKey();
            moreRepeatedFreq = entry.getValue();
          }
        }
        return moreRepeatedAA;

Finally, we calculate the distances of each symbol in the column from the
symbol with the highest value in that column. We do this within the function
called `compute`. This function is introduced by the set of sequences.
We go through each of the columns, and for each one we call the function 'moreRepeatedAA',
which will give us the most repeated character.

Once we have it, we calculate the distance of that symbol with the rest
of the symbols of the column.


.. code-block:: java

    public double compute(char[][] sequence) {
        double result = 0;

        for (int posAAinSequence = 0; posAAinSequence < sequence[0].length; posAAinSequence++) {

          Character moreRepeatedAA = aaMoreRepeated(sequence, posAAinSequence);

          // 2. We compute the punctuation for this column
          for (char[] chars : sequence) {
            double distance = scoreMatrix.getDistance(moreRepeatedAA, chars[posAAinSequence]);

            // 3. We add the distance to the total result we have to return
            result = result + distance;
          }
        }
        return (result);
      }

Sum of pairs
------------

Percentage of non-gaps
----------------------

Percentage of totally conserved columns
---------------------------------------

Entropy
-------

