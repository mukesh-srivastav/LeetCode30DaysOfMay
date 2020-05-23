import java.util.*; 
public class Day23_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Pair> list = new ArrayList<Pair>();
        
        int i=0, j = 0;
        
        while(i<A.length && j<B.length) {
            int l = Math.max(A[i][0], B[j][0]);
            int r = Math.min(A[i][1], B[j][1]);
            
            if (l<=r) list.add(new Pair(l, r));
            
            if (A[i][1] < B[j][1]) i++;
            else j++;
        }
        
        int s = list.size();
        int a[][] = new int[s][2];
        
        for (i=0; i<s; i++) {
            Pair p = list.get(i);
            a[i][0] = p.i;
            a[i][1] = p.j;
        }
        
        return a;
    }
    
    class Pair {
        int i, j;
        
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}