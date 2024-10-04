import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        char c;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            s = s.substring(1) + s.charAt(0);
            
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);
                
                if (map.containsValue(c)) {
                    stack.push(c);
                } else if (map.containsKey(c)) {                    
                    if (stack.isEmpty() || stack.pop() != map.get(c)) {
                        isValid = false;
                        break;
                    }
                } else {
                    isValid = false;
                    break;
                }
            }
            System.out.println(stack);
            if (isValid && stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}