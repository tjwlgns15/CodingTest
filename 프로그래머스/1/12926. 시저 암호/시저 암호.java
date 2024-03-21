class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] charr = s.toCharArray();
        for(char ch : charr) {
            if (ch != ' ') {
                int ascii = (int) ch + n;                
                if ('a' <= ch && ch <= 'z') {
                    if (ascii > 'z') {
                        ascii -= 26;
                    }
                } else if ('A' <= ch && ch <= 'Z') {
                    if (ascii > 'Z') {
                        ascii -= 26;
                    }
                }
                ch = (char) ascii;
            }
            answer += ch;

        }        
        return answer;
    }
}