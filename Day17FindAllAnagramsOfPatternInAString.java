import java.util.*;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
Explanation: 
1) Store counts of frequencies of pattern in first count array countP[]. Also store counts of frequencies of characters in first window of text in array countTW[].

2) Now run a loop from i = M to N-1. Do following in loop.
…..a) If the two count arrays are identical, we found an occurrence.
…..b) Increment count of current character of text in countTW[]
…..c) Decrement count of first character in previous window in countWT[]

3) The last window is not checked by above loop, so explicitly check it.
Based on Robin Karp Algorithm.
 */
public class Day17FindAllAnagramsOfPatternInAString {
    public boolean compare(int a[], int b[]) {
        for (int i=0; i<256; i++) {
            if (a[i] != b[i])
                return false;
        }
        
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        int max = 256;
        int pat[] = new int[max];
        int textW[] = new int[max];
        int m = p.length();
        int n = s.length();
        
        List<Integer> list = new ArrayList<Integer>();
        
        if (n < m) {
            return list;
        }
        for (int i=0; i<m; i++) {
            (pat[p.charAt(i)])++;
            (textW[s.charAt(i)])++;
        }
        
        for (int i=m; i < n; i++) {
            if (compare(pat, textW)) {
                list.add(i-m);
            }
            
            (textW[s.charAt(i)])++;
            (textW[s.charAt(i - m)])--;
        }
        
        if (compare(pat, textW)) {
                list.add(n-m);
            }
        
        return list;
    }
}