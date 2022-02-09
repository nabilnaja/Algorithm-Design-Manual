#### Chapter 4 - Exercise 24

* Description

Give an efficient algorithm to rearrange an array of n keys so that all
the negative keys precede all the non-negative keys. Your algorithm must be
in-place, meaning you cannot allocate another array to temporarily hold the
items. 

How fast is your algorithm?

* Solution

Use two pointers one on the first element and the other on the last element.  
Go through the array, increment the first pointer till we find the first positive number.
Now decrement the second pointer till we find a negative number, then swap both element pointed by the different pointers. 
Repeat this while the first pointer is smaller than the second one. 

The time complexity is 0(n) and space complexity is 0(1).