#### Chapter 3 - Exercise 10
* Description

Two strings X and Y are anagrams if the letters of X can be rearranged
to form Y . For example, silent/listen, and incest/insect are anagrams. Give an
efficient algorithm to determine whether strings X and Y are anagrams.

* complexity analysis

the time complexity is O(n) where n is the size of the word and space complexity is O(1) since the array we use have a fixed size. 


There is other ways to do it, we can sort the two words and see if their equals, the time complexity would O(n log n). 


