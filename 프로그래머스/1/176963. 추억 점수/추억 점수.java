import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int [photo.length];
        Map<String, Integer> nyMap = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            nyMap.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                Integer yearningValue = nyMap.get(photo[i][j]);
                if (yearningValue != null) {
                    sum += yearningValue;
                }
            }
            answer[i] = sum;  
        }
        
        return answer;
    }
}