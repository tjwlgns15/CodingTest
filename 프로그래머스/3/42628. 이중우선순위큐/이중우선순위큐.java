import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> result = new ArrayList<> ();
        
        for (String s : operations) {
            String[] splitArr = s.split(" ");
            String cmd = splitArr[0];
            Integer value = Integer.parseInt(splitArr[1]);
            
            if (cmd.equals("I")) {
                // add
                result.add(value);
            } else {
                if (!result.isEmpty()) {
                    Integer min = Collections.min(result);
                    Integer max = Collections.max(result);
                    if (value > 0) {
                        // delete Max
                        result.remove(max);                    
                    } else if (value < 0) {
                        // delete Min
                        result.remove(min);
                    }
                }
            }
        }
        
        if (result.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = Collections.max(result);
            answer[1] = Collections.min(result);
        }
        
        
        
        return answer;
    }
}