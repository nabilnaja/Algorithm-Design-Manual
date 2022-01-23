#### Chapter 4 - Exercise 6
* Description

Given two sets S1 and S2 (each of size n), and a number x, describe an
O(n log n) algorithm for finding whether there exists a pair of elements, one
from S1 and one from S2, that add up to x. (For partial credit, give a Θ(n2)
algorithm for this problem.)

* Solution

First solution : Sort the first array, then go through the second array and for each value of
he second array, use binary search on the first array to find the complement number.

Time complexity of this solution is O(n log n). 
We first sort the first array O(n log n)
Then for each item in the second array with do a binary search to find the complement O(n log n)

Second solution : Sort both arrays. loop through the first array (index i), loop through the second array in reverse order (index j).

if the sum of array1[i] and array2[j] is equal to x then we return true.
if the sum of array1[i] and array2[j] is bigger than x then decrement j
if the sum of array1[i] and array2[j] is smaller than x then increment i

Time complexity of this solution is O(n log n).
We sort the first array O(n log n)
We sort the second array O(n log n)
Then we go through both arrays in the same time O(n)

Third solution : Use two hashmaps to store each visited values from each array. 
Every time check if the hashmap contains the complement of the visited item. 

Time complexity of this solution is O(n). since we go through both arrays at the same time and do it only once
