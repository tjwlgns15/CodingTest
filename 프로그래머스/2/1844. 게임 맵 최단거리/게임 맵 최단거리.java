import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int yLen = maps.length;
        int xLen = maps[0].length;
        int[] movedX = {-1, 1, 0, 0};
        int[] movedY = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();        
        queue.offer(new int[] {0, 0});
        
        int[][] visited = new int[yLen][xLen];
        visited[0][0] = 1; // 이동 횟수
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            
            if (y == yLen - 1 && x == xLen - 1) {
                return visited[y][x];
            }
            
            for (int i = 0; i < 4; i++) {
                int newY = y + movedY[i];
                int newX = x + movedX[i];
                
                if (newY >= 0 && newY < yLen && 
                    newX >= 0 && newX < xLen &&
                    maps[newY][newX] == 1 && 
                    visited[newY][newX] == 0) {
                    
                    queue.offer(new int[] {newY, newX});
                    visited[newY][newX] = visited[y][x] + 1;
                }
            }
        }
        
        return -1;        
    }
}