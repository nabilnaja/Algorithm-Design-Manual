#### Chapter 4 - Exercise 11
* Description

Design an O(n) algorithm that, given a list of n elements, finds all the
elements that appear more than n/2 times in the list. Then, design an O(n)
algorithm that, given a list of n elements, finds all the elements that appear
more than n/4 times.

* Solution

Use a hashmap tou keep count of the number of occurrence of each element. 

Go through the hashmap and retrieve all the element that have a more that 1/2 or 1/4 occurrence.

The time complexity is O(n)