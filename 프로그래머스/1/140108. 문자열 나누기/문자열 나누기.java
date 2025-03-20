class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(0);
            
            if (c == s.charAt(i)) {
                cnt1++;
            } else {
                cnt2++;
            }
            
            if (cnt1 == cnt2) {
                answer++;
                cnt1 = 0;
                cnt2 = 0;
                
                if (i + 1 < s.length()) {
                    s = s.substring(i + 1);
                    i = -1;
                }
            }
        }
        
        if (cnt1 != 0 || cnt2 != 0) {
            answer++;
        }
        
        return answer;
    }
}