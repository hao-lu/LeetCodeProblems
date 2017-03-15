# [##216 Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)
---
## Problem
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

	Input: k = 3, n = 7

	Output:

	[[1,2,4]]

Example 2:

	Input: k = 3, n = 9

	Output:

	[[1,2,6], [1,3,5], [2,3,4]]

## Solution
In order to solve this problem optimal, I implemented a backtracking paradigm. Instead of continuing from the top of the tree for each possibility, backtracking allows branching at a point already calculated. The algorithm starts by adding the current value 1 - 9. Then recursively calls itself to branch down further using a new current (a value that has not been used). If the branch has reached a dead end without a correct output then it will return to the last point and continue to branch from there. 

k = 3 n= 7

	1	2	3 	4...	9
	|
	2
	|
	3

1 -> 2 -> 3 is size k but less than n, the algorithm goes back to 2 and branches from there

	1	2	3 	4...	9
	|
	2
	|
	4
