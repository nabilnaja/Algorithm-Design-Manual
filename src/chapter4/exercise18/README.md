#### Chapter 4 - Exercise 18
* Description

Give an O(n log k)-time algorithm that merges k sorted lists with a total
of n elements into one sorted list. (Hint: use a heap to speed up the obvious
O(kn)-time algorithm).

* Solution

We can use a min heap if size k.
The first step it the add to the heap the first element of each array.
Remove the root element, and then add to the heap the next element from the array of removed element.
We continue till there is no element in the heap.

Each element added to the heap must have information of the array it belongs to and the next element from that array.

The time complexity of this algorithm is O(n log k).