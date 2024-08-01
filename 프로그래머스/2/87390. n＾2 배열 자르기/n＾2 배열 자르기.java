import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> ansList = new ArrayList<>();
        int leftInt = (int)left;
        int rightInt = (int)right;

        for(long i = left; i <= right; i++){
            if(i / n <= i % n)
                ansList.add((int)(i % n) + 1);
            else
                ansList.add((int)(i / n) + 1);
        }

        int[] answer = new int[ansList.size()];

        for(int i = 0; i < answer.length; i++)
            answer[i] = ansList.get(i);

        return answer;
    }
}