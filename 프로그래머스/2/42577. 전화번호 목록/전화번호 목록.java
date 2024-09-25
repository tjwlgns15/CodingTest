import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();

        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String pre = phone.substring(0, i);
                if (set.contains(pre)) {
                    return false;
                }
            }
        }
        
        
        return answer;
    }
}