#### Chapter 4 - Exercise 33

* Description

Show that n positive integers in the range 1 to k can be sorted in O(n log k)
time. The interesting case is when k << n.

* Solution

We can use a heap to sort the integers, and keep track the occurrence count of each value.
