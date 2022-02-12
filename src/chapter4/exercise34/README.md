#### Chapter 4 - Exercise 34

* Description

Consider a sequence S of n integers with many duplications, such that the
number of distinct integers in S is O(log n). Give an O(n log log n) worst-case
time algorithm to sort such sequences.

* Solution

We can use a self-balancing tree like AVL tree.

The tree won't contain duplicates, but for each duplicate we will keep track of the occurence count. 
The size of the tree would be log n, and insertion time complexity would be O (log log n).  
We have n insertion, so the overral complexity is O( n log log n)