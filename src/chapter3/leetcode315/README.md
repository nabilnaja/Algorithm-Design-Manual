#### Chapter 3 - LeetCode 89
* Description

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

* complexity analysis

The time complexity of this solution is O(n log n). Since we are using an AVL tree that has the auto balancing capacity 
insert is allways done in O(log n). 
Space complexity is O(N). 