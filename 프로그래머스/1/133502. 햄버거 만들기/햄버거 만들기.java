import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i : ingredient) {
            stack.push(i);

            if (stack.size() >= 4) {
                int size = stack.size();

                String s = stack.get(size - 4).toString() +
                        stack.get(size - 3).toString() +
                        stack.get(size - 2).toString() +
                        stack.get(size - 1).toString();
                
                if (s.equals("1231")) {
                    for (int j = 0; j < 4; j++) {
                        stack.pop();
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}
