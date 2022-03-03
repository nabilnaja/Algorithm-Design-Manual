#### Chapter 5 - Exercise 10
* Description

We are given n wooden sticks, each of integer length, where the ith piece
has length L[i]. We seek to cut them so that we end up with k pieces of exactly
the same length, in addition to other fragments. Furthermore, we want these k
pieces to be as large as possible.
(a) Given four wood sticks, of lengths L = {10, 6, 5, 3}, what are the largest
sized pieces you can get for k = 4? (Hint: the answer is not 3).
(b) Give a correct and efficient algorithm that, for a given L and k, returns the
maximum possible length of the k equal pieces cut from the initial n sticks.

* Solution

(a) the answer is 5 : 10 = 2 * 5 , 6 = 1 * 5 + 1, 5 = 1 * 5, 3 = 0 * 5 + 3

(b) we can use binary search to find the maximum possible length. 

The right element of our binary search would be the length of the longest stick and the left element would be 1. 

As long as the left is smaller or equal than the right we continue searching. 

we calculate the mid value : left + (high - low) / 2

then we calculate the number of the equal pieces cut from the initial n sticks

If this number is bigger or equal than k : we continue searching right ->  left = mid + 1

if not we continue searching left -> right = mid - 1;

* Complexity analysis

The time complexity is O(N log M). M is the length of the longest stick and n is the number of sticks.
The space complexity is O(1).

