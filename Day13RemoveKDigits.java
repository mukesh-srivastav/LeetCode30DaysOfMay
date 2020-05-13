import java.util.*;
/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 */
public class Day13RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k==0) return num;
        if (k==n) return "0";
        
        Stack<Character> stack = new Stack<>();
        int curr = 0;
        char [] str = num.toCharArray();
        
        
        
        while (curr<n) {
            while (k>0 && !stack.isEmpty() && stack.peek() > str[curr]) {
                k--;
                stack.pop();
            }
            
            stack.push(str[curr]);
            curr++;
        }
        
        while (k-- >0) {
            stack.pop();
        }
        
        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        
        while(res.length() > 1 && res.charAt(0) == '0') {
            res = res.substring(1);
        }
        
        return res;
    }
}