
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i < right + 1; i++) {
            int cnt = 0;
            int root = (int)Math.sqrt(i);
            
            for (int j = 1; j < root + 1; j++) {
                if (i % i == 0) {
                    if (j * j == i) {
                        cnt++;
                    } else {
                        cnt += 2;
                    }                        
                }
            }
            if (cnt % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}