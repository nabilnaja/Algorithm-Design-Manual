#### Chapter 4 - Exercise 35

* Description

Let A[1..n] be an array such that the first n− √n elements are already sorted
(though we know nothing about the remaining elements). Give an algorithm
that sorts A in substantially better than n log n steps.

* Solution

We can sort the second part of the array and then merge both parts. 

Sorting the second part is O( k log k) where k = √n -> O (√n log √n)
The merging time complexity is O ( n ). 
The overall complexity is O (n) + O (√n log √n), since  O(n) dominate O (√n log √n) the total runtime is O(N)