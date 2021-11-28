#### Chapter 3 - Exercise 21
* Description

A concatenate operation takes two sets S1 and S2, where every key in S1 is
smaller than any key in S2, and merges them. Give an algorithm to concatenate
two binary search trees into one binary search tree. The worst-case running
time should be O(h), where h is the maximal height of the two trees.

* complexity analysis

As required, the time complexity is O(h) where h is the max height of the first and second tree, 
the space complexity is O(h) since we use recursion and h is the max height of the first and second tree.