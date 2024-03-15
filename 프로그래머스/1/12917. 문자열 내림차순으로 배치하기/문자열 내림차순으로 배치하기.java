import java.util.Arrays;

class Solution {
    public String solution(String s) {        
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        reversArr(charArr);
        String answer = new String(charArr);
        
        return answer;
    }
    
    public static void reversArr(char[] c) {
        int k;
        char temp;
        for (int i = 0; i < c.length / 2; i++) {
            k = c.length - i - 1;
            temp = c[i];
            c[i] = c[k];
            c[k] = temp;            
        }
    }
}