class Solution {
    public int[] solution(int n) {
        int len = (n % 2 == 0) ? n / 2 : n / 2 + 1;
        int[] answer = new int[len];
        System.out.println(len);
        int val = 1;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = val;
            val += 2;
        }
        return answer;
    }
}