import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String key = clothe[1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int count : map.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}