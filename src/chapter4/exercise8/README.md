#### Chapter 4 - Exercise 8 
* Description

Outline a reasonable method of solving each of the following problems. Give
the order of the worst-case complexity of your methods.
(a) You are given a pile of thousands of telephone bills and thousands of checks
sent in to pay the bills. Find out who did not pay.
(b) You are given a printed list containing the title, author, call number, and
publisher of all the books in a school library and another list of thirty
publishers. Find out how many of the books in the library were published
by each company.
(c) You are given all the book checkout cards used in the campus library during
the past year, each of which contains the name of the person who took out
the book. Determine how many distinct people checked out at least one
book.

* Solution

(a) Sort both piles by name, then go through checks if the bill correspond to the check remove both if 
the check doesn't correspond to the bill add the bill to the unpaid bill list. Continue till we get a corresponding bill.

Time complexity is O(n log n) + O(m log m) + O( m + n). n is the number of bills and m is the number of checks

(b) Use bucket sort (a bucket by company) and count number of element per bucket.
Time complexity is O(n + m). n is the number of books and m is the number of company's. O(n) is for the bucket sort, then O(m) to get the size of each bucket. 

(c) Sort all book checkout cards using the name and keep only one card per name. 

Time complexity is O(n log n) + O(n). O(n log n) for sorting the cars, then O(n) to go through the sorted cards, counting them and ignoring the duplicates. 

