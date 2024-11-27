import java.util.*;

class Solution {
    public String solution(String rsp) {
        String answer = "";
        Map<String, String> map = new HashMap<>();
        map.put("2", "0");
        map.put("0", "5");
        map.put("5", "2");
        
        for (int i = 0; i < rsp.length(); i++) {
            char c = rsp.charAt(i);
            answer += map.get(String.valueOf(c));
        }
        return answer;
    }
}