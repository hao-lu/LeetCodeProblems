public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        while (nums[0] != nums[nums.length - 1]) {
            int max = nums[nums.length - 1];
            while (nums[0] < max) {
                for (int i = 0; i < nums.length - 1; i++) {
                    nums[i]++;
                } 
                counter++;
            }
            Arrays.sort(nums);
        }
        return counter;
    }
}


public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        while (nums[0] != nums[nums.length - 1]) {
            int max = nums[nums.length - 1];
            int increment = max - nums[0];
            
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i] += increment;
            }
            
            counter += increment;
            Arrays.sort(nums);
            
        }
        return counter;
    }
}

[1, 2147483647]

public class Solution {
    public int minMoves(int[] nums) {
        int counter = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        return sum - nums[0] * nums.length;
    }
}

public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 1; i < nums.length; i++) {
            counter += nums[i] - nums[0];
        }
        return counter;
    }
}