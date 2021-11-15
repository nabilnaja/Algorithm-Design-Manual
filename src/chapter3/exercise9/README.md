#### Chapter 3 - Exercise 9
* Description

Write a function which, given a sequence of digits 2–9 and a dictionary of n
words, reports all words described by this sequence when typed in on a standard
telephone keypad. For the sequence 269 you should return any, box, boy, and
cow, among other words.

* complexity analysis

The time complexity is O(n) where n is the number of words. Space complexity is O(n) because we 
storing the list of words in a dictionary. 

The key to the word is the sequence of number we would have to select to type the word in an old phone. 

Since multiple word could have the same key, we use an Arraylist as value. 

For better performance we can use a cache system that contain word that we already transformed to digits.  
    





