import java.util.*;
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
public class Day29_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(numCourses);
        
        for (int i=0; i<numCourses; i++) {
            g.add(new ArrayList<Integer>());
        }
        
        boolean visited[] = new boolean[numCourses];
        boolean inTheCall[] = new boolean[numCourses];
        
        for(int i=0; i<prerequisites.length; i++) {
            int target =  prerequisites[i][0];
            int pre =  prerequisites[i][1];
            g.get(target).add(pre);
        }
        
        for (int i=0; i<numCourses; i++) {
            if (visited[i] == false) {
                if (isCyclic(i, g, visited, inTheCall))
                    return false;
            }
        }
        
        return true;
    }
    
    boolean isCyclic(int v, ArrayList<ArrayList<Integer>> g, boolean[] visited, boolean[] inTheCall)
    {
        visited[v] = true;
        inTheCall[v] = true;
        
        for (int i=0; i<g.get(v).size(); i++) {
            int adj = g.get(v).get(i);
            
            if (visited[adj] == false) {
                if (isCyclic(adj, g, visited, inTheCall))
                    return true;
            } else if (inTheCall[adj])
                return true;
        }
        
        inTheCall[v] = false;
        return false;
    }
}