import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 1; i < r2; i++) {
            long max = (long)Math.sqrt((long)r2 * r2 - (long)i * i);
            long min;
            
            if(r1 <= i) {
                min = 1;
            } else {
                double sqrtVal = Math.sqrt((long)r1 * r1 - (long)i * i);
                if(sqrtVal == (long)sqrtVal) {
                    min = (long)sqrtVal;
                } else {
                    min = (long)sqrtVal + 1;
                }
            }
            
            answer += (max - min + 1);
        }
        
        answer *= 4;
        
        answer += (long)Math.floor(Math.sqrt((long)r2 * r2 - (long)r2 * r2)) * 4;
        
        answer += (r2 - r1 + 1) * 4;
        
        return answer;
    }
}