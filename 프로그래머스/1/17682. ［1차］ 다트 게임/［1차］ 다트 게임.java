import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> scores = new ArrayList<>();

        int i = 0;  // 위치
        while (i < dartResult.length()) {
            int score = 0;
            
            if (i + 1 < dartResult.length() && 
                Character.isDigit(dartResult.charAt(i)) && 
                Character.isDigit(dartResult.charAt(i + 1))) {
                
                score = 10;
                i += 2;
            } else {
                score = Character.getNumericValue(dartResult.charAt(i));
                i++;
            }

            char bonus = dartResult.charAt(i);
            if (bonus == 'D') {
                score = (int) Math.pow(score, 2);
            } else if (bonus == 'T') {
                score = (int) Math.pow(score, 3);
            }
            i++;

            if (i < dartResult.length() && 
                (dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#')) {
                char option = dartResult.charAt(i);

                if (option == '*') {
                    score *= 2;

                    if (!scores.isEmpty()) {
                        scores.set(scores.size() - 1, scores.get(scores.size() - 1) * 2);
                    }
                } else if (option == '#') {
                    score *= -1;
                }
                
                i++;
            }

            scores.add(score);
        }

        int answer = 0;
        for (int s : scores) {
            answer += s;
        }
        return answer;
    }
}