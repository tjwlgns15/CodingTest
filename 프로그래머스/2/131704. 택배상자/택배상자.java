import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int box = 1;

        for (int o : order) {
            while (box <= o) {
                stack.push(box++);
            }
            if (stack.peek() == o) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
