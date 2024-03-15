import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer;
        String str = n + "";
        char[] charArr = str.toCharArray();        
        Arrays.sort(charArr);
        String ansStr = "";
        
        for (int i = charArr.length - 1; i >= 0; i--) {   
            ansStr += charArr[i];
        }
        
        answer = Long.parseLong(ansStr);
        return answer;
    }
}