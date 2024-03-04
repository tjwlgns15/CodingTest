class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 0;
        String binary = Integer.toBinaryString(n);        
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                num++;
            }
        }        
        
        for (int i = n + 1; ; i++) {
            String binary2 = Integer.toBinaryString(i);
            int num2 = 0;            
            for (int j = 0; j < binary2.length(); j++) {
                if (binary2.charAt(j) == '1') {
                    num2++;
                }                
            }
            if (num == num2) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}