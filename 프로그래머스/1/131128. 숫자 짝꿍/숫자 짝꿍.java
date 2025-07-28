import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> mapX = new HashMap<>();
        Map<Character, Integer> mapY = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            mapX.put(c, mapX.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            mapY.put(c, mapY.getOrDefault(c, 0) + 1);
        }

        List<Character> common = new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            if (mapX.containsKey(c) && mapY.containsKey(c)) {
                int duplicate = Math.min(mapX.get(c), mapY.get(c));
                for (int i = 0; i < duplicate; i++) {
                    common.add(c);
                }
            }
        }

        if (common.isEmpty()) {
            return "-1";
        }
        
        boolean flag = true;
        for (Character c : common) {
            if (c != '0') {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            return "0";
        }
        
        common.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Character c : common) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}