import java.util.*;
/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 */
public class Day18_PermutationInString {
    public boolean checkInclusion(String p, String s) {
        int a[] = new int[26];
        
        for (int i=0; i<p.length(); i++) {
            a[p.charAt(i) - 'a']++;
        }
        
        if (p.length() > s.length())
            return false;
        
        int left = 0, right = 0;
        int b[] = new int[26];
        
        while (right < s.length()) {
            char start = s.charAt(left);
            char curr = s.charAt(right);
            
            int currLen = right - left + 1;
            b[curr - 'a']++;
            
            if (currLen < p.length()) {
                right++;
                continue;
            }
            
            if (Arrays.equals(a, b))
                return true;
            
            b[start - 'a']--;
            left++;
            right++;
        }
        
        return false;
    }
}