class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : myString.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}