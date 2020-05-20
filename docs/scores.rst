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

The percentage of conserved columns is very important because it has many aplications in studies of phylogenetics and taxonomy, in medical researches and in functional annotation.
  - Phylogenetics and taxonomy: the sets of conserved columns can be used to create an evolution tree to study the species and their ancestors.
  - In medical researches the applications of the MSA and specifically the amount of conserved columns it's used to identifi genetics diseases, in the compatibility between species so we can study the pathology on lab organisms instead of humans...
  - Identifying the conserved columns can be very helpful to predict functional sequences such as genes, besides, if the secuences have a known function, they can also be used to predict the function of those proteins; in order to create databases.
 
Our class measures the amount of conserved columns by implementing the class score, and finding the sequences who are conserved and then returning the percentege ot total conserved columns of the array. In order to do so, the programme recieves a bisequential file of type char and also we have a counter for the conserved columns and a variable for the length of the sequence. Using a 'for' loop we withdraw the columns and inside this lool there is another 'for' loop to wothdraw the rows, in this second loop we compare the actual letter to the next one and if they are the same, we increase the sequence refered to conserved columns. When the first loop ends (the rows are fully withdrawed) the sequence increases to the next column and we repear the process until the whole file is completed..  
 

Entropy
-------

