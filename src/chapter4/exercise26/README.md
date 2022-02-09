#### Chapter 4 - Exercise 26

* Description

Define the recursion depth of quicksort as the maximum number of successive
recursive calls it makes before hitting the base case. What are the minimum
and maximum possible recursion depths for randomized quicksort?

How fast is your algorithm?

* Solution

The minimum recursion depths occurs whe we're luck and we pick the median everytime. In this case it's log n.
The maximum possible recursion depths occurs when we pick the max or min element of the list everytime. In this case it's n.