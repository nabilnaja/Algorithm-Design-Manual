#### Chapter 3 - Exercise 24
* Description

An array A is called k-unique if it does not contain a pair of duplicate
elements within k positions of each other, that is, there is no i and j such that
    A[i] = A[j] and |j − i| ≤ k. Design a worst-case O(n log k) algorithm to test if
A is k-unique.

* complexity analysis

Space complexity is O(n), space complexity is O(K) since we use a hashmap as cache.


