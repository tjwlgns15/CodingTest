import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int count = i + 1;

                if (!map.containsKey(c) || map.get(c) > count) {
                    map.put(c, count);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalCount = 0;

            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);

                if (!map.containsKey(c)) {
                    totalCount = -1;
                    break;
                }

                totalCount += map.get(c);
            }
            answer[i] = totalCount;
        }

        return answer;
    }
}