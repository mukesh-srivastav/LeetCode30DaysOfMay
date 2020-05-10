/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

EXPLANATION:-
Given constraints are
1. The judge believes no one.
2. Everybody believes judge.
so, from these two points, we can say that if any person is trusted by N - 1 persons and the same person believes no one, then we can say that he is a judge.

```
Now, let's do this in program.
1. Create an array of Size N + 1 to represent each person.
   arr[i] represents trust score of i th person
   and arr[i] = number of persons trusts him - number of 
   persons he trusts.
2. Now, traverse through given array. 
    a, b = a trusts b.
    if a person trusts others,
	then decrease his score by 1. i.e, arr[a]--
    if a person is trusted by others, 
    then increase his score by 1. i.e, arr[b]++
3. At last traverse through each person,
    if anyone found with N - 1 trusts,
	then return his index.
4. if not found, return -1
 */
public class Day10FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] people = new int[N+1];
        
        
        for (int i=0; i<trust.length; i++) {
            int trustee = trust[i][0];//1
            int trusted = trust[i][1]; //2
            
            people[trustee]--;
            people[trusted]++;
        }
        
        for (int i=1; i<=N; i++) {
            if (people[i] == N-1) {
                return i;
            }
        }
        
        return -1;
    }
}