class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        for (int i = 1; i < words.length; i++) {            
            String frontWord = words[i - 1];            
            String backWord = words[i];
            
            for (int j = 0; j < i; j++) {                
                if (words[i].equals(words[j]) || frontWord.charAt(frontWord.length() - 1) != backWord.charAt(0)) {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    
                    return answer;
                }
                    
            }
            
        }
        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }
}