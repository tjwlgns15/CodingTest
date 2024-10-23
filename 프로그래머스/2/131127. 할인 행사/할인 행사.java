import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();        
        for (int i = 0; i < number.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean check = true;
            for (String product : wantMap.keySet()) {
                if (wantMap.get(product) - discountMap.getOrDefault(product, 0) > 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }
 

        return answer;
    }
}