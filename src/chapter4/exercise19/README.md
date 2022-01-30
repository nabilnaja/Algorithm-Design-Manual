#### Chapter 4 - Exercise 19
* Description

You wish to store a set of n numbers in either a max-heap or a sorted array.
For each application below, state which data structure is better, or if it does not
matter. Explain your answers.

(a) Find the maximum element quickly.
(b) Delete an element quickly.
(c) Form the structure quickly.
(d) Find the minimum element quickly.

* Solution
  (a) Find the maximum element quickly.
        This operation take O(1) in both of them. 
  (b) Delete an element quickly.
        Deleting an element from the array take O(n), while it takes O(log n) when using a max-heap.
  (c) Form the structure quickly.
        Building a heap can be done in O(n) while sorting an aray take O(n log n).
  (d) Find the minimum element quickly.
        Finding the minimum on a sorted array take O(1), but doing it using a heap take O(n)