#### Chapter 4 - Exercise 33

* Description

Show that n positive integers in the range 1 to k can be sorted in O(n log k)
time. The interesting case is when k << n.

* Solution

Using a self-balancing tree allow us to do it in O (n log k). 
The tree size would be fixed and the tree can only contain k element. 
The insertion time complexity is O( log k) and we do it for the n elements. 
The overall complexity is O(n log k). 

We should keep track of the occurrence count.


