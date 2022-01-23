#### Chapter 4 - Exercise 5
* Description

The mode of a bag of numbers is the number that occurs most frequently in
the set. The set {4, 6, 2, 4, 3, 1} has a mode of 4. Give an efficient and correct
algorithm to compute the mode of a bag of n numbers.

* Solution

We can sort the Array, then go through it and count which value appears the most. The time complexity 
of this solution would be O(n log n). 
Another solution would be to use and Hashmap and while going through the array update the frequency of each item. 
The time complexity of the second solution is O(N).

