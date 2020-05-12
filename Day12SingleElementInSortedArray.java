/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. 
 * Find this single element that appears only once.
 * Your solution should run in O(log n) time and O(1) space.
 */
class Day12SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if (nums[mid] == nums[mid^1])
                low = mid+1;
            else
                high = mid;
        }
        return  nums[high];
    }
}

/**
 * Idea behind the solution:

If the current index in the binary search is I (0 index based), the we can decide the next search space based on:
a. If I is even, and nums[I] == nums[I + 1], then size of subarray [0...I-1] (left side) is even (since the element count is I), so left side does not contain the single occurance element. Hence we need to check in [I + 1, ..., N] subarray (right side of I)
b. If I is odd, and nums[I] == nums[I - 1], then size of subarray [0...I-2] (left side) is even (since the element count is I - 1, and I-1 is even since I is odd), so left side does not contain the single occurance element. Hence we need to check in [I + 1, ..., N] subarray (right side of I)

Note: How can you implement the check operation. Remember the xor operation, and if you xor any number with 1, then it flips the LSB (Least significant bit)
Ex. 1) 100^1=101 [i.e 4^1=5, flips the first bit from right side]
2) 101^1=100 [i.e 5^1=4, again flips the first bit from right side]
So, if I is even, to find the next element we do I^1
and if I is odd, to find the previous element we do I^1
 */