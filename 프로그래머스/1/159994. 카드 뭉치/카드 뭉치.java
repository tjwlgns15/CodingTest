class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int index1 = 0;
        int index2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            if (goal[i].equals(cards1[index1])) {
                if (cards1.length - 1 > index1) {
                    index1++;                    
                }
            } else if (goal[i].equals(cards2[index2])) {
                if (cards2.length - 1 > index2) {
                    index2++;
                }
                
            } else {
                return answer = "No";
            }
        }
        return answer;
    }
}