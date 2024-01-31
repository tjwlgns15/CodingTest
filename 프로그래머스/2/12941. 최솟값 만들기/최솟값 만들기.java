import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length / 2; i++) {
            int temp = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = temp;
        }
        for (int i = 0; i < A.length; i++) {
            answer = answer + (A[i] * B[i]);
        }        

        return answer;
    }
}