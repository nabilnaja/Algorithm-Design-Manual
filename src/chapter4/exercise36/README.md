#### Chapter 4 - Exercise 36

* Description

Assume that the array A[1..n] only has numbers from {1, . . . , n2} but that
at most log log n of these numbers ever appear. Devise an algorithm that sorts
A in substantially less than O(n log n).

* Solution

We go through the array and keep a hashmap of each item with the occurrence count. This step time complexity is O(n) 
create an array with only distinct elements. the array size would be log log n at max. 
we sort the last array, the sort complexity would be O(x log x) where x is log log n. 
We finally can create a new array using the sorted array and the occurrence count from hashmap. This step time complexity is O(n)



