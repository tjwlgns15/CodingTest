class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = 0, e = 0;
        int sum = sequence[0];
        int minLen = Integer.MAX_VALUE;
        int[] answer = {-1, -1};

        while (e < sequence.length) {
            if (sum < k) {
                e++;
                if (e < sequence.length) {
                    sum += sequence[e];
                }
            } else if (sum > k) {
                sum -= sequence[s];
                s++;
            } else {
                if (e - s < minLen) {
                    minLen = e - s;
                    answer[0] = s;
                    answer[1] = e;
                }
                sum -= sequence[s];
                s++;
            }
        }
        return answer;
    }
}