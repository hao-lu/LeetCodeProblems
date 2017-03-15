# [#187 Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)
---
## Problem
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

	Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

	Return:
	["AAAAACCCCC", "CCCCCAAAAA"].

## Solution
Sets were needed in order to produce a relatively optimal solution. Sets have a contains() function that runs in constant time O(1). Increment 10 down the given String and add the 10-letter-long sequence to a Set, checkSeq. If the same sequence occurs and tries to add the checkSeq Set, it will return false and then it will add to another set, repeatedSeq, which indictes there is a repeated sequence in the String s. 

### Remarks
The look-up time for Sets are O(1) and we have to iterate through s.length - 9, which is essentially O(n); therefore, we have a time complexity of O(n). However, we do have a space complexity of O(n - 9 + m) = O(n + m). 