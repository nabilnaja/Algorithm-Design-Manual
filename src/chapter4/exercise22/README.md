#### Chapter 4 - Exercise 22
* Description

* The median of a set of n values is the [n/2] smallest value.

(a) Suppose quicksort always pivoted on the median of the current sub-array.
How many comparisons would quicksort make then in the worst case?

(b) Suppose quicksort always pivoted on the [n/3] smallest value of the
current sub-array. How many comparisons would be made then in the worst case?

* Solution

(a) : The complexity would be O(n log n), selecting the median as pivot each time and having 2 equal partitions each time would be the best case scenario. 

(b) : This would take O(n log3/2 n) comparisons.