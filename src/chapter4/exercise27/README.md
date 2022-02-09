#### Chapter 4 - Exercise 27

* Description

Suppose you are given a permutation p of the integers 1 to n, and seek
to sort them to be in increasing order [1, . . . , n]. The only operation at your
disposal is reverse(p,i,j), which reverses the elements of a subsequence pi, . . . , pj
in the permutation. For the permutation [1, 4, 3, 2, 5] one reversal (of the second
through fourth elements) suffices to sort.

• Show that it is possible to sort any permutation using O(n) reversals.
• Now suppose that the cost of reverse(p,i,j) is equal to its length, the number
of elements in the range, |j − i| + 1. Design an algorithm that sorts p
in O(n log2 n) cost. Analyze the running time and cost of your algorithm
and prove correctness.

* Solution
