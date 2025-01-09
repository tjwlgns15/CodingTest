import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : skip.toCharArray()) {
            set.add(c);
        }
        
        for (char c : s.toCharArray()) {
            int i = 0;
            char newChar = c;
            
            while (i < index) {
                newChar++;
                
                if (newChar > 'z') {
                    newChar = 'a';
                }
                if (!set.contains(newChar)) {
                    i++;
                }
            }
            sb.append(newChar);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}