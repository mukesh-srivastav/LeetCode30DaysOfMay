import java.util.*;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
https://leetcode.com/problems/contiguous-array/discuss/653541/Python-HashMap-solution-%2B-Thinking-Process-Diagram
 */
class Day26_Contiguous_Array {

    public int findMaxLength(int[] nums) {
        int count = 0; 
        int result = 0;
        HashMap<Integer, Integer> hs = new HashMap<Integer,Integer>();
        hs.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                count -= 1;
            }
            
            if (hs.containsKey(count)) {
                result = Math.max(result, i - hs.get(count));
            } else {
                hs.put(count, i);
            }
        }
        
        return result;
    }

}