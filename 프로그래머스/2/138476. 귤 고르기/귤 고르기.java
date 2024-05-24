import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Integer> l = new ArrayList<>(Collections.nCopies(maxValue(tangerine), 0));
        
        for (int i = 0; i < tangerine.length; i++) {
            int index = tangerine[i] - 1;
            l.set(index, l.get(index) + 1);
        }
        Collections.sort(l);
        
        int i = 0;
        while (k > 0) {
            k -= l.get(l.size() - i - 1);
            i++;
        }
        answer = i;
        
        return answer;
    }
    
    public int maxValue(int[] arr) {
        int max = 0;

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}