public class Day9IsPerfectValidSquare {
    
    public boolean isPerfectSquare(int num) {
        
        long low = 1;
        long high = Integer.MAX_VALUE;
        
        while (low <= high) {
            long mid = low + (high - low)/2;
            long midSq = mid * mid;
            if (midSq == num) {
                return true;
            }
            else 
            if (midSq > num)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return false;
    }
}