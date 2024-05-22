import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};        
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            
            if (ans == person1[i % person1.length]) {
                count[0]++;
            }
            
            if (ans == person2[i % person2.length]) {
                count[1]++;
            }                   
            
            if (ans == person3[i % person3.length]) {
                count[2]++;
            }
        }
        
        int maxValue = 0;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxValue) {
                maxValue = count[i];
                indexList.clear();
                indexList.add(i + 1);
            } else if(count[i] == maxValue) {
                indexList.add(i + 1);
            }
        }
        
        int[] answer = new int[indexList.size()];
        for (int i = 0; i < indexList.size(); i++) {
            answer[i] = indexList.get(i);
        }
        return answer;
    }
}