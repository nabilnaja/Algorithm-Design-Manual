#### Chapter 4 - Exercise 17
* Description

Devise an algorithm for finding the k smallest elements of an unsorted set
of n integers in O(n + k log n).

* Solution

We construct a min heap using the set, this step take O(n), then we remove the minimum 7 times and each time we heapify
, the time complexity for this step is O(k log n).

the total time complexity is  O(n + k log n).

