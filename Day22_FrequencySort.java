import java.util.*;

public class Day22_FrequencySort {
    public String frequencySort(String s) {
        if (s.length() == 0 || s == null) return s;
        
        int count[] = new int[256];
        
        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> count[b] - count[a]);
        
         for(int i = 0; i < 256; i++){
            pq.offer((char)i);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character c = pq.poll();
            for(int i = 0; i < count[c]; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
}