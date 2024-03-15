public class Solution {
    public int[] solution(String s) {        
        int[] answer = new int[2];
        answer = binary1(s, 0, 0);
        return answer;
    }
    
    public static int[] binary1(String s, int count, int removedZero) {        
        int originLen = s.length();
        String new_s = s.replace("0", "");
        int removed = originLen - new_s.length();                
        String new_new_s = Integer.toBinaryString(new_s.length());
                
        count++;
        removedZero += removed;
                
        if (new_new_s.equals("1")) {
            return new int[]{count, removedZero};
        }        
        
        return binary1(new_new_s, count, removedZero);
    }
}
