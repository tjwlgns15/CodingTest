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
            for (int j = 0; j < photo[i].length; j++) {
                if (nyMap.containsKey(photo[i][j])) {
                    answer[i] += nyMap.get(photo[i][j]);
                } else {                    
                    answer[i] += 0;
                }
            }
            
        }
        
        return answer;
    }
}