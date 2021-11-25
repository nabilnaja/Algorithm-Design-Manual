#### Chapter 3 - Exercise 14
* Description

Given two binary search trees, merge them into a doubly linked list in sorted
order.

* complexity analysis

The solution comes in two parts, first we convert each BTS to a doubly linked list then we merge 
the doubly linked list.

Transforming the first BTS take O(n) time and the second BTS O(m), 
Then we merge the two doubly linked list, this step take O(n + m).

Time complexity is O(n + M), where n is the number of nodes of the first tree and m the number of nodes in the second one. 
Space complexity is O(x + y) where x is the height of the first tree and y the height of the secod one.
