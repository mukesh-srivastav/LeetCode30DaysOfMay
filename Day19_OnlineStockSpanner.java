import java.util.*;

public class Day19_OnlineStockSpanner {
    
    Stack<int[]> s;
    
    public Day19_OnlineStockSpanner() {
        s = new Stack<>();    
    }
    
    public int next(int price) {
        int span = 1; 
        while (!s.empty() && price >= s.peek()[0]) {
            span += s.peek()[1];
            s.pop();
        }
        s.push(new int[]{price, span});
        return span;
    }
    
    
    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
}