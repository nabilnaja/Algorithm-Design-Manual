#### Chapter 4 - Exercise 41

* Description

A company database consists of 10,000 sorted names, 40% of whom are
known as good customers and who together account for 60% of the accesses to
the database. There are two data structure options to consider for representing
the database:
• Put all the names in a single array and use binary search.
• Put the good customers in one array and the rest of them in a second
array. Only if we do not find the query name on a binary search of the
first array do we do a binary search of the second array.
Demonstrate which option gives better expected performance. Does this change
if linear search on an unsorted array is used instead of binary search for both
options?

* Solution
