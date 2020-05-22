How to score an MSA
=======
An MSA is, as its name suggests, a multiple sequence alignment that consists of searching for common regions in three or more sequences(DNA, RNA and proteins) so the best column's alignment can be found. It can be noticed that a larger number of aligned columns, as well a shorter number of gaps, involves higher possibilities of scoring a multiple sequence alignment. Of this form, it is possible to try to score an MSA in an intuitive way.

However, there are several methods which are more reliable for our objective:

Assuming independence between the columns:
In this category we find different parameters that can be used to acquire a value. This value can be used in an algorithm to find the optimum alignment: Percentage of totally conserved columns(TC): This value reflects the number of columns whose amino acids(protein) or nucleotides(DNA or RNA) remain the same.
To get this value we have to use the following equation:

Percentage of non-gaps(NonGap): This percentage indicates how many elements of the sequence are not gaps.
We can use this equation to calculate the value:
Minimum Entropy(H(s)): The entropy value is a measure of how diverse are the residues in a column.
The next equation is used to calculate this value:

Using a substitution matrix:
In this method we use a determined matrix called substitution matrix. The numbers in every position of the matrix will be used to calculate a value. This value is used to classify the different sets of aligned sequences as more optimal or less optimal.
Sum of pairs: We use a sum of pair function to calculate the value. This is the sum of the alignment scores for each pair of sequences in the MSA.

Weighted sum of pairs: Similar to sum of pairs, however, in this case there will be weights multiplying each value of the matrix.
There are also other methods, like Star, which uses the most repeated symbol to calculate the values.

Using structural information:
There is an MSA construction strategy in proteins that is based on the structural information of templates to construct the best possible alignment. It evaluates the structural similarity of templates in terms of Root-Mean-Squared-Deviation(RMSD) by structural superimposition, and it maps all conformational motifs within a predefined RMSD cutoff of the templates into an alignment. While aligning distantly related template sequences with similar structures, this alignment results in a more accurate alignment as it reasonably keeps the conserved structural folds of templates at the same loci in the MSA.
