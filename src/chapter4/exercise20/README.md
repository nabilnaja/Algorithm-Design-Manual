#### Chapter 4 - Exercise 20
* Description

a) Give an efficient algorithm to find the second-largest key among n keys.
You can do better than 2n − 3 comparisons.

(b) Then, give an efficient algorithm to find the third-largest key among n keys.
How many key comparisons does your algorithm do in the worst case? Must your
algorithm determine which key is largest and second-largest in the process?

* Solution

We can use a heap with a limited size. The construction of the heap will still be done in O(n), but the heapify action will only take O(logk).
The overall complexity is O()
We must extract the max from the heap and heapify again till we get to the K-th element. 