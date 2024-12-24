class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int H = board.length;
        int W = board[0].length;
        int[] dh = { h - 1, h + 1 };
        int[] dw = { w - 1, w + 1 };
        String color = board[h][w];
        
        for (int i : dh) {
            if (0 <= i && i < H && board[i][w].equals(color)) {
                answer++;
            }
        }
        
        for (int i : dw) {
            if (0 <= i && i < W && board[h][i].equals(color)) {
                answer++;
            }
        }
        

        
        return answer;
    }
}