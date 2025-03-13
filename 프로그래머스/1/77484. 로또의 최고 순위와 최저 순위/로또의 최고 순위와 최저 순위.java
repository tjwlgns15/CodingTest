import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        int matchCount = 0;
        int zeroCount = 0;
        
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            }
            set.add(num);
        }
        
        for (int num : win_nums) {
            if (set.contains(num)) {
                matchCount++;
            }
        }

        int maxRank = getRank(matchCount + zeroCount);
        int minRank = getRank(matchCount);
        
        int[] answer = {maxRank, minRank};        
        return answer;
    }
    
    private int getRank(int count) {
        if (count == 6) return 1;
        if (count == 5) return 2;
        if (count == 4) return 3;
        if (count == 3) return 4;
        if (count == 2) return 5;
        return 6;
    }
}