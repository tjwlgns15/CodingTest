class Solution {
    public int solution(int n) {
        String ternary = "";
        while (n > 0) {
            ternary += n % 3;
            n /= 3;
        }

        int answer = 0;        
        for (int i = 0; i < ternary.length(); i++) {
            char digitChar = ternary.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            answer += (digit * Math.pow(3, ternary.length() - 1 - i));
        }

        return answer;
    }
}
