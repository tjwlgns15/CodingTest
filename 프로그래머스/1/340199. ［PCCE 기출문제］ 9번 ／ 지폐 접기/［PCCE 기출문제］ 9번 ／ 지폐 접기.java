import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int ww = wallet[0];
        int wh = wallet[1];
        
        int bw = bill[0];
        int bh = bill[1];
        
        while ((ww < bw || wh < bh) && (ww < bh || wh < bw)) {
            if (bw > bh) {
                bw /= 2;
            } else {
                bh /= 2;
            }
            answer++;
        }
        
        
        return answer;
    }
}