#### Chapter 4 - Exercise 14
* Description

Given a list I of n intervals, specified as (xi, yi) pairs, return a list where
the overlapping intervals are merged. For I = {(1, 3), (2, 6), (8, 10), (7, 18)} the
output should be {(1, 6), (7, 18)}. Your algorithm should run in worst-case
O(n log n) time complexity.

* Solution

We sort the interval list using xi. 

Use a stack and push the first interval into the stack. now go through the remaining intervals ,
For each interval, compare it's start time with the end time of the last pushed element in the stack,
if they overlap, merge both intervals, if not push the current interval in the stack. 

The sorting take O (n log n) and the loop through the sorted array take O(n), so the time complexity is O( n log n).
