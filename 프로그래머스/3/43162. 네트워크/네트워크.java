class Solution {
    public int solution(int n, int[][] computers) {

        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, boolean[] visited, int current) {
        visited[current] = true;
        
        for (int i = 0; i < computers[0].length; i++) {
            if (computers[current][i] == 1 && !visited[i]) { // 연결o, 방문x
                dfs(computers, visited, i);
            }
        }
    }
}