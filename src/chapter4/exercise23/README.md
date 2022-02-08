#### Chapter 4 - Exercise 23
* Description

Suppose an array A consists of n elements, each of which is red, white, or
blue. We seek to sort the elements so that all the reds come before all the whites,
which come before all the blues. The only operations permitted on the keys are:

• Examine(A,i) – report the color of the ith element of A.
• Swap(A,i,j) – swap the ith element of A with the jth element.

Find a correct and efficient algorithm for red–white–blue sorting. There is a linear-time solution.

* Solution

We can use the Dutch National Flag Algorithm to solve this probleme. 

The time complexity is O(n) and space complexity is O(1).