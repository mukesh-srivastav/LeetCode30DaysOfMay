public class Day8CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <=2)
            return true;
        
        float m = slope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        
        for (int i=2; i<coordinates.length; i++) {
            float s = slope(coordinates[i-1][0], coordinates[i-1][1], coordinates[i][0], coordinates[i][1]);
            
            if (s!=m)
                return false;
        }
        
        return true;
    }
    
    float slope(float x1, float y1, float x2, float y2) {
        return (y2-y1)/(x2-x1);
    }
}