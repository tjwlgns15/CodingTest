class Solution {
    public int solution(String t, String p) {
        t = t.trim();
        p = p.trim();
        
        int answer = 0;
        Long intP = Long.parseLong(p);
        int tLen = t.length();
        int pLen = p.length();
        
        for (int i = 0; i <= tLen - pLen; i++) {
            String subsT = t.substring(i, i + pLen);
            Long intT = Long.parseLong(subsT);
            if (intT <= intP) {
                answer++;
            }
            
        }
        return answer;
    }
}