# Algorithm-Design-Manual
My solutions for Algorithm Design Manual 3nd Edition

#### Chapter 3
* Exercise 3

A common problem for compilers and text editors is determining whether the parentheses in a string are balanced and properly nested. For example, the string  contains properly nested pairs of parentheses, which the strings  and  do not. Give an algorithm that returns true if a string contains properly nested and balanced parentheses, and false if otherwise. For full credit, identify the position of the first offending parenthesis if the string is not properly nested and balanced.

    First solution use a stack, the time comlexity is O(n) and space complexity is O(n)

    Second solution use a int variable as a counter, the time comlexity is O(n) and space complexity is O(1)