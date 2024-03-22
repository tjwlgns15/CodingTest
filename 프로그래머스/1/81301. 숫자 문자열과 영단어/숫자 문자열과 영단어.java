class Solution {
    public int solution(String s) {
        String answer = "";
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};        
        
        
        while(s.length() > 0) {
            if ('0' <= s.charAt(0) && s.charAt(0) <= '9') {
                answer += s.charAt(0);
                s = s.substring(1);
                continue;
            }
            for (int i = 3; i <= 5; i++) {
                if(s.length() < i) {
                    continue;
                }
                String substr = s.substring(0, i);
                for (int j = 0; j < strArr.length; j++) {                   
                    if (substr.equals(strArr[j])) {
                        answer += j;
                        s = s.substring(i);
                        break;
                    }
                }                
            }
        }
        
        
        return Integer.parseInt(answer);
    }
}