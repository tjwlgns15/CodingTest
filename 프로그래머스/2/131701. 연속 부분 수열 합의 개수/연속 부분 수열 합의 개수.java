import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {        
        HashSet<Integer> unique = new HashSet<>();
        int len = elements.length;
                
        for (int i = 0; i < len; i++) {
            int sum = 0;
            
            for (int j = 0; j < len; j++) {
                sum += elements[(i + j) % len];
                unique.add(sum);
            }
            
        }
        
        return unique.size();
    }
}