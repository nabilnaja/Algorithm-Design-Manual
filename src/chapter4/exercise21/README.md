#### Chapter 4 - Exercise 21
* Description

Use the partitioning idea of quicksort to give an algorithm that finds the
median element of an array of n integers in expected O(n) time. (Hint: must
you look at both sides of the partition?)

* Solution

To solve this problem we should follow this steps: 

Randomly select a pivot, and then rearrange all the element in two partitions, 
all the element smaller than the pivot should go to the left partition and the bigger one to the right partition. 
If the position of the pivot is the middle of the array, the pivot is the median.
If the position of the pivot is after the middle, then repeat the precedent steps using the left partition.
If the position of the pivot is before the middle, then repeat the precedent steps using the right partition.

The expected time complexity is O(n) ( n + n/2 + n/4 ....)
The worst case complexity is O(n^2)
