#### Chapter 4 - Exercise 29

* Description

Suppose you are given k sorted arrays, each with n elements, and you want
to combine them into a single sorted array of kn elements. One approach is to
use the merge subroutine repeatedly, merging the first two arrays, then merging
the result with the third array, then with the fourth array, and so on until you
merge in the kth and final input array. What is the running time?

* Solution

1       : 2n
2       : 3n
3       : 4n
....
k       : kn

2n + 3n + 4n + ... + kn
= n(1 + 2 + 3 + 4 + ... + (k - 1))
= n((k - 1)*k) / 2
= n(k^2 - k) / 2
= O(nk ^ 2)

The running time is : O(nk ^ 2)


