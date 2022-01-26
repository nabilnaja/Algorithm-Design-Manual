#### Chapter 4 - Exercise 9
* Description

Given a set S of n integers and an integer T, give an O(n^(k−1) log n) algorithm
to test whether k of the integers in S add up to T.

* Solution

First we sort the array. O( n log n )
Then we construct k-1 permutation and for each permutation search the array using binary search to find 
which element that complete the sum. The permutations take O(n^(k−1)) for each permutation we do a binary search which is done in O(n^(k−1) log n)