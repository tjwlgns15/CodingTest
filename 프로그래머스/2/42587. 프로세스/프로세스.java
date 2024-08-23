import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<int[]> queue = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            int[] arr = {priorities[i], i};
            queue.offer(arr);
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            boolean existHigher = false;

            for (int[] process : queue) {
                
                if (process[0] > poll[0]) {
                    queue.offer(poll);
                    existHigher = true;
                    break;
                }
            }
            
            if (!existHigher) {
                answer++;
                
                if (poll[1] == location) {
                    return answer;
                }
            }
        }
        return -1;
    }
}