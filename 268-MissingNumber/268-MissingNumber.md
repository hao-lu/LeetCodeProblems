# [#268 Missing Number](https://leetcode.com/problems/missing-number/)
---
## Problem
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example:

	Given nums = [0, 1, 3] return 2.

### Notes

- Time complexity: O(n)
- Space complexity: O(n)

## Solution
The given array of numbers can be simply thought as a series of numbers and with series, the sum of the n terms of the series can be calculated with a formula. After calculating the sum of the series to n, the array size, I substracted the sum of all the elements inside the array.


S<sub>n</sub> = n (a<sub>1</sub> + a<sub>2</sub>) / 2  
a<sub>1</sub> = first term  
a<sub>2</sub> = second term

	sum = sum of all elements in the array 
	S = nums.length * (nums.length + 1) / 2 - sum
    
    nums.length + 1: for inclusive of the last element