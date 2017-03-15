# [#304 Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/)
---
## Problem
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Example:

    Given matrix = [
      [3, 0, 1, 4, 2],
      [5, 6, 3, 2, 1],
      [1, 2, 0, 1, 5],
      [4, 1, 0, 1, 7],
      [1, 0, 3, 0, 5]
    ]

    sumRegion(2, 1, 4, 3) -> 8
    sumRegion(1, 1, 2, 2) -> 11
    sumRegion(1, 2, 2, 4) -> 12

### Notes
- You may assume that the matrix does not change.
- There are many calls to sumRegion function.
- You may assume that row1 ≤ row2 and col1 ≤ col2.

## Solution
Due to the fact that the matrix is immutable and I know it will always be 5x5, I can do some memoization and save computation time by trading space. If I were to compute the sum of the desired area every time it would O(*mn*) since it would need to access each index to produce a sum, iterating *m* rows x *n* cols times. 

First I created a *m + 1 x n + 1* sum matrix to store all the sums; however, increased the size by 1 for *m* and *n* because of edge cases. The edge cases being any rectangle who touches edge indices in the matrix, e.g., (0, 0, 1, 1).

On the instantiation of the Object, NumMatrix, it will compute the sum from [0][0] to all indices [i][j] and save them into the sum matrix of size [*m + 1*] x  [*n + 1*]. 

On the method call, sumRegion on the Object, it will access the total sum from [0][0] to [row2][col2] and subtract the surrounding sums in the sum matrix and return the sum within the rectangle. 

### Example
Instantiation of NumMatrix will produce this sum matrix

    [3 0 1 4 2]             [0 0 0 0 0 0]
    [5 6 3 2 1]             [0 3 3 4 8 10]
    [1 2 0 1 5]     =>      [0 8 14 18 24 27]
    [4 1 0 1 7]             [0 9 17 21 28 36]
    [1 0 3 0 5]             [0 13 22 26 34 39]
                            [0 14 23 30 38 58]

Calling the sum array

    r = 1 c = 1
    sum[r][c] = matrix[r-1][c-1] + sum[r][c-1] + sum[r-1][c] - sum[r-1][c-1]

sumRegion method call

    (2, 1, 4, 3)
    row1 = 2 col1 = 1
    row2 = 4 col2 = 3
    
    sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1]
                38          -           24        -         14          +       8 
    ans = 8



## Remarks 
The runtime time complexity for accessing data from an array in O(1), therefore, each method call takes O(1). However, this solution does have O(*(m+1) x (n+1)*) space complexity because it stores the sums from [0][0] to all indices [i][j].
