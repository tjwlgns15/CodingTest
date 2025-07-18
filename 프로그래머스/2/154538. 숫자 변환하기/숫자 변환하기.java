import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int answer = current[1];
            
            if (y == value) {
                return answer;
            }

            int[] newValue = {value + n, value * 2, value * 3};
            for (int v : newValue) {
                if (v <= y && !visited[v]) {
                    queue.offer(new int[]{v, answer + 1});
                    visited[v] = true;
                }
            }
        }

        return -1;
    }
}