#### Chapter 4 - Exercise 34

* Description

Consider a sequence S of n integers with many duplications, such that the
number of distinct integers in S is O(log n). Give an O(n log log n) worst-case
time algorithm to sort such sequences.

* Solution

Use a heap to sort S and keep track of occurrence count. This is similar to the exercise 4.22 where k is log n.