# [#453 Minimum Moves to Equal Array Elements](https://leetcode.com/problems/range-sum-query-2d-immutable)
---
## Problem
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

	Input:
	[1,2,3]

	Output:
	3

	Explanation:
	Only three moves are needed (remember each move increments two elements):

	[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]


## Solution

### 1st attempt solution (time exceeded)
I decided to sort the array since it was not guaranteed. Then I saw in each iteration the difference of the largest element nums[nums.length - 1] and the smallest element nums[0] could increment the counter. After each iteration, the array would need to be sorted again and this process would repeat until the first element is equal to the last element. This produced an time exceeded error because for largest arrays and arrays with large gaps, the solution would loop excessly.

### Optimal solution
I wrote down examples and looked for a pattern
	
	[1, 2, 3]		sum = 6		3 - 1 = 2; 2 - 1 = 1		ans = 2 + 1 = 3 ✓
	[1, 2, 2]		sum = 5		2 - 1 = 1; 2 - 1 = 1 		ans = 1 + 1 = 2 ✓
	[1, 1, 2]		sum = 4		2 - 1 = 1; 1 - 1 = 0		ans = 1 + 0 = 1 ✓

So with the array sorted, I just needed to iterate through the array and take the current element and subtract it from the first element in the array and accumlate that. 

### Remarks
Arrays.sort in Java uses QuickSort, which has runtime of O(nlogn) and it needs to iterate n times sum the counter so the time complexity is O(n) + O(nlogn).

Yet, this did not pass all test cases; however, there was a missing variable in this equation, the min value.

	sum(nums) - min(nums) * nums.length = ans

I discovered that nums.length needed to be multiply by the min of the array because from the first solution there was a need to check that the first element(the min) was not equals to the last element (the max). 


public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            counter += nums[i] - nums[0];
        }
        return counter;
    }
}