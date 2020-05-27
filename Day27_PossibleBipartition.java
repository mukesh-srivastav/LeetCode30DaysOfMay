import java.util.*;
/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
https://www.youtube.com/watch?v=wciOFao3IFU
 */
public class Day27_PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>(N+1);
        
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        int group[] = new int[N+1];
        
        for (int i=0; i<dislikes.length; i++) {
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i=1; i<=N; i++) {
            if (group[i] == 0) {
                group[i] = 1;
                q.offer(i);
                
                while(q.isEmpty() == false) {
                    int u = q.poll();
                    
                    for (int j : graph.get(u)) {
                        if (group[j] == 0) {
                            if (group[u] == 1)
                                group[j] = 2;
                            else
                                group[j] = 1;
                            
                            q.offer(j);
                        } else if (group[j] == group[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}