#### Chapter 4 - Exercise 2
* Description

For each of the following problems, give an algorithm that finds the desired
numbers within the given amount of time. To keep your answers brief,
feel free to use algorithms from the book as subroutines. For the example,
S = {6, 13, 19, 3, 8}, 19 − 3 maximizes the difference, while 8 − 6 minimizes the
difference.

(a) Let S be an unsorted array of n integers. Give an algorithm that finds the
pair x, y ∈ S that maximizes |x−y|. Your algorithm must run in O(n) worst-case
time.

Solution : Go through the array and find the min and the max of it. this solution will run in O(n) 

(b) Let S be a sorted array of n integers. Give an algorithm that finds the pair
x, y ∈ S that maximizes |x − y|. Your algorithm must run in O(1) worst-case
time.

Solution : Since the array is sorted, the min is the first element ans the max is the last element.
We can find them using their indexes, 0 for the minimum and n-1 for the maximum. The time complexity is O(1).

(c) Let S be an unsorted array of n integers. Give an algorithm that finds the
pair x, y ∈ S that minimizes |x − y|, for x = y. Your algorithm must run in
O(n log n) worst-case time.

Solution : Sort the array first and go through it then find the closest pair (the pair with minimum distance).

(d) Let S be a sorted array of n integers. Give an algorithm that finds the pair
x, y ∈ S that minimizes |x − y|, for x = y. Your algorithm must run in O(n)
worst-case time.

Solution : Since the array is sorted, we only have to go through it and find the closest pair.
