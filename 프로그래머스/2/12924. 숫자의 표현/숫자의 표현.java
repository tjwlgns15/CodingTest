class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1; i < n / 2 + 1; i++) {
            int num = 0;
            for (int j = i; j < n; j++) {
                num += j;
                if (num == n) {
                    answer++;
                    break;
                } else if (num > n) {
                    break;
                }                
            }
        }           
        
        return answer;
    }
}