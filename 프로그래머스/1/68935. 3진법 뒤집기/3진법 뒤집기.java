class Solution {
    public int solution(int n) {
        StringBuilder ternary = new StringBuilder();
        while (n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }

        int answer = 0;
        String strTernary = ternary.toString();
        for (int i = 0; i < strTernary.length(); i++) {
            char digitChar = strTernary.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            answer += (digit * Math.pow(3, strTernary.length() - 1 - i));
        }

        return answer;
    }
}
