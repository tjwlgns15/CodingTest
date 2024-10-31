class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possibles = {"aya", "ye", "woo", "ma"};

        for (String str : babbling) {
            boolean isValid = true;

            for (String possible : possibles) {
                if (str.contains(possible.repeat(2))) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                for (String possible : possibles) {
                    str = str.replace(possible, " ");
                }

                if (str.trim().isEmpty()) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}