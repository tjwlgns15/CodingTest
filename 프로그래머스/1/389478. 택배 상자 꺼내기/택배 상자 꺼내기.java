class Solution {
    public int solution(int n, int w, int num) {
        if (w == 1) {
            return n - num + 1;
        }

        int height = (n + w - 1) / w;
        
        int row = (num - 1) / w;
        int col = (num - 1) % w;
        
        if (row % 2 == 1) {
            col = w - col - 1;
        }
        
        int topRow = height - 1;
        int topCol = n % w == 0 ? w - 1 : (n % w) - 1;
        
        if (topRow % 2 == 1) {
            topCol = w - topCol - 1;
        }
        
        int answer = topRow - row;
        
        if (topRow % 2 == 0) {
            if (0 <= col && col <= topCol) {
                answer++;
            }
        } else {
            if (topCol <= col && col < w) {
                answer++;
            }
        }
        
        return answer;
    }
}