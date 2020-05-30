import java.util.*;
/**
 * public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));
        
        for (int i=0; i<points.length; i++) {
            pq.add(points[i]);
            
            if (pq.size() > K)
                pq.poll();
        }
        
        int [][] res = new int[K][2];
        
        for (int i=0; i<K; i++){
            res[i] = pq.poll();
        }
        
        return res;
    }
 */
public class Day30_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));
        
        for (int i=0; i<points.length; i++) {
            pq.add(points[i]);
            
            if (pq.size() > K)
                pq.poll();
        }
        
        int [][] res = new int[K][2];
        
        for (int i=0; i<K; i++){
            res[i] = pq.poll();
        }
        
        return res;
    }
}