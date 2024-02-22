import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int price = 0;
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
            price += d[i];
            if (price <= budget) {
                answer++;
            } else {                
                break;
            }
        }
        return answer;        
    }
}