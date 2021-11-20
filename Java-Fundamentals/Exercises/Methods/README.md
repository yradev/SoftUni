Conditions:


1.	Smallest of Three Numbers
Write a method to print the smallest of three integer numbers. Use appropriate name for the method.

2.	Vowels Count
Write a method that receives a single string and prints the count of the vowels. Use appropriate name for the method.

3.	Characters in Range
Write a method that receives two characters and prints on a single line all the characters in between them according to ASCII.

4.	Password Validator
Write a program that checks if a given password is valid. Password rules are:
•	6 – 10 characters (inclusive);
•	Consists only of letters and digits;
•	Have at least 2 digits.
If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule print a message:
•	"Password must be between 6 and 10 characters";
•	"Password must consist only of letters and digits";
•	"Password must have at least 2 digits".

5.	Add and Subtract
You will receive 3 integers. Write a method sum to get the sum of the first two integers and subtract method that subtracts the third integer from the result from the sum method. 

6.	Middle Characters
You will receive a single string. Write a method that prints the middle character. If the length of the string is even, there are two middle characters.

7.	NxN Matrix
Write a method that receives a single integer n and prints nxn matrix with that number.

8.	Factorial Division
Read two integer numbers. Calculate factorial of each number. Divide the first result by the second and print the division formatted to the second decimal point.

9.	Palindrome Integers
A palindrome is a number which reads the same backward as forward, such as 323 or 1001. Write a program which reads a positive integer numbers until you receive "END". For each number print whether the number is palindrome or not.

10.	Top Number
Read an integer n from the console. Find all top numbers in the range [1 … n] and print them. A top number holds the following properties:
•	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
•	Holds at least one odd digit, e.g. 232, 707, 87578.

11.Array Manipulator
Trifon has finally become a junior developer and has received his first task. It's about manipulating an array of integers. He is not quite happy about it, since he hates manipulating arrays. They are going to pay him a lot of money, though, and he is willing to give somebody half of it if to help him do his job. You, on the other hand, love arrays (and money) so you decide to try your luck.
The array may be manipulated by one of the following commands:
•	exchange {index} – splits the array after the given index and exchanges the places of the two resulting subarrays. E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
o	If the index is outside the boundaries of the array, print "Invalid index".
•	max even/odd– returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
•	min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
o	If there are two or more equal min/max elements, return the index of the rightmost one.
o	If a min/max even/odd element cannot be found, print "No matches".
•	first {count} even/odd– returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
•	last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
o	If the count is greater than the array length, print "Invalid count".
o	If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements, print an empty array "[]".
•	end – stop taking input and print the final state of the array.
Input
•	The input data should be read from the console.
•	On the first line, the initial array is received as a line of integers, separated by a single space.
•	On the next lines, until the command "end" is received, you will receive the array manipulation commands.
•	The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
•	The output should be printed on the console.
•	On a separate line, print the output of the corresponding command
•	On the last line, print the final array in square brackets with its elements separated by a comma and a space 
•	See the examples below to get a better understanding of your task
Constraints
•	The number of input lines will be in the range [2 … 50].
•	The array elements will be integers in the range [0 … 1000].
•	The number of elements will be in the range [1 ... 50]
•	The split index will be an integer in the range [-231 … 231 – 1]
•	first/last count will be an integer in the range [1 … 231 – 1]
•	There will not be redundant whitespace anywhere in the input
•	Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.
