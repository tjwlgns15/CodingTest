import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] chars = {'A', 'E', 'I', 'O', 'U'};
        int[] weight = {
            1 + 5 + 25 + 125 + 625,
            1 + 5 + 25 + 125,
            1 + 5 + 25,
            1 + 5,
            1
        };
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            int idx = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c) {
                    idx = j;
                    break;
                }
            }
            
            answer += idx * weight[i] + 1;
        }
        
        return answer;
    }
}