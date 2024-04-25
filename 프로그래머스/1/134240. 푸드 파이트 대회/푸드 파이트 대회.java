class Solution {
    public String solution(int[] food) {        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < food.length; i++) {
            if (food[i] < 2) {                
                continue;                
            }
            
            int num = food[i] / 2;
            sb.insert(sb.length() / 2, String.valueOf(i).repeat(num * 2));
        }
        
        sb.insert(sb.length() / 2, '0');
        String answer = sb.toString();
        
        return answer;
    }
}
