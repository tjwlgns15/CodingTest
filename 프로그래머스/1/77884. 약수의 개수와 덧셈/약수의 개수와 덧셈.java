class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            int sqrt = (int) Math.sqrt(i);
            
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    cnt += (j * j == i) ? 1 : 2;
                }
            }
            answer += (cnt % 2 == 0) ? i : -i;
        }
        return answer;
    }
}
