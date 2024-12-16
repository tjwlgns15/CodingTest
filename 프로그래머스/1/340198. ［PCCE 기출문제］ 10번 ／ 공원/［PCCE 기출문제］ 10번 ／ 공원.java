import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
                
        int row = park.length;
        int col = park[0].length;
        
        Integer[] sortedMats = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedMats, Collections.reverseOrder());
        
        for (int mat : sortedMats) {
            for (int i = 0; i <= row - mat; i++) {
                for (int j = 0; j <= col - mat; j++) {
                    if (checkSpace(mat, i, j, park)) {
                        return mat;
                    }
                }
            }
        }
        
        return -1;
    }

    private static boolean checkSpace(int mat, int row, int col, String[][] park) {
        for (int i = row; i < row + mat; i++) {
            for (int j = col; j < col + mat; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}