/**
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * 
 * EXPLANATION:-
EX 1:-
   A = [1, -2, 3, -2]
   max = 3   (This means max subarray sum for normal array)
   min = -2  (This means min subarray sum for normal array)
   sum = 0   (total array sum)
   Maximum Sum = 3 (max)

EX2:-
  A = [5, -3, 5]
  max = 7
  min  = -3
  sum = 7
  maximum subarray sum = 7 - (-3) = 10
  
EX3:-
   A = [3, -1, 2, -1]
   max = 4
   min = -1
   sum = 3
   maximum subarray sum  = sum - min = 3 - (-1) = 4

EX4:-
   A = [-2, -3, -1]
   max = -1
   min = -6
   sum = -6
   In this example, if we do (sum - min) then result is 0. but there is no subarray with sum 0.
   So, in this case we return max value. that is -1.
   
 */

class Day14MaxSubarrayCircularSum {
    public int maxSubarraySumCircular(int[] A) {
        int max_so_far = A[0];
        int max_curr   = A[0];
        
        int min_so_far = A[0];
        int min_curr  = A[0];
        int n = A.length;
        int num;
        int sum = A[0];
        
        for (int i=1; i<n; i++) {
            num = A[i];
            
            max_curr = Math.max(max_curr + num, num);
            max_so_far = Math.max(max_so_far, max_curr);
            
            min_curr = Math.min(min_curr + num, num);
            min_so_far = Math.min(min_so_far, min_curr);
            
            sum += num;
        }
        
        if (sum == min_so_far) return max_so_far;
        
        return (max_so_far > (sum - min_so_far)) ? max_so_far : (sum - min_so_far);
        
    }
}