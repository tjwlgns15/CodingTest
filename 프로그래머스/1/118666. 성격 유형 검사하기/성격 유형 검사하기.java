import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> scores = new HashMap<>();
        scores.put('A', 0); scores.put('N', 0);
        scores.put('C', 0); scores.put('F', 0);
        scores.put('M', 0); scores.put('J', 0);
        scores.put('R', 0); scores.put('T', 0);
        
        for (int i = 0; i < survey.length; i++) {
            char s1 = survey[i].charAt(0);
            char s2 = survey[i].charAt(1);
            int c = choices[i];
            int score = Math.abs(c - 4);

            if (c < 4) {
                scores.put(s1, scores.get(s1) + score);
            } else if (c > 4) {
                scores.put(s2, scores.get(s2) + score);
            }
        }

        answer += scores.get('R') >= scores.get('T') ? 'R' : 'T';
        answer += scores.get('C') >= scores.get('F') ? 'C' : 'F';
        answer += scores.get('J') >= scores.get('M') ? 'J' : 'M';
        answer += scores.get('A') >= scores.get('N') ? 'A' : 'N';
        
        return answer;
    }
}