import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> r = new HashMap<>();
        
        for (int i : topping) {
            r.put(i, r.getOrDefault(i, 0) + 1);
        }
        
        Set<Integer> l = new HashSet<>();
        
        for (int i = 0; i < topping.length; i++) {
            int j = topping[i];
            l.add(j);
            
            r.put(j, r.get(j) - 1);
            if (r.get(j) == 0) {
                r.remove(j);
            }
            
            if (l.size() == r.size()) {
                answer++;
            }
        }
                
        return answer;
    }
}